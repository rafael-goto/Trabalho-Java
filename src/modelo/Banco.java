package modelo;

import java.util.Scanner;

public class Banco {
    private Cliente[] clientes = new Cliente[100];
    
    public Cliente createClienteFisico() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o Id: ");
        int id = entrada.nextInt();
        System.out.println("Digite o Nome: ");
        String nome = entrada.next();
        System.out.println("Digite o CPF: ");
        String documento = entrada.next();
        Cliente cliente = new Cliente(id, "Fisico", nome, documento);
        return cliente;
    }
    
    public Cliente createClienteJuridico() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o Id: ");
        int id = entrada.nextInt();
        System.out.println("Digite o Nome: ");
        String nome = entrada.next();
        System.out.println("Digite o CNPJ: ");
        String documento = entrada.next();
        Cliente cliente = new Cliente(id, "Juridico", nome, documento);
        return cliente;
    }
    
}
