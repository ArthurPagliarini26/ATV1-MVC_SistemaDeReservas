package model.repository;

import model.entity.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsuarioRepository {

    private HashMap<Integer, Usuario> usuarios = new HashMap<>();
    private int proximoId = 1;

    public Usuario salvar(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Usuario buscarPorId(int id) {
        return usuarios.get(id);
    }

    public boolean atualizar(Usuario usuario) {
        if (!usuarios.containsKey(usuario.getId())) {
            return false;
        }

        usuarios.put(usuario.getId(), usuario);
        return true;
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios.values());
    }

    public boolean remover(int id) {
        return usuarios.remove(id) != null;
    }

    public boolean cpfJaExiste(String cpf) {
        for (Usuario u : usuarios.values()) {
            if (u.getCpf().equals(cpf)) {
                return true;
            }
        }

        return false;
    }
}