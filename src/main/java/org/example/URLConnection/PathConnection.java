package org.example.URLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PathConnection {

    public static void httpGetPath() {
        try {
            URL url = new URL("http://localhost:7000/usuarios/Lucas");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }

            System.out.println("\nGET /usuarios/Lucas:");
            System.out.println("Resposta: " + response);
            System.out.println("Código HTTP: " + conn.getResponseCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
