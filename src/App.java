import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Conta> contas = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            int opcao = -1;

            while (opcao != 0) {
                System.out.println("\n1 - Criar conta");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sacar");
                System.out.println("4 - Transferir");
                System.out.println("5 - Extrato");
                System.out.println("0 - Sair");

                Integer entrada = lerInteiro(sc, "Opção: ");
                if (entrada == null) {
                    break;
                }
                opcao = entrada;

                if (opcao == 0) {
                    break;
                } else if (opcao == 1) {
                    System.out.print("Nome do titular: ");
                    if (!sc.hasNextLine()) {
                        break;
                    }

                    String titular = sc.nextLine().trim();
                    if (titular.isEmpty()) {
                        System.out.println("O nome do titular não pode ficar vazio.");
                    } else {
                        contas.add(new Conta(titular));
                        System.out.println("Conta criada!");
                    }
                } else if (opcao >= 2 && opcao <= 5) {
                    if (contas.isEmpty()) {
                        System.out.println("Crie uma conta primeiro.");
                        continue;
                    }

                    System.out.println("Escolha a conta:");
                    Conta conta = escolherConta(contas, sc);
                    if (conta == null) {
                        break;
                    }

                    if (opcao == 2) {
                        Double valor = lerValor(sc);
                        if (valor == null) {
                            break;
                        }
                        conta.depositar(valor);
                        System.out.println("Depósito realizado.");
                    } else if (opcao == 3) {
                        Double valor = lerValor(sc);
                        if (valor == null) {
                            break;
                        }
                        conta.sacar(valor);
                    } else if (opcao == 4) {
                        System.out.println("Escolha a conta de destino:");
                        Conta destino = escolherConta(contas, sc);
                        if (destino == null) {
                            break;
                        }

                        Double valor = lerValor(sc);
                        if (valor == null) {
                            break;
                        }
                        conta.transferir(destino, valor);
                    } else {
                        conta.mostrarExtrato();
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
            }

            System.out.println("Até logo!");
        }
    }

    private static Integer lerInteiro(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextLine()) {
                return null;
            }

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static Double lerValor(Scanner sc) {
        while (true) {
            System.out.print("Valor: ");
            if (!sc.hasNextLine()) {
                return null;
            }

            try {
                double valor = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
                if (Double.isFinite(valor) && valor > 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // The input is reported below with the same message as other invalid values.
            }

            System.out.println("Digite um valor positivo válido.");
        }
    }

    private static Conta escolherConta(ArrayList<Conta> contas, Scanner sc) {
        for (int i = 0; i < contas.size(); i++) {
            System.out.println((i + 1) + " - " + contas.get(i).getTitular());
        }

        while (true) {
            Integer numero = lerInteiro(sc, "Número da conta: ");
            if (numero == null) {
                return null;
            }
            if (numero >= 1 && numero <= contas.size()) {
                return contas.get(numero - 1);
            }
            System.out.println("Escolha um número de conta da lista.");
        }
    }
}
