package src.Controle.Impl;

import src.Controle.Pessoa;

public class Piloto extends Pessoa{
    private String _cht;
    private Aeronave _veiculo;

    public Piloto(String nome, String cht, String cpf) {
        super(nome, cpf);
        _cht = cht;
    }

    public String getCnh() {
        return _cht;
    }

    public Aeronave getVeiculo() {
        return _veiculo;
    }

    public void setVeiculo(Aeronave aeronave) {
        _veiculo = aeronave;
    }

    @Override
    public String toString() {
        return super.toString() + ":[cth=" + _cht + ", Aeronave=" + _veiculo + "]";
    }

    @Override
    public String getTipo() {
        return "Piloto";
    }
    
}
