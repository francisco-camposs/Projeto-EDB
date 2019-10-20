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
    private HeapCode heap;
    private BitSet bitFile;
    private HashMap<Character, Integer> frequence;
    private HashMap<Character, BitSet> coding;
    private File origin;
    private File destiny;
    private File dict;

    public Extractor(String fileLocation, String fileTarget, String fileDict) {
        this.fileLocation = fileLocation;
        this.fileTarget = fileTarget;
        this.fileDict = fileDict;
        frequence = new HashMap<>();
        coding = new HashMap<>();
        heap = new HeapCode();
        bitFile = new BitSet();
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

    public void generateCode(){
        BitSet bit = new BitSet();
        generateCode(0, heap.peek(), bit);
    }

    private void generateCode(int numero, TreeNode peek, BitSet bit) {
        if(peek.getLetter() == 0){
            BitSet bitLeft = bit.get(0,bit.length());
            bitLeft.set(numero, false);
            BitSet bitRight = bit.get(0,bit.length());
            bitRight.set(numero,true);
            generateCode(numero+1,peek.getLeft(),bitLeft);
            generateCode(numero+1,peek.getRight(), bitRight);
        } else {
            coding.put((char)peek.getLetter(), bit);
        }
    }

    public void createBitArray(){
        for (int i = 0; i < file.length(); i++){
            for (int k = 0; k < coding.get(file.charAt(i)).length(); k++){
                bitFile.set(bitFile.length(), coding.get(file.charAt(i)).get(k));
            }
        }
    }


    public void writing(){

    };

    public HeapCode getHeap() {
        return heap;
    }

    public String getFile() {
        return file;
    }

    public HashMap<Character, Integer> getFrequence() {
        return frequence;
    }

    public HashMap<Character, BitSet> getCoding() {
        return coding;
    }

    public BitSet getBitFile() {
        return bitFile;
    }
}
