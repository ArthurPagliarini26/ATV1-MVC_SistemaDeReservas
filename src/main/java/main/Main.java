package main;

import controller.*;
import model.repository.*;
import model.service.*;
import view.SistemaView;

public class Main {
    public static void main(String[] args) {

        UsuarioRepository usuarioRepository = new UsuarioRepository();
        SalaRepository salaRepository = new SalaRepository();
        ReservaRepository reservaRepository = new ReservaRepository();

        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        SalaService salaService = new SalaService(salaRepository);
        ReservaService reservaService = new ReservaService(reservaRepository, usuarioRepository, salaRepository);

        UsuarioController usuarioController = new UsuarioController(usuarioService);
        SalaController salaController = new SalaController(salaService);
        ReservaController reservaController = new ReservaController(reservaService);

        SistemaView view = new SistemaView(usuarioController, salaController, reservaController);
        view.iniciar();
    }
}