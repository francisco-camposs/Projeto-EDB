package br.com.company.control;

import br.com.company.model.HeapCode;
import br.com.company.model.UsableBitSet;

import java.io.File;
import java.util.HashMap;

public class Extract {

    private String fileLocation;
    private String fileTarget;
    private String fileDict;
    private String file;
    private HeapCode heap;
    private UsableBitSet bitFile;
    private HashMap<Character, UsableBitSet> coding;
    private File destiny;
    private File dict;

    public Extract(String fileLocation, String fileTarget, String fileDict) {
        this.fileLocation = fileLocation;
        this.fileTarget = fileTarget;
        this.fileDict = fileDict;
        coding = new HashMap<>();
        heap = new HeapCode();
        bitFile = new UsableBitSet();
        destiny = new File(fileTarget);
        dict = new File(fileDict);
    }

    public void readContentFile(){}

    public void readDictFile(){}

    public void createDict(){}

    public void generateContent(){}

    public void writingFile(){}

}
