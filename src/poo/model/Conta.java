package poo.model;

public class Conta {

    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            this.saldo += valor;
            System.out.println("Déposito realizado com sucesso!");
            System.out.println("Saldo: R$" + saldo);
        }
    }

    public void mostrarConta() {
        System.out.println("Número: " + numero);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Saldo: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Saldo: R$" + saldo);
        }
    }

    public int getNumero() {
        return numero;
    }
}


