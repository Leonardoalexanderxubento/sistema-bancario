import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Conta c = new Conta("Thiago");
        c.depositar(100);
        c.sacar(30);
        System.out.println(c.getTitular() + " tem R$ " + c.getSaldo());
    }
}