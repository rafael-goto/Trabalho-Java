package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public void removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }
    
    public Cliente getCliente(int identificador) {
        for (Cliente c : this.clientes) {
            if (c.getId() == identificador) {
                return c;
            }
        }
        return null;
    }
    
    
    public Cliente createClienteFisico() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o ID: ");
        int id = entrada.nextInt();
        System.out.println("Digite o Nome Completo: ");
        String nome = entrada.next();
        System.out.println("Digite o Documento: ");
        String documento = entrada.next();
        Cliente cliente = new Cliente(id, "Fisico", nome, documento);
        return cliente;
    }
    
    public Cliente createClienteJuridico() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o ID: ");
        int id = entrada.nextInt();
        System.out.println("Digite o Nome Fantasia: ");
        String nome = entrada.next();
        System.out.println("Digite o CNPJ: ");
        String documento = entrada.next();
        Cliente cliente = new Cliente(id, "Juridico", nome, documento);
        return cliente;
    }
    
    public float getSaldoTotal() {
        float saldoTotal = 0;
        for (Cliente c : clientes) {
            saldoTotal += c.getSaldo();
            System.out.println(c.getSaldo());
        }
        
        
        return saldoTotal;
    }
    
}
