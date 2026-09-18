package system;

import java.util.Scanner;
import model.SaldoInsuficienteException;
import model.Conta;
import service.ContaService;

public class SistemaBanco {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContaService service = new ContaService();

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
                    int contanum = scanner.nextInt();

                    System.out.println("Digite o nome do titular: ");
                    scanner.nextLine();
                    String titular = scanner.nextLine();

                    System.out.println("Digite o saldo inicial do titular: ");
                    double saldo = scanner.nextDouble();

                    try {
                        boolean cadastrou = service.cadastrarConta(
                                new Conta(contanum, titular, saldo)
                        );

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

                    System.out.println("Quanto você deseja depositar: ");
                    double valor1 = scanner.nextDouble();

                    try {
                        service.depositar(numero1, valor1);
                        System.out.println("Depositado com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da conta: ");
                    int numero2 = scanner.nextInt();

                    System.out.println("Quanto você deseja sacar: ");
                    double valor2 = scanner.nextDouble();

                    try {
                        service.sacar(numero2, valor2);
                        System.out.println("Saque realizado com sucesso!");

                    } catch (SaldoInsuficienteException e) {
                        System.out.println(e.getMessage());

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da conta: ");
                    int numeroConta = scanner.nextInt();

                    Conta contaEncontrada = service.buscarConta(numeroConta);

                    if (contaEncontrada == null) {
                        System.out.println("Conta não encontrada!");
                    } else {
                        System.out.println("Seu saldo é: " + contaEncontrada.getSaldo());
                    }
                    break;

                case 5:
                    for (Conta conta : service.listarContas()) {
                        System.out.println("Número: " + conta.getNumero());
                        System.out.println("Titular: " + conta.getTitular());
                        System.out.println("Saldo: " + conta.getSaldo());
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}