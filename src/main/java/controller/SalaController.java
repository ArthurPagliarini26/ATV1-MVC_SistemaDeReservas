package controller;

import model.entity.Sala;
import model.service.SalaService;

public class SalaController {
    private SalaService salaService = new SalaService();

    public void cadastrar(int numero, int capacidade) {
        try {
            salaService.cadastrar(numero, capacidade);
            System.out.println("Sala cadastrada com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}