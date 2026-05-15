package model.repository;

import model.entity.Sala;
import java.util.HashMap;

public class SalaRepository {
    private HashMap<Integer, Sala> salas = new HashMap<>();
    private int proximoId = 1;

    public void salvar(Sala sala) {
        sala.setId(proximoId++);
        salas.put(sala.getId(), sala);
    }

    public Sala buscarPorId(int id) {
        return salas.get(id);
    }

    public HashMap<Integer, Sala> listarTodos() {
        return salas;
    }

    public boolean remover(int id) {
        return salas.remove(id) != null;
    }
}