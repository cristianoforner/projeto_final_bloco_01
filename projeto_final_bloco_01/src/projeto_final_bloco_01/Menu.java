package projeto_final_bloco_01;


import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;
import projeto_final_bloco_01.controller.Controller;
import projeto_final_bloco_01.model.Produto;


public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Controller controller = new Controller();

        while (true) {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║        O SEU TIME DO CORAÇÃO JAVA ⚽️           ║");
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║ 1 - Cadastrar Camisa                           ║");
            System.out.println("║ 2 - Listar Todas as Camisas                    ║");
            System.out.println("║ 3 - Buscar Camisa por ID                       ║");
            System.out.println("║ 4 - Atualizar Camisa                           ║");
            System.out.println("║ 5 - Remover Camisa                             ║");
            System.out.println("║ 0 - Sair                                       ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("👉 Escolha uma opção: ");

            int opcao;
            try {
                opcao = leia.nextInt();
                leia.nextLine(); // Limpa o buffer
            } catch (java.util.InputMismatchException e) {
                System.out.println(Cores.TEXT_RED_BOLD + "❌ Entrada inválida! Digite um número." + Cores.TEXT_RESET);
                leia.nextLine();
                continue;
            }

            if (opcao == 0) {
                System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "✅ Obrigado pela preferencia ! CRIADO POR: CRISTIANO FORNER");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("⚽️ Cadastrar Camisa");
                    try {
                        System.out.print("Nome da camisa: ");
                        String nome = leia.nextLine();
                        System.out.print("Preço: ");
                        double preco = leia.nextDouble();
                        leia.nextLine();
                        System.out.print("Tamanho (P/M/G): ");
                        String tamanho = leia.nextLine();
                        controller.cadastrarCamisa(nome, preco, tamanho);
                        System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa cadastrada com sucesso!" + Cores.TEXT_RESET);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ Preço inválido!" + Cores.TEXT_RESET);
                        leia.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ " + e.getMessage() + Cores.TEXT_RESET);
                    }
                    break;
                case 2:
                    System.out.println("📄 Listar Todas as Camisas");
                    try {
                        var camisas = controller.listarCamisas();
                        if (camisas.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado.");
                        } else {
                            for (Produto camisa : camisas) {
                            	System.out.println(Cores.TEXT_YELLOW_BOLD + "ID: " + camisa.getId() + " - " + Cores.TEXT_RESET + camisa.exibirDetalhes());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ Erro ao listar camisas: " + e.getMessage() + Cores.TEXT_RESET);
                    }
                    break;
                case 3:
                    System.out.println("🔍 Buscar Camisa por ID");
                    try {
                        System.out.print("Digite o ID: ");
                        int idBuscar = leia.nextInt();
                        leia.nextLine();
                        Produto camisa = controller.buscarCamisaPorId(idBuscar);
                        System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa encontrada: ID " + camisa.getId() + " - " + camisa.exibirDetalhes() + Cores.TEXT_RESET);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ ID inválido!" + Cores.TEXT_RESET);
                        leia.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ " + e.getMessage() + Cores.TEXT_RESET);
                    }
                    break;
                case 4:
                    System.out.println("✏️ Atualizar Camisa");
                    try {
                        System.out.print("Digite o ID da camisa: ");
                        int idAtualizar = leia.nextInt();
                        leia.nextLine();
                        System.out.print("Novo nome da camisa: ");
                        String novoNome = leia.nextLine();
                        System.out.print("Novo preço: ");
                        double novoPreco = leia.nextDouble();
                        leia.nextLine();
                        System.out.print("Novo tamanho (P/M/G): ");
                        String novoTamanho = leia.nextLine();
                        controller.atualizarCamisa(idAtualizar, novoNome, novoPreco, novoTamanho);
                        System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa com ID " + idAtualizar + " atualizada com sucesso!" + Cores.TEXT_RESET);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ Entrada inválida (ID ou preço)!" + Cores.TEXT_RESET);
                        leia.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ " + e.getMessage() + Cores.TEXT_RESET);
                    }
                    break;
                case 5:
                    System.out.println("🗑 Remover Camisa");
                    try {
                        System.out.print("Digite o ID: ");
                        int idRemover = leia.nextInt();
                        leia.nextLine();
                        controller.removerCamisa(idRemover);
                        System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa com ID " + idRemover + " removida com sucesso!" + Cores.TEXT_RESET);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ ID inválido!" + Cores.TEXT_RESET);
                        leia.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ " + e.getMessage() + Cores.TEXT_RESET);
                    }
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "❌ Opção inválida!" + Cores.TEXT_RESET);
            }
        }
    }
}