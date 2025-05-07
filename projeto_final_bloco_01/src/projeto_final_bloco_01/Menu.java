package projeto_final_bloco_01;

import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;
import projeto_final_bloco_01.model.Camisa;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;
import projeto_final_bloco_01.repository.Repository;


public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Repository repositorio = new ProdutoRepository();

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
                System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "✅ Obrigado por usar o sistema!");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("⚽️ Cadastrar Camisa");
                    System.out.print("Nome da camisa: ");
                    String nome = leia.nextLine();
                    System.out.print("Preço: ");
                    double preco;
                    try {
                        preco = leia.nextDouble();
                        leia.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ Preço inválido!" + Cores.TEXT_RESET);
                        leia.nextLine();
                        break;
                    }
                    System.out.print("Tamanho (P/M/G): ");
                    String tamanho = leia.nextLine();
                    Produto camisa = new Camisa(0, nome, preco, tamanho); // ID será gerado pelo repositório
                    repositorio.cadastrar(camisa);
                    // Exibir o ID gerado (o ID é definido no repositório)
                    System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa cadastrada com ID: " + camisa.getId() + Cores.TEXT_RESET);
                    break;
                case 2:
                    System.out.println("📄 Listar Todas as Camisas");
                    repositorio.listarTodos();
                    break;
                case 3:
                    System.out.println("🔍 Buscar Camisa por ID");
                    System.out.print("Digite o ID: ");
                    int idBuscar;
                    try {
                        idBuscar = leia.nextInt();
                        leia.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ ID inválido!" + Cores.TEXT_RESET);
                        leia.nextLine();
                        break;
                    }
                    Produto produto = repositorio.buscarPorId(idBuscar);
                    if (produto != null) {
                        System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa encontrada: ID " + produto.getId() + " - " + produto.exibirDetalhes() + Cores.TEXT_RESET);
                    } else {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ Produto não encontrado!" + Cores.TEXT_RESET);
                    }
                    break;
                case 4:
                    System.out.println("✏️ Atualizar Camisa");
                    System.out.print("Digite o ID da camisa: ");
                    int idAtualizar;
                    try {
                        idAtualizar = leia.nextInt();
                        leia.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ ID inválido!" + Cores.TEXT_RESET);
                        leia.nextLine();
                        break;
                    }
                    Produto produtoExistente = repositorio.buscarPorId(idAtualizar);
                    if (produtoExistente != null) {
                        System.out.print("Novo nome da camisa: ");
                        String novoNome = leia.nextLine();
                        System.out.print("Novo preço: ");
                        double novoPreco;
                        try {
                            novoPreco = leia.nextDouble();
                            leia.nextLine();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println(Cores.TEXT_RED_BOLD + "❌ Preço inválido!" + Cores.TEXT_RESET);
                            leia.nextLine();
                            break;
                        }
                        System.out.print("Novo tamanho (P/M/G): ");
                        String novoTamanho = leia.nextLine();
                        Produto camisaAtualizada = new Camisa(idAtualizar, novoNome, novoPreco, novoTamanho);
                        repositorio.atualizar(camisaAtualizada);
                        System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa com ID " + idAtualizar + " atualizada com sucesso!" + Cores.TEXT_RESET);
                    } else {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ Produto não encontrado!" + Cores.TEXT_RESET);
                    }
                    break;
                case 5:
                    System.out.println("🗑 Remover Camisa");
                    System.out.print("Digite o ID: ");
                    int idRemover;
                    try {
                        idRemover = leia.nextInt();
                        leia.nextLine();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ ID inválido!" + Cores.TEXT_RESET);
                        leia.nextLine();
                        break;
                    }
                    Produto produtoRemover = repositorio.buscarPorId(idRemover);
                    if (produtoRemover != null) {
                        repositorio.remover(idRemover);
                        System.out.println(Cores.TEXT_GREEN_BOLD + "✅ Camisa com ID " + idRemover + " removida com sucesso!" + Cores.TEXT_RESET);
                    } else {
                        System.out.println(Cores.TEXT_RED_BOLD + "❌ Produto não encontrado!" + Cores.TEXT_RESET);
                    }
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "❌ Opção inválida!" + Cores.TEXT_RESET);
            }
        }
    }
}