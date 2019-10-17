package br.com.company.control;

import br.com.company.model.HeapCode;
import br.com.company.model.TreeNode;

import java.io.File;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;

public class Extractor {

    private String fileLocation;
    private String fileTarget;
    private String fileDict;
    private String file;
    private HashMap<Character, Integer> frequence;
    private HeapCode heap;

    public HashMap<Character, BitSet> getCoding() {
        return coding;
    }

    private HashMap<Character, BitSet> coding;
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
        while (heap.getSize() > 1){
            TreeNode aux1 = new TreeNode(0,0);
            aux1.setLeft(heap.peek());
            aux1.update(heap.peek().getFrequency());
            heap.remove();
            aux1.setRight(heap.peek());
            aux1.update(heap.peek().getFrequency());
            heap.remove();
            heap.add(aux1);
        }
    };

    public void generateCode(){
        BitSet bit = new BitSet();
        generateCode(heap.peek(),bit);
    }

    private void generateCode(TreeNode peek, BitSet bit) {
        if(peek.getLetter() == 0){
            BitSet bitLeft = (BitSet) bit.clone();
            bitLeft.set(bitLeft.size(), false);
            BitSet bitRight = (BitSet) bit.clone();
            bitRight.set(bitLeft.size(), true);
            generateCode(peek.getLeft(),bitLeft);
            generateCode(peek.getRight(), bitRight);
        }
        coding.put((char)peek.getLetter(), bit);
    }


    public void writing(){

    };

    public HashMap<Character, Integer> getFrequence() {
        return frequence;
    }
}
