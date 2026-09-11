import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>(); // Banco possui uma lista de objetos Conta

    public boolean cadastrarConta(Conta conta) {
        if (buscarConta(conta.getNumero()) != null) {
            return false;
        }
        contas.add(conta);
        return true;
    }

    public void listarContas() {
        for (int i = 0; i<contas.size(); i++) {
            Conta conta = contas.get(i);

            System.out.println("Número: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Saldo: " + conta.getSaldo());
        }
    }

    public Conta buscarConta(int numero) {
        for (int i = 0; i < contas.size(); i++) { // percorre as contas
            Conta conta = contas.get(i);
            if (conta.getNumero() == numero) { // compara o numero
                return conta;
            }
        }
        return null;
    }
}
