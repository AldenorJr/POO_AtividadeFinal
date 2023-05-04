package br.com.aldenor.poo.model;

import br.com.aldenor.poo.dto.Contribuinte;

public class ContribuinteFisico extends Contribuinte {

    private double gastoSaude;

    public ContribuinteFisico(String name, double rendaAnual, double gastoSaude) {
        super(name, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    @Override
    public double gerarImposto() {
        double imposto;
        if(getRendaAnual() > 20000) imposto = getRendaAnual()*0.25; else imposto = getRendaAnual()*0.15;
        if(gastoSaude > 0) imposto = imposto-(gastoSaude/2);
        if(imposto < 0) return 0.00;
        return imposto;
    }

    public double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }
}
