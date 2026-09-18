package model;

public class Conta {

    private int numero;
    private String  titular;
    private double saldo;
    private static int quantidadeContas; // pertence a classe

    public Conta(int numero, String titular, double saldo) {

        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }

        if (numero <= 0) {
            throw new IllegalArgumentException("O número da conta deve ser maior que zero.");
        }

        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;

        quantidadeContas++; 
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){ // PROPRIA CONTA DECIDE SE O DEPOSITO É VALIDO
        if (valor <= 0) { // se o valor for menor ou igual a zero
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        saldo += valor;

    }

    public void sacar(double valor) throws SaldoInsuficienteException { // se o valor for maior q 0 e for menor ou igual ao saldo pode sacar
        if (valor <= 0) { // se valor for menor ou igual a zero
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        if (valor > saldo) { // se valor for maior q o saldo
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    public static int getQuantidadeContas() {
        return quantidadeContas;
    }
    
}
