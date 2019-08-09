package br.com.treinamento.listadealuno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.treinamento.listadealuno.model.Aluno;

public class MainActivity extends AppCompatActivity {

    EditText txtNome, txtEmail, txtTelefone;
    ListView listTela;
    List<Aluno> lista = new ArrayList<Aluno>();
    List<HashMap<String,String>> listaHashMap = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adicionar(View view) {

        //Pegar campos da tela

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);

        // Extrair dados do EditText

        String nome, telefone, email;

        nome = txtNome.getText().toString();
        telefone = txtTelefone.getText().toString();
        email = txtEmail.getText().toString();

        Aluno aluno = new Aluno(nome, telefone, email);


        //Adicionar objeto aluno na lista
        //lista.add(aluno);

        // Criando mapa de valores

        HashMap<String,String> map = new HashMap<>();
        map.put("nome",nome);
        map.put("telefone",telefone);
        map.put("email",email);

        //Adicionar map na lista.
        listaHashMap.add(map);

        // fazer mapeamento DE-PARA
        String[] de = {"nome","telefone","email"};
        int[] para = {R.id.labelNome,R.id.labelTelefone,R.id.labelEmail};

        //Buscar a referencia da listView
        listTela = findViewById(R.id.listTela);

        //chamar o simple adapter para "juntar" os dados
        //* list<HashMap<String,String>>
        // DE -> PARA
        // * layout item.xml
        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(),listaHashMap,R.layout.item,de,para);

        //Jogar dados na listView
        listTela.setAdapter(simpleAdapter);




    }
}
