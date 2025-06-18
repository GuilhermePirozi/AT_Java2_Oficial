package org.example.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;

import java.io.IOException;
import java.util.Map;

public class EchoController {

    public static void postMensagem(Context context) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> body = mapper.readValue(context.body(), Map.class);
            String mensagem = body.get("mensagem");
            context.json(Map.of("mensagem", mensagem));

        } catch (IOException e) {
            e.printStackTrace();
            context.status(400).json(Map.of("erro", "JSON inválido"));
        }
    }
}
