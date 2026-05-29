package controller;

import model.entity.Reserva;
import model.service.ReservaService;

public class ReservaController {
    private ReservaService reservaService = new ReservaService();

    public void cadastrar(int usuarioId, int salaId, String data, String horario) {
        try {
            reservaService.cadastrar(usuarioId, salaId, data, horario);
            System.out.println("Reserva cadastrada com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listar() {
        try {
            reservaService.listar();
        } catch (Exception e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }
    }

    public void buscarPorId(int id) {
        try {
            Reserva reserva = reservaService.buscarPorId(id);
            reserva.exibirDados();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void atualizar(int id, String novaData, String novoHorario) {
        try {
            reservaService.atualizar(id, novaData, novoHorario);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void cancelar(int id) {
        try {
            reservaService.cancelar(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}