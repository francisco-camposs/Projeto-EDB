package br.com.company.view;

import br.com.company.control.Extractor;
import br.com.company.model.BinaryTree;

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
        extrac.generateFrequency();

    }
}
