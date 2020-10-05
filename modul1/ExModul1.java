package com.company.modul1;

public class ExModul1 {

    public static void main(String[] args) {
        //Fase 1
        String nom = "Jordi";
        String cognom1 = "Gonzalez";
        String cognom2 = "Palo";
        int dia = 7;
        int mes = 4;
        int any = 1977;
        System.out.println(nom + " " + cognom1 + " " + cognom2);
        System.out.println(dia + "/" + mes + "/" + any);
        System.out.println();

        //Fase2
        final int ANY_TRASPAS_INICIAL = 1948;
        int anysCadaTraspas = 4;
        double anysTotalsTraspas = (any - ANY_TRASPAS_INICIAL) / anysCadaTraspas;
        System.out.println("Hi ha un total de " + anysTotalsTraspas + " anys de traspàs.");
        System.out.println();

        //Fase3
        int anyTraspasInicial = 1948;
        boolean esDeTraspas = false;
        String respostaAfirmativa = "és de traspàs.";
        String respostaNegativa = "no és de traspàs.";

        for (int i = anyTraspasInicial; i <= any; i++) {
            if ((i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0)) {
                System.out.println(i);
            }
        }
        System.out.println();

        //3.Ara mirem si l'any de naixament és de traspàs
        //creem el boolean
        if ((any % 4 == 0) && (any % 100 != 0) || (any % 400 == 0)) {
            esDeTraspas = true;
        } else {
            esDeTraspas = false;
        }
        //4. amb el boolean imprimim el resultat.
        //Nota: 3 i 4 es podrien compactar en un sol if/else
        if (esDeTraspas) {
            System.out.println(respostaAfirmativa);
        } else {
            System.out.println(respostaNegativa);
        }
        //Fase 4
        String nomComplet = nom + " " + cognom1 + " " + cognom2;
        String dataNaixament = dia + "/" + mes + "/" + any;
        String respostaFinal = "";

            if(esDeTraspas == true) {
                respostaFinal = respostaAfirmativa;
            } else {
                respostaFinal = respostaNegativa;
            }
        System.out.println("El meu nom és: " + nomComplet);
        System.out.println("Vaig nèixer el " + dataNaixament);
        System.out.println("El meu any de naixement " + respostaFinal);
    }
}

