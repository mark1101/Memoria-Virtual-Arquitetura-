/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author mark_
 */
public class DadosRam {

    ArrayList<String> letras = new ArrayList<String>();

    public static ArrayList<String> carregaRamc = new ArrayList<String>();
    public static ArrayList<String> maisUsados = new ArrayList<String>();
    public static ArrayList<Integer> Tam = new ArrayList<Integer>();

    String[] conteudo = new String[10];
    int[] Usado = new int[10];

    int cont = 0;
    int contador = 0;

    public DadosRam() {

        letras.add("Imagem 2");
        letras.add("Programa 2");
        letras.add("Arquivo de texto");
        letras.add("compact");
        letras.add("imagem");
        letras.add("Jogo 1");
        letras.add("Programa 7");
        letras.add("Musica");
        letras.add("Arquivo de texto");
        letras.add("Programa 10");

        for (int i = 0; i < conteudo.length; i++) {
            conteudo[i] = letras.get(i);
        }
    }

    int i;

    public void mostraRam() {
        System.out.println("MEMORIA RAM ");
        for (int i = 0; i < carregaRamc.size(); i++) {

            System.out.println(carregaRamc.get(i));
        }
        System.out.println("");
    }

    public void carregaRam(String enderecoF) {
        carregaRamc.add(enderecoF + "|" + conteudo[cont]);
        cont++;
    }

    Cache cache = new Cache();

    public void jogaCache() {
        String penultimo = "";
        String ultimo = "";
        for (int i = 0; i < carregaRamc.size(); i++) {
            penultimo = carregaRamc.get(i);
            i++;
            try {
                ultimo = carregaRamc.get(i);
            } catch(IndexOutOfBoundsException ex){
                
            }
        }
        cache.guardaCache(penultimo, ultimo);
        cache.mostraCache();
    }
}
