package desafio02;

public class Venda {
    private Cliente cliente;
    private Vendedor vendedor;
    private double valor;
    private String data;

    //Construtores

    public Venda(Cliente cliente, Vendedor vendedor, double valor, String data) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valor = valor;
        this.data = data;
    }

    //Getters

    public Cliente getCliente() {

        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    //to string
    @Override
    public String toString() {
        return "Venda{" +
                "cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", valor=" + valor +
                ", data='" + data + '\'' +
                '}';
    }
}
