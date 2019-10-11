package br.com.company.control;

import java.io.File;
import java.util.HashMap;

public class Extractor {

    private String fileLocation;
    private String fileTarget;
    private String fileDict;
    private String file;
    private HashMap<Integer, String> frequence;
    private HashMap<String, String> coding;
    private File origin;
    private File destiny;
    private File dict;

    public Extractor(String fileLocation, String fileTarget, String fileDict) {
        this.fileLocation = fileLocation;
        this.fileTarget = fileTarget;
        this.fileDict = fileDict;
        frequence = new HashMap<>();
        coding = new HashMap<>();
    }

    public void reading(){

    };

    public void generateFrequency(){

    };

    public void generateTree(){

    };

    public void generateCode(){

    };


    public void writing(){


    };
}
