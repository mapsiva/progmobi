package br.ufms.facom.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufms.facom.contactsapp.database.DBHelper;
import br.ufms.facom.contactsapp.model.Contact;

public class SignUpActivity extends AppCompatActivity {

    DBHelper helper = new DBHelper(this);
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtUsername;
    private EditText edtSenha;
    private EditText edtConfSenha;
    private Button btnSalvar;
    private Contact Contact;
    private Contact altContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        edtNome = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfSenha = findViewById(R.id.edtConfSenha);
        btnSalvar=findViewById(R.id.btnSalvar);
        Intent it=getIntent();

        altContact = (Contact) it.getSerializableExtra("chave_Contact");

        Contact = new Contact();
        if(altContact != null){
            btnSalvar.setText("ALTERAR");
            edtNome.setText(altContact.getName());
            edtEmail.setText(altContact.getEmail());
            edtUsername.setText(altContact.getUsername());
            edtSenha.setText(altContact.getSenha());
            edtConfSenha.setText(altContact.getSenha());
            Contact.setId(altContact.getId());
        }else{
            btnSalvar.setText("SALVAR");
        }
    }
    public void cadastrar(View view) {
        String name = edtNome.getText().toString();
        String email = edtEmail.getText().toString();
        String usuario = edtUsername.getText().toString();
        String senha = edtSenha.getText().toString();
        String confSenha = edtConfSenha.getText().toString();
        if(!senha.equals(confSenha)){
            Toast toast = Toast.makeText(SignUpActivity.this,
                    "Senha diferente da confirmação de senha!",
                    Toast.LENGTH_SHORT);
            toast.show();
            edtSenha.setText("");
            edtConfSenha.setText("");
        }
        else{
            Contact.setName(name);
            Contact.setEmail(email);
            Contact.setUsername(usuario);
            Contact.setSenha(senha);
            if(btnSalvar.getText().toString().equals("SALVAR")) {
                helper.insereContact(Contact);
                Toast toast = Toast.makeText(SignUpActivity.this,
                        "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT);
                toast.show();
            }else{
                helper.atualizarContact(Contact);
                helper.close();
            }
            limpar();
            finish();
        }
    }
    public void limpar(){
        edtNome.setText(""); edtEmail.setText("");
        edtUsername.setText(""); edtSenha.setText("");
        edtConfSenha.setText("");
    }
    public void cancelar(View view) {
        finish();
    }
}