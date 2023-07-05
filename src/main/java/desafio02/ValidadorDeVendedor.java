package desafio02;

import java.util.List;

public class ValidadorDeVendedor {

    //Exceptions
    public static void validar(Vendedor vendedor, List<Vendedor> vendedores) throws Exception {
        if (vendedores.contains(vendedor)) {
            throw new Exception("Vendedor já cadastrado");
        }
        if (!vendedor.getEmail().contains("@")) {
            throw new Exception("E-mail inválido");
        }
        for (Vendedor v : vendedores) {
            if (v.getCpf().equals(vendedor.getCpf())) {
                throw new Exception("Já existe um vendedor cadastrado com esse CPF");
            }
            if (v.getEmail().equals(vendedor.getEmail())) {
                throw new Exception("Já existe um vendedor cadastrado com esse e-mail");
            }
        }
    }
}
