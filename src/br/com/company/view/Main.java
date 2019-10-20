package br.com.company.view;

import br.com.company.control.Extractor;
import br.com.company.model.BinaryTree;
import br.com.company.model.HeapCode;
import br.com.company.model.Node;

import java.io.IOException;
import java.util.BitSet;

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
        extrac.generateFrequency();
        extrac.generateTree();
        extrac.generateCode();
        extrac.createBitArray();
        for (byte value: extrac.getBitFile().toByteArray()){
            System.out.println(value);
        };
    }
}
