import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

System.out.print("Nome do titular: ");
String nome = sc.nextLine();
Conta c = new Conta(nome);

int opcao = 0;
while (opcao != 5)  {   
    System.out.println("\n1 - Depositar");
    System.out.println("2 - Sacar");
    System.out.println("3 - Ver saldo");
    System.out.println("4 - Extrato");
    System.out.println("5 - Sair");
    System.out.print("Opção: ");
    opcao = sc.nextInt();

    if (opcao == 1) {
        System.out.print("Valor: ");
        c.depositar(sc.nextDouble());
    } else if (opcao == 2) {
        System.out.print("Valor: ");
        c.sacar(sc.nextDouble());
    } else if (opcao == 3) {
        System.out.println(c.getTitular() + " tem R$ " + c.getSaldo());
    } else if (opcao == 4) {
    c.mostrarExtrato();    
    }

}

System.out.println("Até logo!");
sc.close();
    }
}