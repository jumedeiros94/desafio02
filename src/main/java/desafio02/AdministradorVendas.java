package desafio02;

import java.util.List;
import java.util.Scanner;


public class AdministradorVendas {
    public static void main(String[] args) throws Exception {
        SistemaDeVendas sistema = new SistemaDeVendas();

        Scanner scanner = new Scanner(System.in);


        //Entrada cliente

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Mostrar todos os clientes");
            System.out.println("3 - Adicionar vendedores");
            System.out.println("4 - Mostrar todos os vendedores");
            System.out.println("5 - Adicionar venda");
            System.out.println("6 - Mostrar todos as vendas");
            System.out.println("7 - Mostrar compras do cliente");
            System.out.println("8 - Mostrar vendas do vendedor");
            System.out.println("9 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                //Adicionar cliente
                System.out.println("Digite o nome do cliente:");
                String nome = scanner.nextLine();
                System.out.println("Digite o email do cliente:");
                String email = scanner.nextLine();
                System.out.println("Digite o cpf do cliente:");
                String cpf = scanner.nextLine();
                try {
                    Cliente cliente = new Cliente(nome, email, cpf);
                    sistema.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 2) {
                // Mostrar todos os clientes
                for (Cliente cliente : sistema.getClientes()) {
                    System.out.println(cliente.toString());
                }
            } else if (opcao == 3) {
                // Adicionar vendedor
                System.out.println("Digite o nome do vendedor:");
                String nome = scanner.nextLine();
                System.out.println("Digite o email do vendedor:");
                String email = scanner.nextLine();
                System.out.println("Digite o cpf do vendedor:");
                String cpf = scanner.nextLine();
                try {
                    Vendedor vendedor = new Vendedor(nome, email, cpf);
                    sistema.cadastrarVendedor(vendedor);
                    System.out.println("Vendedor adicionado com sucesso!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 4) {
                // Mostrar todos os vendedores
                for (Vendedor vendedor : sistema.getVendedores()) {
                    System.out.println(vendedor.toString());
                }
            } else if (opcao == 5) {
                // Adicionar vendas
                System.out.println("Digite o nome do Cliente:");
                String nomeCliente = scanner.nextLine();
                System.out.println("Digite o nome do Vendedor:");
                String nomeVendedor = scanner.nextLine();
                System.out.println("Digite o valor da venda:");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer do Scanner
                System.out.println("Digite a data da venda:");
                String data = scanner.nextLine();

                Cliente cliente = null;
                for (Cliente c : sistema.getClientes()) {
                    if (c.getNome().equals(nomeCliente)) {
                        cliente = c;
                        break;
                    }
                }

                Vendedor vendedor = null;
                for (Vendedor v : sistema.getVendedores()) {
                    if (v.getNome().equals(nomeVendedor)) {
                        vendedor = v;
                        break;
                    }
                }

                if (cliente == null) {
                    System.out.println("Cliente não encontrado");
                } else if (vendedor == null) {
                    System.out.println("Vendedor não encontrado");
                } else {
                    try {
                        Venda venda = new Venda(cliente, vendedor, valor, data);
                        sistema.cadastrarVenda(venda);
                        System.out.println("Venda cadastrada com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            } else if (opcao == 6) {
                //mostrar todas as vendas
                for (Venda venda : sistema.getVendas()) {
                    System.out.println(venda.toString());
                }
            } else if (opcao == 7) {
                //pesquisar compras de cliente por cpf
                System.out.println("Digite o CPF do cliente:");
                String cpf = scanner.nextLine();
                List<Venda> compras = sistema.pesquisarComprasPorCpf(cpf);
                System.out.println("Compras do cliente com CPF " + cpf + ":");
                for (Venda venda : compras) {
                    System.out.println(venda);
                }

            } else if (opcao == 8) {
                //pesquisar vendas de vendedores por email
                System.out.println("Digite o e-mail do vendedor:");
                String email = scanner.nextLine();
                List<Venda> vendas = sistema.pesquisarVendasPorEmail(email);
                System.out.println("Vendas do vendedor com e-mail " + email + ":");
                for (Venda venda : vendas) {
                    System.out.println(venda);
                }

            } else if (opcao == 9) {
                //sair
                System.out.println("Obrigada, até logo! ");
                break;
            } else {
                // Opção inválida
                System.out.println("Opção inválida!");
            }

        }
    }
}


