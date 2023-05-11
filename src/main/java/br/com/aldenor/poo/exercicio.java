package br.com.aldenor.poo;

import br.com.aldenor.poo.dto.Contribuinte;
import br.com.aldenor.poo.model.ContribuinteFisico;
import br.com.aldenor.poo.model.ContribuinteJuridico;

import java.util.ArrayList;
import java.util.Scanner;

public class exercicio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numero de impostos para calcular.");
        int contribuintes = startContribuinte();
        int impostoTotal = 0;
        ArrayList<Contribuinte> listContribuintes = new ArrayList<>();
        while(listContribuintes.size() < contribuintes) {
            System.out.println("Contribuinte º" + (listContribuintes.size()+1));
            System.out.println("Pessoa física ou jurídica (f/j)?");
            char type = startType();
            System.out.println("Digite o nome:");
            String nome = scanner.next();
            System.out.println("Digite renda anual: ");
            double rendaAnual = startRendaAnual();
            if(type == 'f') {
                System.out.println("Digite gasto com saúde: ");
                double saude = startGastoSaudeAnual();
                ContribuinteFisico contribuinteFisico = new ContribuinteFisico(nome, rendaAnual, saude);
                System.out.println("Imposto de " + contribuinteFisico.getName() + ", terá que pagar: " + contribuinteFisico.gerarImposto());
                System.out.println("");
                listContribuintes.add(contribuinteFisico);
                impostoTotal += contribuinteFisico.gerarImposto();
            }
            if(type == 'j') {
                System.out.println("Digite numero de funcionários: ");
                int numeroFuncionario = startFuncionario();
                ContribuinteJuridico contribuinteJuridico = new ContribuinteJuridico(nome, rendaAnual, numeroFuncionario);
                System.out.println("Imposto de " + contribuinteJuridico.getName() + ", terá que pagar: " + contribuinteJuridico.gerarImposto());
                System.out.println("");
                listContribuintes.add(contribuinteJuridico);
                impostoTotal += contribuinteJuridico.gerarImposto();
            }
        }
        for(Contribuinte contribuinte : listContribuintes) {
            System.out.println(contribuinte.getName() + " terá que pagar: " + contribuinte.gerarImposto());
        }
        System.out.println("");
        System.out.println("Total em impostos que deveram ser pagos, são: " + impostoTotal);
    }

    public static char startType() {
        Scanner scanner = new Scanner(System.in);
        char type;
        while (true) {
            String scanned = scanner.next();
            if(scanned.equalsIgnoreCase("f")) {
                type = scanned.charAt(0);
                break;
            }
            else if(scanned.equalsIgnoreCase("j")) {
                type = scanned.charAt(0);
                break;
            }
            System.out.println("Você não digitou um valor válido. Tente novamente, você pode escolher entre Pessoa física (f) ou jurídica (j)");
        }
        return type;
    }

    public static int startFuncionario() {
        Scanner scanner = new Scanner(System.in);
        int numberFuncionarios = 0;
        while(numberFuncionarios == 0) {
            String number = scanner.next();
            if (isNumber(number)) {
                if(Integer.parseInt(number) < 0) {
                    System.out.println("Digite um valor maior que ZERO.");
                    continue;
                }
                numberFuncionarios = Integer.parseInt(number);
            } else System.out.println("Você precisa digite um numero valido.");
        }
        return numberFuncionarios;
    }

    public static int startRendaAnual() {
        Scanner scanner = new Scanner(System.in);
        int rendaAnual = 0;
        while(rendaAnual == 0) {
            String number = scanner.next();
            if (isNumber(number)) {
                if(Integer.parseInt(number) < 0) {
                    System.out.println("Digite um valor maior que ZERO.");
                    continue;
                }
                rendaAnual = Integer.parseInt(number);
            } else System.out.println("Você precisa digite um numero valido.");
        }
        return rendaAnual;
    }

    public static int startGastoSaudeAnual() {
        Scanner scanner = new Scanner(System.in);
        int rendaAnual = 0;
        while(rendaAnual == 0) {
            String number = scanner.next();
            if (isNumber(number)) {
                if(Integer.parseInt(number) < 0) {
                    System.out.println("Digite um valor maior que ZERO.");
                    continue;
                }
                if(Integer.parseInt(number) == 0) return 0;
                rendaAnual = Integer.parseInt(number);
            } else System.out.println("Você precisa digite um numero valido.");
        }
        return rendaAnual;
    }

    public static int startContribuinte() {
        Scanner scanner = new Scanner(System.in);
        int contribuintes = 0;
        while(contribuintes == 0) {
            String number = scanner.next();
            if (isNumber(number)) {
                if(Integer.parseInt(number) < 0) {
                    System.out.println("Digite um valor maior que ZERO.");
                    continue;
                }
                contribuintes = Integer.parseInt(number);
            } else System.out.println("Você precisa digitar um numero de contribuintes valido.");
        }
        return contribuintes;
    }


    public static boolean isNumber(String scanned) {
        try {
            Integer.parseInt(scanned);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
