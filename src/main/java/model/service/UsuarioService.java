package model.service;

import model.entity.Usuario;
import model.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private UsuarioRepository repository = new UsuarioRepository();

    public void cadastrar(String nome, String cpf) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio.");
        }

        if (repository.cpfJaExiste(cpf.trim())) {
            throw new IllegalArgumentException("Já existe um usuário com este CPF.");
        }

        Usuario usuario = new Usuario(0, nome.trim(), cpf.trim());

        repository.salvar(usuario);
    }

}