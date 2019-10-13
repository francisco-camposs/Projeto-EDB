package br.com.company.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Extractor {

    private String fileLocation;
    private String fileTarget;
    private String fileDict;
    private String file;
    private HashMap<Character, Integer> frequence;
    private HashMap<String, String> coding;
    private File origin;
    private File destiny;
    private File dict;

    public String getFile() {
        return file;
    }

    public Extractor(String fileLocation, String fileTarget, String fileDict) {
        this.fileLocation = fileLocation;
        this.fileTarget = fileTarget;
        this.fileDict = fileDict;
        frequence = new HashMap<>();
        coding = new HashMap<>();
    }

    public void reading() throws IOException {
        ReadingFile arch = new ReadingFile(fileLocation);
        this.file = arch.reading();
    };

    public void generateFrequency(){
        for (Character value: file.toCharArray()) {
            if (frequence.containsKey(value)){
                frequence.put(value, frequence.get(value)+1);
            } else {
                frequence.put(value,1);
            }
        }
    };


    public void generateTree(){

    };

    public void generateCode(){

    };


    public void writing(){


    };

    public HashMap<Character, Integer> getFrequence() {
        return frequence;
    }
}
