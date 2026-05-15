package controller;

import model.entity.Usuario;
import model.service.UsuarioService;

import java.util.List;

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public void cadastrar(String nome, String cpf) {

        try {
            Usuario usuario = service.cadastrar(nome, cpf);

            System.out.println("Usuário cadastrado com sucesso!");
            usuario.exibirDados();

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listarTodos() {

        try {

            List<Usuario> usuarios = service.listarTodos();

            for (Usuario u : usuarios) {
                u.exibirDados();
            }

        } catch (Exception e) {

            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

    public void buscarPorId(int id) {

        try {

            Usuario usuario = service.buscarPorId(id);

            usuario.exibirDados();

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void atualizar(int id, String novoNome, String novoCpf) {

        try {

            Usuario usuario = service.atualizar(id, novoNome, novoCpf);

            System.out.println("Usuário atualizado com sucesso!");
            usuario.exibirDados();

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void remover(int id) {

        try {

            service.remover(id);

            System.out.println("Usuário removido com sucesso!");

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }
}