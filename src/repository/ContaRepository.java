package repository;

import model.Conta;
import java.util.ArrayList;

public class ContaRepository {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionar(Conta conta) {
        contas.add(conta);
    }

    public ArrayList<Conta> listar() {
        return contas;
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
