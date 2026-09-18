package service;

import java.util.List;
import model.Conta;
import model.SaldoInsuficienteException;
import repository.ContaRepository;

public class ContaService {

    private final ContaRepository repository;

    public ContaService() {
        repository = new ContaRepository();
    }

    public boolean cadastrarConta(Conta conta) { // verifica a duplicidade da conta
        if (repository.buscarConta(conta.getNumero()) != null) {
            return false;
        }

        repository.adicionar(conta);
        return true;
    }

    public Conta buscarConta(int numero) { // pede pro repository buscar
        return repository.buscarConta(numero);
    }

    public void depositar(int numero, double valor) { // localiza e deposita
        Conta conta = repository.buscarConta(numero);

        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada!");
        }

        conta.depositar(valor);
    }

    public void sacar(int numero, double valor) throws SaldoInsuficienteException {
        Conta conta = repository.buscarConta(numero);

        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada!");
        }

        conta.sacar(valor);
    }

    public List<Conta> listarContas() { // vai servir de ponte entre sistema e repository
        return repository.listar();
    }
}
