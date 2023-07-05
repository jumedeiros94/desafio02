package desafio02;

import java.util.List;
public class ValidadorDeCliente {

    //Exceptions
    public static void validar(Cliente cliente, List<Cliente> clientes) throws Exception {
    if (clientes.contains(cliente)) {
        throw new Exception("Cliente já cadastrado");
    }
    if (!cliente.getEmail().contains("@")) {
        throw new Exception("E-mail inválido");
    }
    for (Cliente c : clientes) {
        if (c.getCpf().equals(cliente.getCpf())) {
            throw new Exception("Já existe um cliente cadastrado com esse CPF");
        }
        if (c.getEmail().equals(cliente.getEmail())) {
            throw new Exception("Já existe um cliente cadastrado com esse e-mail");
        }
        }
    }
}


