package view;

import controller.*;
import java.util.Scanner;

public class SistemaView {
    private final Scanner scanner = new Scanner(System.in);
    private final UsuarioController usuarioController;
    private final SalaController salaController;
    private final ReservaController reservaController;

    public SistemaView(UsuarioController usuarioController, SalaController salaController, ReservaController reservaController) {
        this.usuarioController = usuarioController;
        this.salaController = salaController;
        this.reservaController = reservaController;
    }

    public void iniciar() {
        int opcao = -1;
        do {
            try {
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("       SISTEMA DE RESERVAS      ");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("  1. Gerenciar Usuários          ");
                System.out.println("  2. Gerenciar Salas             ");
                System.out.println("  3. Gerenciar Reservas          ");
                System.out.println("  0. Sair                        ");
                System.out.println("╚══════════════════════════════╝");
                System.out.print("Opção: ");
                opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> menuUsuario();
                    case 2 -> menuSala();
                    case 3 -> menuReserva();
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
        } while (opcao != 0);
    }

    private void menuUsuario() {
        int opcao = -1;
        do {
            try {
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("         MENU USUÁRIOS          ");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("  1. Cadastrar Usuário           ");
                System.out.println("  2. Listar Usuários             ");
                System.out.println("  3. Buscar por ID               ");
                System.out.println("  4. Atualizar Usuário           ");
                System.out.println("  5. Remover Usuário             ");
                System.out.println("  0. Voltar                      ");
                System.out.println("╚══════════════════════════════╝");
                System.out.print("Opção: ");
                opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> cadastrarUsuario();
                    case 2 -> usuarioController.listarTodos();
                    case 3 -> buscarUsuario();
                    case 4 -> atualizarUsuario();
                    case 5 -> removerUsuario();
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
        } while (opcao != 0);
    }

    private void cadastrarUsuario() {
        System.out.println("\n--- Cadastrar Usuário ---");
        String nome = lerTexto("Nome: ");
        String cpf = lerTexto("CPF: ");
        usuarioController.cadastrar(nome, cpf);
    }

    private void buscarUsuario() {
        System.out.println("\n--- Buscar Usuário ---");
        int id = lerInteiro("ID: ");
        usuarioController.buscarPorId(id);
    }

    private void atualizarUsuario() {
        System.out.println("\n--- Atualizar Usuário ---");
        int id = lerInteiro("ID: ");
        String novoNome = lerTexto("Novo Nome: ");
        String novoCpf = lerTexto("Novo CPF: ");
        usuarioController.atualizar(id, novoNome, novoCpf);
    }

    private void removerUsuario() {
        System.out.println("\n--- Remover Usuário ---");
        int id = lerInteiro("ID: ");
        usuarioController.remover(id);
    }

    private void menuSala() {
        int opcao = -1;
        do {
            try {
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("           MENU SALAS           ");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("  1. Cadastrar Sala              ");
                System.out.println("  2. Listar Salas                ");
                System.out.println("  3. Buscar por ID               ");
                System.out.println("  4. Atualizar Sala              ");
                System.out.println("  5. Remover Sala                ");
                System.out.println("  0. Voltar                      ");
                System.out.println("╚══════════════════════════════╝");
                System.out.print("Opção: ");
                opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> cadastrarSala();
                    case 2 -> salaController.listar();
                    case 3 -> buscarSala();
                    case 4 -> atualizarSala();
                    case 5 -> removerSala();
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
        } while (opcao != 0);
    }

    private void cadastrarSala() {
        System.out.println("\n--- Cadastrar Sala ---");
        int numero = lerInteiro("Número da sala: ");
        int capacidade = lerInteiro("Capacidade: ");
        salaController.cadastrar(numero, capacidade);
    }

    private void buscarSala() {
        System.out.println("\n--- Buscar Sala ---");
        int id = lerInteiro("ID: ");
        salaController.buscarPorId(id);
    }

    private void atualizarSala() {
        System.out.println("\n--- Atualizar Sala ---");
        int id = lerInteiro("ID: ");
        int novoNumero = lerInteiro("Novo Número: ");
        int novaCapacidade = lerInteiro("Nova Capacidade: ");
        salaController.atualizar(id, novoNumero, novaCapacidade);
    }

    private void removerSala() {
        System.out.println("\n--- Remover Sala ---");
        int id = lerInteiro("ID: ");
        salaController.remover(id);
    }

    private void menuReserva() {
        int opcao = -1;
        do {
            try {
                System.out.println("\n╔══════════════════════════════╗");
                System.out.println("         MENU RESERVAS          ");
                System.out.println("╠══════════════════════════════╣");
                System.out.println("  1. Criar Reserva               ");
                System.out.println("  2. Listar Reservas             ");
                System.out.println("  3. Buscar por ID               ");
                System.out.println("  4. Atualizar Reserva           ");
                System.out.println("  5. Cancelar Reserva            ");
                System.out.println("  6. Remover Reserva             ");
                System.out.println("  0. Voltar                      ");
                System.out.println("╚══════════════════════════════╝");
                System.out.print("Opção: ");
                opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> criarReserva();
                    case 2 -> reservaController.listar();
                    case 3 -> buscarReserva();
                    case 4 -> atualizarReserva();
                    case 5 -> cancelarReserva();
                    case 6 -> removerReserva();
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
        } while (opcao != 0);
    }

    private void criarReserva() {
        System.out.println("\n--- Criar Reserva ---");
        int usuarioId = lerInteiro("ID do Usuário: ");
        int salaId = lerInteiro("ID da Sala: ");
        String data = lerTexto("Data (dd/mm/aaaa): ");
        String horario = lerTexto("Horário (hh:mm): ");
        reservaController.cadastrar(usuarioId, salaId, data, horario);
    }

    private void buscarReserva() {
        System.out.println("\n--- Buscar Reserva ---");
        int id = lerInteiro("ID: ");
        reservaController.buscarPorId(id);
    }

    private void atualizarReserva() {
        System.out.println("\n--- Atualizar Reserva ---");
        int id = lerInteiro("ID: ");
        String novaData = lerTexto("Nova Data (dd/mm/aaaa): ");
        String novoHorario = lerTexto("Novo Horário (hh:mm): ");
        reservaController.atualizar(id, novaData, novoHorario);
    }

    private void cancelarReserva() {
        System.out.println("\n--- Cancelar Reserva ---");
        int id = lerInteiro("ID: ");
        reservaController.cancelar(id);
    }

    private void removerReserva() {
        System.out.println("\n--- Remover Reserva ---");
        int id = lerInteiro("ID: ");
        reservaController.cancelar(id);
    }

    private String lerTexto(String mensagem) {
        String valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("Erro: Campo não pode ser vazio!");
            }
        } while (valor.isEmpty());
        return valor;
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
        }
    }
}