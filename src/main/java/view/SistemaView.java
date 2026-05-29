package view;

import controller.*;
import model.repository.*;
import model.service.*;
import java.util.Scanner;

public class SistemaView {

    private Scanner sc = new Scanner(System.in);

    private UsuarioController usuarioController = new UsuarioController();
    private SalaController salaController = new SalaController();
    private ReservaController reservaController = new ReservaController();

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n=== Sistema de Reserva de Salas ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Sala");
            System.out.println("3 - Realizar Reserva");
            System.out.println("4 - Listar Reservas");
            System.out.println("5 - Buscar Reserva por ID");
            System.out.println("6 - Atualizar Reserva");
            System.out.println("7 - Cancelar Reserva");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do usuário: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF do usuário: ");
                        String cpf = sc.nextLine();

                        usuarioController.cadastrar(nome, cpf);
                        break;

                    case 2:
                        System.out.print("Número da sala: ");
                        int numero = Integer.parseInt(sc.nextLine());

                        System.out.print("Capacidade da sala: ");
                        int capacidade = Integer.parseInt(sc.nextLine());

                        salaController.cadastrar(numero, capacidade);
                        break;

                    case 3:
                        System.out.print("ID do usuário: ");
                        int usuarioId = Integer.parseInt(sc.nextLine());

                        System.out.print("ID da sala: ");
                        int salaId = Integer.parseInt(sc.nextLine());

                        System.out.print("Data (ex: 2025-06-01): ");
                        String data = sc.nextLine();

                        System.out.print("Horário (ex: 14:00): ");
                        String horario = sc.nextLine();

                        reservaController.cadastrar(usuarioId, salaId, data, horario);
                        break;

                    case 4:
                        reservaController.listar();
                        break;

                    case 5:
                        System.out.print("ID da reserva: ");
                        int idBusca = Integer.parseInt(sc.nextLine());

                        reservaController.buscarPorId(idBusca);
                        break;

                    case 6:
                        System.out.print("ID da reserva a atualizar: ");
                        int idAtualizar = Integer.parseInt(sc.nextLine());

                        System.out.print("Nova data (ex: 2025-06-01): ");
                        String novaData = sc.nextLine();

                        System.out.print("Novo horário (ex: 14:00): ");
                        String novoHorario = sc.nextLine();

                        reservaController.atualizar(idAtualizar, novaData, novoHorario);
                        break;

                    case 7:
                        System.out.print("ID da reserva a cancelar: ");
                        int idCancelar = Integer.parseInt(sc.nextLine());

                        reservaController.cancelar(idCancelar);
                        break;

                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro: valor numérico inválido!");
                opcao = -1;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                opcao = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                opcao = -1;
            }

        } while (opcao != 0);

        sc.close();
    }
}