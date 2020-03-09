package com.example.projetofinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetofinanceiro.controle.MovimentoCaixaCtrl;
import com.example.projetofinanceiro.modelo.Movimento;
import com.example.projetofinanceiro.modelo.MovimentoCaixa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {


    MovimentoCaixa movimentoCaixa;
    private List<Movimento> listaMovimento;
    private RecyclerView recyclerViewMov;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById( R.id.toolbar );
       // setSupportActionBar(toolbar);
        listaMovimento = new ArrayList<>();

        recyclerViewMov = findViewById(R.id.lst_movimento);

        Movimento movimento = new Movimento();
        movimento.setConta("001");
        movimento.setData("2020-03-09");
        movimento.setDoc("01212");
        movimento.setHistorico("PAGO VALOR TESTE");
        movimento.setId("01");
        movimento.setOperacao("E");
        movimento.setUsuario("01");
        movimento.setValor("10.50");
        listaMovimento.add( movimento );

        // Lancamento 2
        movimento = new Movimento();
        movimento.setConta("0502");
        movimento.setData("2020-03-09");
        movimento.setDoc("012512");
        movimento.setHistorico("RECEBIMENTO REF. PRODUTOS");
        movimento.setId("02");
        movimento.setOperacao("E");
        movimento.setUsuario("01");
        movimento.setValor("200.85");
        listaMovimento.add( movimento );

        // Fixar para melhorar o desempenho
        recyclerViewMov.setHasFixedSize( true );


        // Configurar Adapter
        AdapterMovimento adapterMovimento = new AdapterMovimento( listaMovimento );

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewMov.setLayoutManager( layoutManager );
        recyclerViewMov.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL ) );
        recyclerViewMov.setAdapter( adapterMovimento );


        FloatingActionButton fab = findViewById( R.id.fab );
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /*
                MovimentoCaixaCtrl movimentoCaixaCtrl = new MovimentoCaixaCtrl();
                String sRetorno = movimentoCaixaCtrl.consultarMovimento();

                Toast.makeText( getApplicationContext(), "Clique configurado!",Toast.LENGTH_LONG ).show();

                */

                //Intent intent = new Intent( this, LancamentoActivity.class );
                //startActivity( intent );

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }





}
