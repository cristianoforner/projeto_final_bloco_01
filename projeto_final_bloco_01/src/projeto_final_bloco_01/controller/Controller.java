package projeto_final_bloco_01.controller;



import java.util.List;

import projeto_final_bloco_01.repository.ProdutoRepository;
import projeto_final_bloco_01.repository.Repository;
import projeto_final_bloco_01.model.Camisa;
import projeto_final_bloco_01.model.Produto;

public class Controller {
    private Repository repositorio;

    public Controller() {
        this.repositorio = new ProdutoRepository();
    }

    // Create (Cadastrar Camisa)
    public void cadastrarCamisa(String nome, double preco, String tamanho) throws IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da camisa não pode ser vazio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        if (!tamanho.equalsIgnoreCase("P") && !tamanho.equalsIgnoreCase("M") && !tamanho.equalsIgnoreCase("G")) {
            throw new IllegalArgumentException("Tamanho deve ser P, M ou G.");
        }
        Produto camisa = new Camisa(0, nome, preco, tamanho); // ID será gerado pelo repositório
        repositorio.cadastrar(camisa);
    }

    // Read (Listar Todas as Camisas)
    public List<Produto> listarCamisas() {
        // Não precisamos de exceções aqui, pois o repositório já lida com a lista vazia
        return ((ProdutoRepository) repositorio).getProdutos(); // Método auxiliar necessário no ProdutoRepository
    }

    // Read (Buscar Camisa por ID)
    public Produto buscarCamisaPorId(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        Produto produto = repositorio.buscarPorId(id);
        if (produto == null) {
            throw new IllegalArgumentException("Camisa com ID " + id + " não encontrada.");
        }
        return produto;
    }

    // Update (Atualizar Camisa)
    public void atualizarCamisa(int id, String nome, double preco, String tamanho) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da camisa não pode ser vazio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        if (!tamanho.equalsIgnoreCase("P") && !tamanho.equalsIgnoreCase("M") && !tamanho.equalsIgnoreCase("G")) {
            throw new IllegalArgumentException("Tamanho deve ser P, M ou G.");
        }
        Produto camisa = new Camisa(id, nome, preco, tamanho);
        repositorio.atualizar(camisa);
    }

    // Delete (Remover Camisa)
    public void removerCamisa(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        Produto produto = repositorio.buscarPorId(id);
        if (produto == null) {
            throw new IllegalArgumentException("Camisa com ID " + id + " não encontrada.");
        }
        repositorio.remover(id);
    }
}
