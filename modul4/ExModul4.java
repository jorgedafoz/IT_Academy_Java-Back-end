package com.company.modul4;

import java.util.*;
import java.io.*;

public class ExModul4 {
    public static void main(String[] args) {
        //Fase 1
        int billete5   = 5;
        int billete10  = 10;
        int billete20  = 20;
        int billete50  = 50;
        int billete100 = 100;
        int billete200 = 200;
        int billete500 = 500;

        String[] menu = new String[5];
        int[] preus = new int[5];

        //Fase 2
        // Omplim els arrays per consola demanant-li les dades al lector i
        // després guardarem les dades dels arrays a un map
        HashMap<String, Integer> menuValorat = new HashMap<String, Integer>();
        Scanner usuari = new Scanner(System.in);
        int i = 0;
        do {
            System.out.println("Introdueix un plat del menú");
            try {
                String plat = usuari.nextLine();
                menu[i] = plat;
            } catch (InputMismatchException e) {
                System.out.println("Les dades instroduides no són correctes");
                usuari.next();
            }
            i++;
        } while (i < menu.length);

        for (i = 0; i < menu.length; i++) {
            System.out.println("Introdueix el preu del plat " + menu[i]);
            //Comprovem que la dada introduida és correcte
            //Opció mètode .hasNext()
            boolean dadaCorrecte = false;
            /*while (!dadaCorrecte) {
                if (usuari.hasNextInt()) {
                    int preu = usuari.nextInt();
                    if (preu > 0) {
                        preus[i] = preu;
                        dadaCorrecte = true;
                    } else {
                        System.out.println("El preu no pot ser un número negatiu. Introdueix-lo de nou.");
                    }
                } else {
                    System.out.println("La dada introduida no és correcte. Introdueix de nou el preu del plat " + menu[i]);
                    usuari.next();
                }
            }*/

            //Opció try/catch
            while (!dadaCorrecte) {
                try {
                    int preu = usuari.nextInt();
                    if (preu > 0) {
                        preus[i] = preu;
                        dadaCorrecte = true;
                        usuari.nextLine();
                    } else {
                        System.out.println("El preu no pot ser un número negatiu. Introdueix-lo de nou.");
                    }
                } catch(InputMismatchException e) {
                    System.out.println("La dada introduida no és correcte. Introdueix-la de nou.");
                    usuari.nextLine();
                }
            }
            //Guardem les dades dels arrays a un map
            menuValorat.put(menu[i], preus[i]);
        }

        //Fase 3
        //Mostrem el menú valorat
        Iterator iterador= menuValorat.entrySet().iterator();

        while (iterador.hasNext()) {
            Map.Entry menuImpres = (Map.Entry)iterador.next();
            System.out.println(menuImpres.getKey() + " " + menuImpres.getValue());
        }
        //demanem què vol menjar
        ArrayList<String> comandaTotalFeta = new ArrayList<String>();
        boolean comandaAcabada = false;

        do {
            System.out.println("digui quin plat del menú vol menjar");
            Scanner comanda = new Scanner(System.in);
            String platDemanat = comanda.nextLine();
            comandaTotalFeta.add(platDemanat);
            //demanem si vol menjar més o ja ha acabat
            boolean noDemanarMes = false;
            do {
                System.out.println("Vol demanar res més? Si vol més escrigui 1, si no vol més escrigui 0");
                Scanner opcio = new Scanner(System.in);
                try {
                    int resposta = opcio.nextInt();
                    if (resposta == 1) {
                        comandaAcabada = false;
                        noDemanarMes = true;
                    } else if (resposta == 0) {
                        comandaAcabada = true;
                        noDemanarMes = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Les dades instroduides no són correctes. Introdueixi un 1 o un 0.");
                }
                opcio.nextLine();
            } while (!noDemanarMes);
        } while (!comandaAcabada);

        System.out.println(comandaTotalFeta);

        //Fase 4
        //Mirem si el plat demanat està a la llista i sumem l'import. Si no està avisem al client
        int costTotal = 0;
        for (String plat : comandaTotalFeta) {
            if (menuValorat.containsKey(plat)) {
                costTotal =  costTotal + menuValorat.get(plat);
            } else {
                System.out.println("Ho sentim però no tenim " + plat + " no està al menú.");
            }
        }
        System.out.println("El total costarà " + costTotal);
    }
}