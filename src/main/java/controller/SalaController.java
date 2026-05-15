package controller;

import model.entity.Sala;
import model.service.SalaService;

public class SalaController {
    private SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    public void cadastrar(int numero, int capacidade) {
        try {
            salaService.cadastrar(numero, capacidade);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listar() {
        try {
            salaService.listarTodos();
        } catch (Exception e) {
            System.out.println("Erro ao listar salas: " + e.getMessage());
        }
    }

    public void buscarPorId(int id) {
        try {
            Sala sala = salaService.buscarPorId(id);
            sala.exibirDados();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void atualizar(int id, int novoNumero, int novaCapacidade) {
        try {
            salaService.atualizar(id, novoNumero, novaCapacidade);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void remover(int id) {
        try {
            salaService.remover(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}