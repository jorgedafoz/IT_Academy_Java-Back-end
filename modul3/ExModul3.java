package com.company.modul3;

import java.util.*;


public class ExModul3 {

    public static void main(String[] args) {
        //Fase1
        String ciutat1;
        String ciutat2;
        String ciutat3;
        String ciutat4;
        String ciutat5;
        String ciutat6;

        Scanner lector = new Scanner(System.in);
        System.out.println("Escriu el nom d'una ciutat");
        ciutat1 = lector.nextLine();
        System.out.println("Escriu el nom d'una altre ciutat");
        ciutat2 = lector.nextLine();
        System.out.println("Escriu el nom d'una altre ciutat");
        ciutat3 = lector.nextLine();
        System.out.println("Escriu el nom d'una altre ciutat");
        ciutat4 = lector.nextLine();
        System.out.println("Escriu el nom d'una altre ciutat");
        ciutat5 = lector.nextLine();
        System.out.println("Escriu el nom d'una altre ciutat");
        ciutat6 = lector.nextLine();

        System.out.println(ciutat1 + ", " + ciutat2 + ", " + ciutat3 + ", " + ciutat4 + ", " + ciutat5 + ", " + ciutat6);

        //Fase2
        //ordenem l'array i l'imprimim
        String[] arrayCiutats = {ciutat1, ciutat2, ciutat3, ciutat4, ciutat5, ciutat6};

        Arrays.sort(arrayCiutats);

        for (String i : arrayCiutats) {
            System.out.print(i + " ");
        }
        System.out.println();

        //fase3
        //passem l'array a string per substituïr el cha 'a' per 4
        String arrayCiutatsString = Arrays.toString(arrayCiutats);
        String ciutatsModificades = arrayCiutatsString.replaceAll("a", "4");
        //passem l'string a array de nou per ordenar-lo
        String[] arrayCiutatsModificades = ciutatsModificades.split(" ");
        Arrays.sort(arrayCiutatsModificades);

        for (String i : arrayCiutatsModificades) {
            System.out.print(i + " ");
        }
        System.out.println();

        //Fase 4
        //creem arrays de la mida del nom que acollirà
        char[] barcelona = new char[ciutat1.length()];
        char[] madrid = new char[ciutat2.length()];
        char[] valencia = new char[ciutat3.length()];
        char[] malaga = new char[ciutat4.length()];
        char[] cadis = new char[ciutat5.length()];
        char[] santander = new char[ciutat6.length()];

        //cridem el mètode per omplir
        barcelona = ompleArray(ciutat1);
        madrid = ompleArray(ciutat2);
        valencia = ompleArray(ciutat3);
        malaga = ompleArray(ciutat4);
        cadis = ompleArray(ciutat5);
        santander = ompleArray(ciutat6);

        //cridem el mètode per imprimir invertit
        imprimeixInvertit(barcelona);
        imprimeixInvertit(madrid);
        imprimeixInvertit(valencia);
        imprimeixInvertit(malaga);
        imprimeixInvertit(cadis);
        imprimeixInvertit(santander);
    }
    //fem un mètode per omplir els arrays
    private static char[] ompleArray(String ciutat) {
        char[] arrayPle= new char[ciutat.length()];
        for (int i=0; i < ciutat.length(); i++) {
            arrayPle[i] = ciutat.charAt(i);
        }
        return arrayPle;
    }

    //fem un mètode per imprimir al revés els arrays
    private static char[] imprimeixInvertit(char[] array){
        char[] arrayInvertit = new char[array.length];
        int inicio= array.length-1;
        for (int i = inicio; i >= 0; i--) {
            arrayInvertit[i] = array[inicio -i];
         }
        System.out.println(arrayInvertit);
        return arrayInvertit;
    }
}