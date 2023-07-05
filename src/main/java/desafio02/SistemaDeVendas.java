package desafio02;

import java.util.ArrayList;
import java.util.List;


public class SistemaDeVendas {
    private List<Venda> vendas;
    private List<Cliente> clientes;
    private List<Vendedor> vendedores;


    //Construtores

    public SistemaDeVendas() {
        this.vendas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
    }

    //Metodos

    public void cadastrarVenda(Venda venda) throws Exception {
        if (!clientes.contains(venda.getCliente())) {
            throw new Exception("Cliente não cadastrado");
        }
        if (!vendedores.contains(venda.getVendedor())) {
            throw new Exception("Vendedor não cadastrado");
        }
        vendas.add(venda);
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {
        try {
            ValidadorDeCliente.validar(cliente, clientes);
        } catch (Exception e) {
            throw e;
        }
        clientes.add(cliente);
    }


    public void cadastrarVendedor(Vendedor vendedor) throws Exception {
        try {
            ValidadorDeVendedor.validar(vendedor, vendedores);
        } catch (Exception e) {
            throw e;
        }
        vendedores.add(vendedor);
    }

    public List<Venda> pesquisarComprasPorCpf(String cpf) {
        List<Venda> resultado = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getCliente().getCpf().equals(cpf)) {
                resultado.add(venda);
            }
        }
        return resultado;
    }

    public List<Venda> pesquisarVendasPorEmail(String email) {
        List<Venda> resultado = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getVendedor().getEmail().equals(email)) {
                resultado.add(venda);
            }
        }
        return resultado;
    }

    //Getters

    public List<Venda> getVendas() {
        return vendas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }
}

