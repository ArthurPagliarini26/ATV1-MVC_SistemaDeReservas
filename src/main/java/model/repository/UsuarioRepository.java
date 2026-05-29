package model.repository;

import model.entity.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsuarioRepository {

    static private HashMap<Integer, Usuario> usuarios = new HashMap<>();
    static private int proximoId = 1;

    public void salvar(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.put(usuario.getId(), usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarios.get(id);
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios.values());
    }

    public boolean cpfJaExiste(String cpf) {
        for (Usuario u : usuarios.values()) {
            if (u.getCpf().equals(cpf)) { return true; }
        }
        return false;
    }
}