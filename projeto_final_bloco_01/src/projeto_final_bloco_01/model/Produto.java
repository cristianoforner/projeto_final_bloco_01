package projeto_final_bloco_01.model;


public abstract class Produto {
    private int id;
    private String nome;
    private double preco;

    // Construtor
    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método abstrato para exibir detalhes (será implementado pelas subclasses)
    public abstract String exibirDetalhes();

    // Método concreto que pode ser sobrescrito (polimorfismo)
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Preço: R$" + preco;
    }
}