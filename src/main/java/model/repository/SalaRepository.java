package model.repository;

import model.entity.Sala;
import java.util.HashMap;

public class SalaRepository {
    static private HashMap<Integer, Sala> salas = new HashMap<>();
    static private int proximoId = 1;

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
}