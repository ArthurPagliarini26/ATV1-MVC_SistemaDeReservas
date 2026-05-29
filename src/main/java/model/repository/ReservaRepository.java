package model.repository;

import model.entity.*;
import java.util.*;

public class ReservaRepository {
    static private HashMap<Integer, Reserva> reservas = new HashMap<>();
    static private int proximoId = 1;

    public void salvar(Reserva reserva) {
        reserva.setId(proximoId++);
        reservas.put(reserva.getId(), reserva);
    }

    public Reserva buscarPorId(int id) {
        return reservas.get(id);
    }

    public HashMap<Integer, Reserva> listarTodos() {
        return reservas;
    }

    public boolean remover(int id) {
        return reservas.remove(id) != null;
    }

    public void cancelar(Reserva reserva) {
        reserva.setStatus("INATIVA");
    }
}
