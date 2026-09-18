package poo.teste;

import poo.model.Cliente;
import poo.model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBanco {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("       SISTEMA BANCÁRIO");
            System.out.println("==============================");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do cliente: ");
                String nome = scanner.nextLine();

                System.out.print("CPF do cliente: ");
                String cpf = scanner.nextLine();

                Cliente cliente = new Cliente(nome, cpf);

                int numeroConta = contas.size() + 1;

                Conta conta = new Conta(numeroConta, cliente);

                contas.add(conta);

                System.out.println("Conta criada com sucesso!");
            }

            else if (opcao == 2) {
                if (contas.isEmpty()) {
                    System.out.println("Nenhuma conta cadastrada.");
                } else {
                    for (Conta c : contas) {
                        System.out.println("----------------------------");
                        c.mostrarConta();
                    }
                }
            }

            else if (opcao == 3) {
                System.out.print("Digite o número da conta: ");
                int numero = scanner.nextInt();

                Conta contaEncontrada = buscarConta(contas, numero);

                if (contaEncontrada == null) {
                    System.out.println("Conta não encontrada.");
                } else {
                    System.out.print("Valor para depósito: ");
                    double valor = scanner.nextDouble();
                    contaEncontrada.depositar(valor);
                }
            }

            else if (opcao == 4) {
                System.out.print("Digite o número da conta: ");
                int numero = scanner.nextInt();

                Conta contaEncontrada = buscarConta(contas, numero);

                if (contaEncontrada == null) {
                    System.out.println("Conta não encontrada.");
                } else {
                    System.out.print("Valor para saque: ");
                    double valor = scanner.nextDouble();
                    contaEncontrada.sacar(valor);
                }
            }
        } while (opcao != 0);
        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    public static Conta buscarConta(ArrayList<Conta> contas, int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }
}