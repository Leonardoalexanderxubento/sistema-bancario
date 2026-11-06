public class Conta {
    // atributos: o que a conta TEM
    private String titular;
    private double saldo;

    // construtor: roda quando a conta é criada
    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    // métodos: o que a conta FAZ
    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}