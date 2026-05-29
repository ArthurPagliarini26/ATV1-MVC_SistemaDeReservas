package controller;

import model.entity.Usuario;
import model.service.SalaService;
import model.service.UsuarioService;
import java.util.List;

public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    public void cadastrar(String nome, String cpf) {

        try {
            usuarioService.cadastrar(nome, cpf);
            System.out.println("Usuário cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}