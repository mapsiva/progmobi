package br.ufms.facom.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.ufms.facom.contactsapp.database.DBHelper;
import br.ufms.facom.contactsapp.model.Contact;

public class HomeActivity extends AppCompatActivity {

    private TextView txtNome;
    private ListView listContacts;
    DBHelper helper;
    Contact contact;
    ArrayList<Contact> arrayListContact;
    ArrayAdapter<Contact> arrayAdapterContact;
    private int id1,id2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtNome = findViewById(R.id.txtNome);

        Bundle args = getIntent().getExtras();
        String name = args.getString("chave_usuario");

        txtNome.setText("Bem vindo " + name);
        listContacts = findViewById(R.id.listContatos);

        registerForContextMenu(listContacts);

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int i, long l) {
                Contact ContactEnviada = (Contact)
                        arrayAdapterContact.getItem(i);
                Intent it = new Intent(HomeActivity.this,SignUpActivity.class);
                it.putExtra("chave_Contact",ContactEnviada);
                startActivity(it);
            }
        });
        listContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView,View view, int
            position, long id){
                contact = arrayAdapterContact.getItem(position);
                return false;
            }
        });
    }
    public void fillList(){
        helper = new DBHelper(HomeActivity.this);
        arrayListContact = helper.buscarContacts();
        helper.close();

        if(listContacts != null){
            arrayAdapterContact = new ArrayAdapter<Contact>(
                    HomeActivity.this,
                    android.R.layout.simple_list_item_1,
                    arrayListContact);
            listContacts.setAdapter(arrayAdapterContact);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        fillList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View
            v, ContextMenu.ContextMenuInfo menuInfo){

        MenuItem mDelete = menu.add(Menu.NONE, 1, 1,"Deleta Registro");
        MenuItem mSair = menu.add(Menu.NONE, 2, 2,"Cancela");

        mDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                long rowsAffected = 1;

                helper = new DBHelper(HomeActivity.this);
                rowsAffected = helper.excluirContact(contact);
                helper.close();

                if(rowsAffected == -1){
                    alert("Erro de exclusão!");
                }
                else{
                    alert("Registro excluído com sucesso!");
                }
                fillList();

                return false;
            }
        });
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    private void alert(String s){
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
    }
}