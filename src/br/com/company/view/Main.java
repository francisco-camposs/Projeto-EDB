package br.com.company.view;

import br.com.company.control.Extractor;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
	// write your destinycode here
        Extractor extrac = new Extractor("/home/francisco/Documentos/Projeto-EDB/testes/teste7.txt", "Math.edz", "Math.edx");
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
//        System.out.println(extrac.getBitFile());
        extrac.desencripty();
        for (var value: extrac.toByteArray()){
            System.out.println(value+" ");
        }
        extrac.writing();

        System.out.println(extrac.stringStrange());
        System.out.println();

    }
}
