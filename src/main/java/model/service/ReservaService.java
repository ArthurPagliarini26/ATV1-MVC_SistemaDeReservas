package model.service;

import model.entity.*;
import model.repository.*;
import java.util.*;

public class ReservaService {

    private ReservaRepository reservaRepository;
    private UsuarioRepository usuarioRepository;
    private SalaRepository salaRepository;

    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, SalaRepository salaRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.salaRepository = salaRepository;
    }

    public void cadastrar(int usuarioId, int salaId, String data, String horario) {

        Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
        if(usuario == null) {
            throw new IllegalArgumentException("usuário não encontrado");
        }

        Sala sala = salaRepository.buscarPorId(salaId);
        if (sala == null) {
            throw new IllegalArgumentException("Sala não encontrada!");
        }

        if (!sala.isDisponivel()) {
            throw new IllegalArgumentException("Sala indisponível!");
        }

        for (Reserva r : reservaRepository.listarTodos().values()) {
            if (r.getSala().getId() == salaId &&
                    r.getData().equals(data) &&
                    r.getHorario().equals(horario) &&
                    r.getStatus().equals("ATIVA")) {
                throw new IllegalArgumentException("Já existe uma reserva para essa sala nessa data e horário!");
            }
        }

        Reserva reserva = new Reserva(0, usuario, sala, data, horario);
        sala.setDisponivel(false);
        reservaRepository.salvar(reserva);
        System.out.println("Reserva criada com sucesso!");
    }

    public void listar() {
        HashMap<Integer, Reserva> reservas = reservaRepository.listarTodos();
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }
        for (Reserva r : reservas.values()) {
            r.exibirDados();
        }
    }

    public Reserva buscarPorId(int id) {
        Reserva reserva = reservaRepository.buscarPorId(id);
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não encontrada!");
        }
        return reserva;
    }

    public void atualizar(int id, String novaData, String novoHorario) {
        Reserva reserva = buscarPorId(id);

        if (!reserva.getStatus().equals("ATIVA")) {
            throw new IllegalArgumentException("Não é possível atualizar uma reserva cancelada!");
        }

        for (Reserva r : reservaRepository.listarTodos().values()) {
            if (r.getId() != id &&
                    r.getSala().getId() == reserva.getSala().getId() &&
                    r.getData().equals(novaData) &&
                    r.getHorario().equals(novoHorario) &&
                    r.getStatus().equals("ATIVA")) {
                throw new IllegalArgumentException("Já existe uma reserva para essa sala nessa data e horário!");
            }
        }

        reserva.setData(novaData);
        reserva.setHorario(novoHorario);
        reservaRepository.salvar(reserva);
        System.out.println("Reserva atualizada com sucesso!");
    }

    public void cancelar(int id) {
        Reserva reserva = buscarPorId(id);

        if (!reserva.getStatus().equals("ATIVA")) {
            throw new IllegalArgumentException("Reserva já está cancelada!");
        }

        reserva.setStatus("CANCELADA");
        reserva.getSala().setDisponivel(true);
        reservaRepository.salvar(reserva);
        System.out.println("Reserva cancelada! Sala liberada.");
    }
}
