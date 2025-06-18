package org.example;

import io.javalin.Javalin;
import org.example.Controller.Controller;
import org.example.URLConnection.ListagemConnection;
import org.example.URLConnection.PathConnection;
import org.example.URLConnection.StatusConnection;
import org.example.URLConnection.UsuarioPostConnection;

public class Main {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        controller(app);
        connection();
    }

    public static void controller(Javalin app) {
        Controller.run(app);
    }

    public static void connection() {
        UsuarioPostConnection.httpPostUsuario();
        ListagemConnection.httpGetListagem();
        PathConnection.httpGetPath();
        StatusConnection.httpGetStatus();
    }
}
