/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edd_ordem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Arrays
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yasmi
 */
public class EDD_ORDEM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //    criar_arquivo(1000);
        criar_arquivo(5000);
        //criar_arquivo(10000);
        //criar_arquivo(30000);

        int vet[] = importar_arquivo(5000);
        vet = selection_sort(vet, vet.length);
        criar_arquivo_ordenado(vet, vet.length);

    }

    //criar um arquivo com n valores aleatorios de 0 ate 99
    public static void criar_arquivo(int n) throws IOException {
        Random rand = new Random();
        String arqEscrita = n + ".txt";

        System.out.println("Escrevendo no arquivo " + arqEscrita);

        FileWriter writer = new FileWriter(arqEscrita);

        BufferedWriter buffWrite = new BufferedWriter(writer);
        for (int i = 0; i < n + 1; i++) {
            int num = rand.nextInt(1000);
            buffWrite.append(num + "\n");
        }

        buffWrite.close();

    }

    public static void criar_arquivo_ordenado(int[] vet, int n) throws IOException {
        String arqEscrita = n + "_ord.txt";
        System.out.println("Escrevendo no arquivo " + arqEscrita);
        FileWriter writer = new FileWriter(arqEscrita);
        BufferedWriter buffWrite = new BufferedWriter(writer);
        for (int i = 0; i < n; i++) {
            int num = vet[i];
            buffWrite.append(num + "\n");
        }
        buffWrite.close();
    }

    public static int[] importar_arquivo(int n) throws FileNotFoundException {
        String arqEscrita = n + ".txt";
        File file = new File(arqEscrita);
        Scanner s = new Scanner(file);
        int[] vetor = new int[n];

        System.out.println("importando o arquivo " + arqEscrita);

        for (int i = 0; i < n; i++) {
            vetor[i] = s.nextInt();
        }
        s.close();
        return vetor;
    }

    static int[] selection_sort(int[] vet, int N) {
        for (int fixo = 0; fixo < (N - 1); fixo++) {
            int menor = fixo;
            for (int i = menor + 1; i < N; i++) {
                if (vet[i] < vet[menor]) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                int t = vet[fixo];
                vet[fixo] = vet[menor];
                vet[menor] = t;
            }
        }
        return vet;
    }

}
