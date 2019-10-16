package br.com.company.view;

import br.com.company.control.Extractor;
import br.com.company.model.BinaryTree;
import br.com.company.model.Node;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Extractor extrac = new Extractor("/home/francisco/Objetivos.txt", "Math.edz", "Math.edx");
        try {
            extrac.reading();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(extrac.getFile());
        System.out.println("Aqui oh porra: ");
        extrac.generateFrequency();

        int k = 1;
        for (int i = 0; i < extrac.getHeap().getSize(); i++){
            if (i == k){
                System.out.println("\n");
                k *= 2;
            }
            System.out.print("("+extrac.getHeap().getNode()[i].getLetter()+") = "+extrac.getHeap().getNode()[i].getFrequency()+" ");
        }
    }
}
