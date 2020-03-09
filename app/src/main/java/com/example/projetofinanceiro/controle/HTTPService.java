package com.example.projetofinanceiro.controle;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, String  > {


    @Override
    protected String doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();
        HttpURLConnection urlConnection = null;

        try {

            URL url = new URL("http://www.meuappfinanceiro.com.br/api.php/consultamovimento/");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");
            //urlConnection.setDoOutput(true);
            urlConnection.setConnectTimeout(5000);
            urlConnection.connect();

            Scanner scanner = new Scanner(  url.openStream() );

            while ( scanner.hasNext() ) {
                resposta.append( scanner.next() );
            }

            } catch (ProtocolException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
                urlConnection.disconnect();
            }

      return resposta.toString();
    }
}
