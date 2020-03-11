package com.example.projetofinanceiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class LancCaixaActivity extends AppCompatActivity {


    private EditText edtData;
    private RadioButton rdbEntrada;
    private RadioButton rdbSaida;
    private EditText edtConta;
    private EditText edtDoc;
    private EditText edtHist;
    private EditText edtValor;
    private Button btnSalvar;
    private Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanc_caixa);

        edtData = findViewById( R.id.edt_data );
        edtDoc  = findViewById( R.id.edt_doc );
        edtHist = findViewById( R.id.txt_historico );
        edtConta = findViewById( R.id.edt_conta );
        edtValor = findViewById(R.id.edt_valor );
        btnSalvar = findViewById(R.id.btn_salvar );

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /*
                MovimentoCaixaCtrl movimentoCaixaCtrl = new MovimentoCaixaCtrl();
                String sRetorno = movimentoCaixaCtrl.consultarMovimento();

                Toast.makeText( getApplicationContext(), "Clique configurado!",Toast.LENGTH_LONG ).show();
                */
                edtData.setText("");
                edtDoc.setText("");
                edtHist.setText("");
                edtConta.setText("");
                edtValor.setText("");

            }
        });










        btnCancelar = findViewById( R.id.btn_cancelar );
    }



}
