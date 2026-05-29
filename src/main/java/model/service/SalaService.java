package model.service;

import model.repository.SalaRepository;
import model.entity.Sala;
import model.repository.UsuarioRepository;

import java.util.HashMap;

public class SalaService {

    private SalaRepository repository = new SalaRepository();

    public void cadastrar(int numero, int capaciade){
        if(capaciade <=0 ) {
            throw new IllegalArgumentException("Erro: A capacidade de sala deve ser maior que zero");
        }

    Sala sala = new Sala(0, numero, capaciade);
    repository.salvar(sala);
    }
}
