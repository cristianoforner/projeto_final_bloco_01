package projeto_final_bloco_01.repository;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Produto;


public class ProdutoRepository implements Repository {
    private List<Produto> produtos;
    private static int proximoId = 1;

    public ProdutoRepository() {
        produtos = new ArrayList<>();
    }

    @Override
    public void cadastrar(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
        
    }

    @Override
    public void listarTodos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.exibirDetalhes());
            }
        }
    }

    @Override
    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }

    @Override
    public void atualizar(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                
                return;
            }
        }
        System.out.println("❌ Produto não encontrado!");
    }

    @Override
    public void remover(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                produtos.remove(i);
               
                return;
            }
        }
        System.out.println("❌ Produto não encontrado!");
    }

	}
