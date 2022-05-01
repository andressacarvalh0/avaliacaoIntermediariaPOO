package src.Controle.Impl.Excecoes;

public class PilotoNaoEncontradoException extends Exception {
    public PilotoNaoEncontradoException(String cpf) {
        super("Não foi possível encontrar o piloto com o CPF: " + cpf);
    }   
}