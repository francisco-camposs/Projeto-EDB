package br.com.company.control;

import br.com.company.model.HeapCode;
import br.com.company.model.TreeNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Extractor {

    private String fileLocation;
    private String fileTarget;
    private String fileDict;
    private String file;
    private HashMap<Character, Integer> frequence;
    private HeapCode heap;

    public HashMap<Character, String> getCoding() {
        return coding;
    }

    private HashMap<Character, String> coding;
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
        coding = new HashMap<Character, String>();
        heap = new HeapCode();
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
        for (char value: frequence.keySet()) {
            heap.add(frequence.get(value), (int)value);
        }
    };

    public HeapCode getHeap() {
        return heap;
    }

    public void generateTree(){
        if (heap.getSize() > 1){
            TreeNode aux1 = new TreeNode(0,0);
            aux1.setLeft(heap.peek());
            aux1.update(heap.peek().getFrequency());
            heap.remove();
            aux1.setRight(heap.peek());
            aux1.update(heap.peek().getFrequency());
            heap.remove();
            heap.add(aux1);
            generateTree();
        }
    }

    private void generateTree(TreeNode node) {
        if (heap.getSize() > 1){

        }
    }

    ;

    public void generateCode(){
        String bit = new String();
        generateCode(heap.peek(),bit);
    }

    private void generateCode(TreeNode peek, String bit) {
        if(peek.getLetter() == 0){
            String bitLeft = bit+"0";
            String bitRight = bit+"1";
            generateCode(peek.getLeft(),bitLeft);
            generateCode(peek.getRight(), bitRight);
        } else {
            coding.put((char)peek.getLetter(), bit);
        }

    }


    public void writing(){

    };

    public HashMap<Character, Integer> getFrequence() {
        return frequence;
    }
}
