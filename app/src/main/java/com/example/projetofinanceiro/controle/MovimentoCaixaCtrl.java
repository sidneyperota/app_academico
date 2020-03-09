package com.example.projetofinanceiro.controle;

import android.util.Log;

import com.example.projetofinanceiro.modelo.Movimento;
import com.example.projetofinanceiro.modelo.MovimentoCaixa;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MovimentoCaixaCtrl {

    MovimentoCaixa movimentoCaixa;

    public String consultarMovimento() {

        String sRetorno = null;
        String sResultado = null;
        String sJSON = null;
        JSONObject json_objeto = null;
        String sHistorico = "sem valor";

        HTTPService httpService = new HTTPService();

        JSONObject objetoSelecionado = null;
        String sValor = "";

        try {

            sRetorno =  httpService.execute().get();

            // Converter para Objeto Movimento
            Gson obj_gson;
            obj_gson = new Gson();

            Movimento movimento;


            sJSON =
            //"{{'id':'1','data':'2020-02-04','conta':'0001'','operacao':'E','historico':'Recebimento Teste','valor':'10','usuario':'1','doc':'1212'},{'id':'2','data':'2020-02-04','conta':'0003','operacao':'E','historico':'RECEBIDO VALOR.','valor':'5','usuario':'1','doc':'01236'},{'id':'3','data':'2020-02-04','conta':'0001','operacao':'E','historico':'A\u00e7a\u00ed 300ml\r\n','valor':'4','usuario':'1','doc':'123'}}";
            //"{'dados':[{'id':'01-','nome':'sidney'},{'id':'02-','nome':'jose carlos'},{'id':'03-','carlos alberto'}]}";


            "{'movimento':[ {'id':'01','conta':'1212','operacao':'E','historico':'teste de entrada','valor':'10.5','usuario':'5','doc':'1212','data':'2020-03-09'}," +
                    "{'id':'02','conta':'1212','operacao':'E','historico':'valor principal','valor':'25.5','usuario':'5','doc':'1212','data':'2020-03-09'}," +
                    "{'id':'03','conta':'1122','operacao':'S','historico':'teste para consulta','valor':'50.5','usuario':'5','doc':'1212','data':'2020-03-09'}," +
                    "{'id':'04','conta':'1552','operacao':'E','historico':'teste sistema web','valor':'2300.5','usuario':'5','doc':'1212','data':'2020-03-09'}," +
                    "{'id':'05','conta':'1266','operacao':'S','historico':'teste de SAIDA 2','valor':'60.5','usuario':'5','doc':'1212','data':'2020-03-09'}," +
                    "{'id':'06','conta':'1882','operacao':'E','historico':'teste de entrada','valor':'98.5','usuario':'5','doc':'1212','data':'2020-03-09'}]}";

             //JSONObject objeto = new JSONObject( sJSON );
             json_objeto  = new JSONObject(sJSON);
             JSONArray resultados = json_objeto.getJSONArray("movimento");


             for ( int i = 0; i < resultados.length(); i++ ) {

                 JSONObject objetoSel = resultados.getJSONObject(i);

                 //sValor = objetoSel.toString();
                 Gson gson = new Gson();
                 Movimento mov;
                 mov = gson.fromJson( objetoSel.toString(), Movimento.class );
                 sValor = sValor.concat( mov.getHistorico() + "-" );

             }

             //sValor = json_objeto.getString("nome");

             if (  resultados == null ) {
                sHistorico = "-objeto nulo";
             }
             else {
                sHistorico = "-objeto instanciado";
             }

            //JSONObject objeto = new JSONObject( sJSON );

            //JSONArray lista = objeto.getJSONArray("mov");


           // objetoSelecionado = lista.getJSONObject(0);
           // sHistorico = objetoSelecionado.getString("historico");

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sValor;
    }


}
