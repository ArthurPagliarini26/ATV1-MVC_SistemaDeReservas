package model.service;

import model.entity.Usuario;
import model.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrar(String nome, String cpf) {

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

        return repository.salvar(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.listarTodos();
    }

    public Usuario buscarPorId(int id) {

        Usuario u = repository.buscarPorId(id);

        if (u == null) {
            throw new IllegalArgumentException(
                    "Usuário com ID " + id + " não encontrado."
            );
        }

        return u;
    }

    public Usuario atualizar(int id, String novoNome, String novoCpf) {

        Usuario u = buscarPorId(id);

        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }

        if (novoCpf == null || novoCpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }

        u.setNome(novoNome.trim());
        u.setCpf(novoCpf.trim());

        repository.atualizar(u);

        return u;
    }

    public void remover(int id) {

        buscarPorId(id);

        repository.remover(id);
    }
}