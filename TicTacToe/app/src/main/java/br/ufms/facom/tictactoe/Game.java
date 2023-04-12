package br.ufms.facom.tictactoe;

import android.app.Activity;
import android.widget.Button;

import java.util.Arrays;
import java.util.function.Consumer;

public class Game {
    Integer gameLogic[][] = new Integer[3][3];
    Button gameUI[][] = new Button[3][3];

    boolean turn = false;

    String winner;

    Activity context;

    Consumer<String> winnerCallback;

    public Game (Activity activity, Consumer<String> winnerCallback){
        this.context = activity;
        this.winnerCallback = winnerCallback;
        run();
    }

    public void run (){
        bindUI();
        reset();
        winner = "";
        turn = !turn;
    }

    private void bindUI(){
        gameUI[0][0] = this.context.findViewById(R.id.b0_0);
        gameUI[0][1] = this.context.findViewById(R.id.b0_1);
        gameUI[0][2] = this.context.findViewById(R.id.b0_2);
        gameUI[1][0] = this.context.findViewById(R.id.b1_0);
        gameUI[1][1] = this.context.findViewById(R.id.b1_1);
        gameUI[1][2] = this.context.findViewById(R.id.b1_2);
        gameUI[2][0] = this.context.findViewById(R.id.b2_0);
        gameUI[2][1] = this.context.findViewById(R.id.b2_1);
        gameUI[2][2] = this.context.findViewById(R.id.b2_2);

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int finalI = i;
                int finalJ = j;
                gameUI[i][j].setOnClickListener(view -> {
                    if(turn){
                        gameUI[finalI][finalJ].setText("X");
                        gameLogic[finalI][finalJ] = 1;
                    }
                    else {
                        gameUI[finalI][finalJ].setText("O");
                        gameLogic[finalI][finalJ] = 0;
                    }

                    if(checkWinner()){
                        reset();
                        winner = turn? "X": "O";
                        winnerCallback.accept(winner);
                        return;
                    }
                    turn = !turn;


                });
            }
        }
    }

    private boolean checkWinner (){
        int player = turn? 1 : 0;

        //linhas
        for (int i = 0; i < 3; i++){
            if(gameLogic[i][0] + gameLogic[i][1] + gameLogic[i][2] == 3 * player){
                return true;
            }
        }
        // colunas
        for (int i = 0; i < 3; i++){
            if(gameLogic[0][i] + gameLogic[1][i] + gameLogic[2][i] == 3 * player){
                return true;
            }
        }

        // diagonal principal
        if(gameLogic[0][0] + gameLogic[1][1] + gameLogic[2][2] == 3 * player){
            return true;
        }

        // dignonal secundária
        if(gameLogic[0][2] + gameLogic[1][1] + gameLogic[2][0] == 3 * player){
            return true;
        }

        return false;
    }

    public void reset (){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameUI[i][j].setText("");
                gameLogic[i][j] = 1000;
            }
        }
    }
}
