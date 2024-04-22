package modelo;

import java.util.Scanner;

public class Menu {
    
    private static void printMenu() {
        System.out.println("");
        System.out.println("Bem-vindo(a) ao Banco! Por favor, digite a operação para prosseguir com sua necessidade.");
        System.out.println("");
        System.out.println("1 - Cadastrar Cliente Fisico");
        System.out.println("2 - Cadastrar Cliente Juridico");
        System.out.println("3 - Consultar Cliente");
        System.out.println("4 - Remover Cliente");
        System.out.println("5 - Depositar");
        System.out.println("6 - Sacar");
        System.out.println("7 - Transferir");
        System.out.println("8 - Saldo Total");
        System.out.println("");
        System.out.println("0 - Sair");
    }
    
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner entrada = new Scanner(System.in);
        printMenu();
        int opcao = entrada.nextInt();
        while (opcao != 0) {
            if (opcao == 1) {
                Cliente c = banco.createClienteFisico();
                banco.addCliente(c);
                System.out.println("Cadastro realizado com sucesso!");
            }else if (opcao == 2) {
                Cliente c = banco.createClienteJuridico();
                banco.addCliente(c);
                System.out.println("Cadastro realizado com sucesso!");
            }else if (opcao == 3) {
                System.out.println("Digite o identificador: ");
                int identificador = entrada.nextInt();
                Cliente c = banco.getCliente(identificador);
                if (c == null) {
                    System.out.println("Cliente nao encontrado!");
                }else {
                    System.out.println(c);
                }
            }else if (opcao == 4) {
                System.out.println("Digite o identificador: ");
                int identificador = entrada.nextInt();
                Cliente c = banco.getCliente(identificador);
                if (c == null) {
                    System.out.println("Cliente nao encontrado!");
                }else {
                    banco.removeCliente(c);
                    System.out.println("Cliente deletado com sucesso!");
                }
            }else if (opcao == 5) {
                System.out.println("Digite o ID: ");
                int identificador = entrada.nextInt();
                System.out.println("Digite o valor do deposito: ");
                double valor = entrada.nextDouble();
                Cliente c = banco.getCliente(identificador);
                if (c == null) {
                    System.out.println("Cliente nao encontrado!");
                }else {
                    boolean resultado = c.depositar(valor);
                    if (resultado == false) {
                        System.out.println("Valor invalido para deposito!");
                    }else {
                        System.out.println("Deposito realizado com sucesso!");
                        System.out.println("Novo Saldo: " + c.getSaldo());
                    }
                }
            }else if (opcao == 6) {
                System.out.println("Digite o ID: ");
                int identificador = entrada.nextInt();
                System.out.println("Digite o valor de saque: ");
                double valor = entrada.nextDouble();
                Cliente c = banco.getCliente(identificador);
                if (c == null) {
                    System.out.println("Cliente nao encontrado!");
                }else {
                    boolean resultado = c.sacar(valor);
                    if (resultado == false) {
                        System.out.println("Saldo insuficiente ou valor invalido!");
                    }else {
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Novo Saldo: " + c.getSaldo());
                    }
                }
            }else if (opcao == 7) {
                System.out.println("Digite o ID da conta origem: ");
                int idOrigem = entrada.nextInt();
                System.out.println("Digite o ID da conta destino: ");
                int idDestino = entrada.nextInt();
                System.out.println("Digite o valor da transferencia: ");
                double valor = entrada.nextDouble();
                
                Cliente origem = banco.getCliente(idOrigem);
                Cliente destino = banco.getCliente(idDestino);
                if (origem == null) {
                    System.out.println("Cliente Origem nao encontrado! ID: " + idOrigem);
                }else if (destino == null) {
                    System.out.println("Cliente Destino nao encontrado! ID: " + idDestino);
                }else if (origem.getId() == destino.getId()) {
                    System.out.println("Contas iguais! Digite outro ID novamente.");
                }else {
                    boolean resultado = origem.transferir(destino, valor);
                    if (resultado == false) {
                        System.out.println("Saldo insuficiente ou valor invalido!");
                    }else {
                        System.out.println("Transferencia realizada com sucesso!");
                        System.out.println("Saldo Origem.: " + origem.getSaldo());
                        System.out.println("Saldo Destino: " + destino.getSaldo());
                    }
                }
            }else if (opcao == 8) { 
                float saldoTotal = banco.getSaldoTotal();
                System.out.println("Saldo Total: " + saldoTotal);
            }
            
            printMenu();
            opcao = entrada.nextInt();
        }
    }
}
