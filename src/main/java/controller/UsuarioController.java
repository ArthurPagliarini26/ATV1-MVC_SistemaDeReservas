package controller;

import model.entity.Usuario;
import model.service.UsuarioService;
import java.util.List;

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public Usuario cadastrar(String nome, String cpf){
        return service.cadastrar(nome, cpf);
    }

    public List<Usuario> listaTodos(){
        return service.listarTodos();
    }

    public Usuario buscarPorId(int id) {
        return service.buscarPorId(id);
    }

    public Usuario atualizar(int id, String novoNome, String novoCpf ){
        return service.atualizar(id, novoNome, novoCpf);
    }

    public void remover(int id){
        service.remover(id);
    }
}
