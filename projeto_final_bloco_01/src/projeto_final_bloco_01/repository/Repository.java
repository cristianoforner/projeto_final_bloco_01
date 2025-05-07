package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface Repository {
    void cadastrar(Produto produto);
    void listarTodos();
    Produto buscarPorId(int id);
    void atualizar(Produto produto);
    void remover(int id);
}