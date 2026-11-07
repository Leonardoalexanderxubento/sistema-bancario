import java.util.ArrayList;

public class Conta {
    private String titular;
    private double saldo;
    private ArrayList<String> extrato;   // lista de movimentações

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
    }

    public void depositar(double valor) {
        saldo = saldo + valor;
        extrato.add("Depósito: +R$ " + valor);
    }

    // agora devolve true (deu certo) ou false (não deu)
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            extrato.add("Saque: -R$ " + valor);
            return true;
        }
        System.out.println("Saldo insuficiente!");
        return false;
    }

    public void transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {           // só deposita se o saque der certo
            destino.depositar(valor);
            extrato.add("Transferência para " + destino.getTitular());
        }
    }

    public void mostrarExtrato() {
        System.out.println("--- Extrato de " + titular + " ---");
        for (String linha : extrato) {     // passa por cada item da lista
            System.out.println(linha);
        }
        System.out.println("Saldo: R$ " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}