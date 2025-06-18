package org.example;

import io.javalin.Javalin;
import org.example.Controller.Controller;
import org.junit.jupiter.api.Test;

import static io.javalin.testtools.JavalinTest.test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testHello() {
        Javalin app = Javalin.create();
        Controller.run(app);
        test(app, (server, client) -> {
            var response = client.get("/hello");
            assertEquals(200, response.code());
            assertEquals("Hello, Javalin!", response.body().string());
        });
    }

    @Test
    void testCriarUsuario() {
        Javalin app = Javalin.create();
        Controller.run(app);
        test(app, (server, client) -> {
            String json = "{\"nome\":\"Joao\", \"email\":\"joao@email.com\", \"idade\":22}";
            var response = client.post("/usuarios", json);
            assertEquals(201, response.code());
            assertTrue(response.body().string().contains("Joao"));
        });
    }

    @Test
    void testBuscarUsuario() {
        Javalin app = Javalin.create();
        Controller.run(app);
        test(app, (server, client) -> {
            var response = client.get("/usuarios/Guilherme");
            assertEquals(200, response.code());
            assertTrue(response.body().string().contains("Guilherme"));
        });
    }

    @Test
    void testListarUsuarios() {
        Javalin app = Javalin.create();
        Controller.run(app);
        test(app, (server, client) -> {
            var response = client.get("/usuarios");
            assertEquals(200, response.code());
            assertTrue(response.body().string().startsWith("["));
        });
    }
}
