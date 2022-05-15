package src.models;

public class Estoque {
    private Produto produto;
    private int quantidade;

    private String id;

    public Estoque(Produto produto, int quantidade, String id) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
