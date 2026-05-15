package model.repository;

import model.entity.Usuario;
import java.util.HashMap;

public class UsuarioRepository {
    private HashMap<Integer, Usuario> usuarios = new HashMap<>();
    private int proximoId = 1;

    public void salvar(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.put(usuario.getId(), usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarios.get(id);
    }

    public HashMap<Integer, Usuario> listarTodos() {
        return usuarios;
    }

    public boolean remover(int id) {
        return usuarios.remove(id) != null;
    }

    public boolean cpfJaExiste(String cpf) {
        for (Usuario u : usuarios.values()) {
            if (u.getCpf().equals(cpf)) return true;
        }
        return false;
    }
}