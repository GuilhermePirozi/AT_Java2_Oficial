package org.example.Controller;

import io.javalin.http.Context;
import org.example.Model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class UsuariosController {

    private static final List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void listarUsuarios(Context ctx) {
        String nome = ctx.pathParam("nome");
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                ctx.status(200).json(usuario);
                return;
            }
        }
        ctx.status(404).json("Usuário não encontrado!");
    }

    public static void criarUsuario(Context ctx) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Usuario usuario = mapper.readValue(ctx.body(), Usuario.class);
            usuarios.add(usuario);
            ctx.status(201).json(usuario);
        } catch (Exception e) {
            ctx.status(400).json("Erro ao processar usuário.");
        }
    }
}
