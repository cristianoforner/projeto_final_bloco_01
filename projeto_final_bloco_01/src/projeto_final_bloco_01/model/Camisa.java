package projeto_final_bloco_01.model;


public class Camisa extends Produto {
    private String tamanho; // Ex.: P, M, G

    // Construtor com sobrecarga
    public Camisa(int id, String nome, double preco, String tamanho) {
        super(id, nome, preco); // Chama o construtor da superclasse
        this.tamanho = tamanho;
    }

    // Construtor sobrecarregado (sem tamanho)
    public Camisa(int id, String nome, double preco) {
        this(id, nome, preco, "M"); // Tamanho padrão: M
    }

    // Getter e Setter para tamanho
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // Implementação do método abstrato
    
    @Override
    public String exibirDetalhes() {
        return "Camisa: " + getNome() + ", Tamanho: " + tamanho + ", Preço: R$" + getPreco();
    }

    // Sobrescrita do método toString
    @Override
    public String toString() {
        return super.toString() + ", Tamanho: " + tamanho;
    }
}