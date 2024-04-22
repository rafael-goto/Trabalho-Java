package modelo;

public class Teste {
    
    public static void main(String[] args) {
//        Banco b = new Banco();
//        Cliente c = b.createClienteFisico();
//        c.depositar(500);
//        System.out.println(c);
//        
//        Cliente cj = b.createClienteJuridico();
//        System.out.println(cj);


        Cliente c1 = new Cliente(1, "Fisico", "Rafael", "140499421");
        c1.depositar(300);
        
        Cliente c2 = new Cliente(2, "Juridico", "Diogo", "695883021");
        
        System.out.println(c1.getSaldo());
        System.out.println(c2.getSaldo());
        
        c1.transferir(c2, 900);
        
        System.out.println(c1.getSaldo());
        System.out.println(c2.getSaldo());
    }
}
