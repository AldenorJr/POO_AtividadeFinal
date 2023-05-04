package br.com.aldenor.poo.model;

import br.com.aldenor.poo.dto.Contribuinte;

public class ContribuinteJuridico extends Contribuinte {

    public ContribuinteJuridico(String name, double rendaAnual, int numeroFuncio) {
        super(name, rendaAnual);
        this.numeroFuncio = numeroFuncio;
    }

    private int numeroFuncio;

    @Override
    public double gerarImposto() {
        double imposto;
        if(getNumeroFuncio() > 15) imposto = getRendaAnual()*0.15; else imposto = getRendaAnual()*0.16;
        return imposto;
    }

    public int getNumeroFuncio() {
        return numeroFuncio;
    }

    public void setNumeroFuncio(int numeroFuncio) {
        this.numeroFuncio = numeroFuncio;
    }
}
