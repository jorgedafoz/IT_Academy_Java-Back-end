package com.company.modul2;

import java.util.*;


public class ExModul2 {
    public static void main(String[] args) {
        //Fase 1
        char[] arrayNom = {'J','O','R','D','I'};
        for (char lletraLlegida : arrayNom) {
            System.out.print(lletraLlegida);
        }
        System.out.println();

        //Fase 2
        ArrayList<Character> llistaNom = new ArrayList<Character>();
        for (char lletraNom : arrayNom) {
            llistaNom.add(lletraNom);
        }
        //Busquem si hi ha vocals, consonants
        List<Character> llistaVocals = Arrays.asList('A','E','I','O','U');
        List<Integer> llistaNumeros = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (char lletraBuscada : arrayNom) {
            if (llistaVocals.contains(lletraBuscada)) {
                System.out.println("VOCAL");
            } else {
                System.out.println("CONSONTANT");
            }
        }
            //Busquem si hi ha números. Opció 1
        for (int numeroBuscat : llistaNumeros) {
            if (llistaNom.contains(numeroBuscat)) {
                System.out.println("Els noms de persones no contenen números!");
            }
        }
        //Opcio 2 amb el mètode .get()
        List <Integer> ArrayListNom = new ArrayList<>();
        for (int numeroBuscat2 : ArrayListNom) {
            if (Character.isDigit(ArrayListNom.get(numeroBuscat2))){
                System.out.println("Els noms de persones no contenen números!");
            }
        }
        //Fase 3
        //contem les lletres del nom (llistaNom)
        HashMap<String, Integer> numeroDeLletres = new HashMap<String, Integer>();
        char lletra;
        int comptador = 0;

        for (int i = 0; i < arrayNom.length; i++) {
            lletra = arrayNom[i];
            for (int j = 0; j < arrayNom.length; j++) {
                if (arrayNom[j] == lletra) {
                    comptador++;
                }
            }
            System.out.println(arrayNom[i] + " " + comptador);
            numeroDeLletres.put("arrayNom[i]", comptador);
            comptador = 0;
        }

        System.out.println();

        //Fase4
        ArrayList<Character> arrayListCognom = new ArrayList<>();
        arrayListCognom.add('G');
        arrayListCognom.add('O');
        arrayListCognom.add('N');
        arrayListCognom.add('Z');
        arrayListCognom.add('A');
        arrayListCognom.add('L');
        arrayListCognom.add('E');
        arrayListCognom.add('Z');

        ArrayList<Character> fullName = new ArrayList<>();

        fullName.addAll(llistaNom);
        fullName.add(espai());
        fullName.addAll(arrayListCognom);
        System.out.println(fullName);
    }
    public static Character espai(){
        char espai = ' ';
        return espai;
    }
}


