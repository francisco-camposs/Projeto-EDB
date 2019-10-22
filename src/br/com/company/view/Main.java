package br.com.company.view;

import br.com.company.control.Compressor;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
	// write your destinycode here

        if (args.length == 4){
            if (args[0].equals("compress")){
                Compressor compressor = new Compressor(args[1], args[2], args[3]);
                try {
                    compressor.reading();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                compressor.generateFrequency();
                compressor.generateTree();
                compressor.generateCode();
                compressor.createBitArray();
                compressor.writing();
            } else if (args[0].equals("compressort")){

            } else {
                System.out.println("Operação inválida.");
                return;
            }
        }
    }
}
