package org.example.URLConnection;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UsuarioPostConnection {

    public static void httpPostUsuario() {
        try {
            URL url = new URL("http://localhost:7000/usuarios");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            String jsonInputString = "{\"nome\":\"Lucas\", \"email\":\"lucas@email.com\", \"idade\":25}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            System.out.println("POST /usuarios enviado com sucesso. Código HTTP: " + conn.getResponseCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
