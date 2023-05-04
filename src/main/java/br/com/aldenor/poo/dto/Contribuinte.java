package br.com.aldenor.poo.dto;

public abstract class Contribuinte {

    public Contribuinte(String name, double rendaAnual) {
        this.name = name;
        this.rendaAnual = rendaAnual;
    }

    private String name;
    private double rendaAnual;

    public abstract double gerarImposto();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }
}
