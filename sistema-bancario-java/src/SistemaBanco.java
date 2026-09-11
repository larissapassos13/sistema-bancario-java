import java.util.Scanner;

public class SistemaBanco {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        Banco banco = new Banco();

        while (true) {

            System.out.println("1 - Cadastrar conta\n" +
                    "2 - Depositar\n" +
                    "3 - Sacar\n" +
                    "4 - Consultar saldo\n" +
                    "5 - Listar contas\n" +
                    "6 - Sair\n" +
                    "Digite uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta: ");
                    int contanum =  scanner.nextInt();

                    if (banco.buscarConta(contanum) != null) {
                        System.out.println("Conta já existe!");
                        break;
                    }

                    System.out.println("Digite o nome do titular: ");
                    scanner.nextLine();
                    String titular = scanner.nextLine();
                    System.out.println("Digite o saldo inicial do titular: ");
                    double saldo = scanner.nextDouble();


                    try {
                        boolean cadastrou = banco.cadastrarConta(new Conta(contanum, titular, saldo));
                        if (cadastrou) {
                            System.out.println("Conta cadastrada com sucesso!");
                        } else {
                            System.out.println("Conta já existe!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Digite o número da conta: ");
                    int numero1 = scanner.nextInt();

                    Conta contaDeposito = banco.buscarConta(numero1);

                    if (contaDeposito == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.println("Quanto você deseja depositar: ");
                        double valor1 = scanner.nextDouble();

                        try {
                            contaDeposito.depositar(valor1);
                            System.out.println("Depositado com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o número da conta: ");
                    int numero2 = scanner.nextInt();

                    Conta contaSacar = banco.buscarConta(numero2);

                    if (contaSacar == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.println("Quanto você deseja sacar: ");
                        double valor2 = scanner.nextDouble();

                        try {
                            contaSacar.sacar(valor2);
                            System.out.println("Sacado com sucesso!");
                        } catch (SaldoInsuficienteException e) {
                            System.out.println(e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite o número da conta: ");
                    int numeroConta = scanner.nextInt();

                    Conta contaEncontrada = banco.buscarConta(numeroConta);

                    if (contaEncontrada == null) {
                        System.out.println("Conta não encontrada!");
                    } else {
                        System.out.println("Seu saldo é: " + contaEncontrada.getSaldo());
                    }
                    break;
                case 5:
                    banco.listarContas();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return; // break faria o menu aparecer dnv
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
