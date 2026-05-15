package model.service;

import model.repository.SalaRepository;
import model.entity.Sala;
import java.util.HashMap;

public class SalaService {
    private SalaRepository repository = new SalaRepository();

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(int numero, int capaciade){
        if(capaciade <=0 ) return "Erro: A capacidade de sala deve ser maior que zero";

    Sala sala = new Sala(0, numero, capaciade);
    repository.salvar(sala);
    return "Sala cadastrada com sucesso! "+ sala.getId();
    }
    public Sala buscarPorId(int id){
        return repository.buscarPorId(id);
    }

    public HashMap<Integer, Sala> listarTodos(){
        return repository.listarTodos();
    }

    public String remover(int id) {
        Sala s = repository.buscarPorId(id);
        if (s == null) return "Erro: Sala não encontrada";
        repository.remover(id);
        return "Sala removida com sucesso";

    }

    public String atualizar(int id, int novonumero, int novacapacidade){
        Sala s = repository.buscarPorId(id);
        if (s ==null) return"Erro: sala não encontrada";
        if(novacapacidade <= 0) return"Erro: Capacidade deve ser maior que zero";

        s.setNumero(novonumero);
        s.setCapacidade(novacapacidade);
        return "Sala atualizada com sucesso";
    }
}
//.trim()