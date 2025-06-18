package org.example.Controller;

import io.javalin.Javalin;
import java.util.Map;

public class Controller {
    public static void run(Javalin app) {
        UsuariosController usuariosController = new UsuariosController();
        usuariosController.adicionarUsuario(new org.example.Model.Usuario("Guilherme", "gui@email.com", 20));
        usuariosController.adicionarUsuario(new org.example.Model.Usuario("Gustavo", "gus@email.com", 20));
        usuariosController.adicionarUsuario(new org.example.Model.Usuario("Taylan", "tay@email.com", 19));

        app.get("/hello", ctx -> ctx.result("Hello, Javalin!"));
        app.get("/usuarios", ctx -> ctx.json(usuariosController.getUsuarios()));
        app.get("/usuarios/{nome}", UsuariosController::listarUsuarios);
        app.post("/usuarios", UsuariosController::criarUsuario);
        app.get("/status", StatusController::getStatus);
        app.post("/echo", EchoController::postMensagem);
        app.get("/saudacao/{nome}", ctx -> ctx.json(Map.of("mensagem", "Olá, " + ctx.pathParam("nome") + "!")));
    }
}
