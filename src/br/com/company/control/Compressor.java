package br.com.company.control;

import br.com.company.model.HeapCode;
import br.com.company.model.TreeNode;
import br.com.company.model.UsableBitSet;

import java.io.*;
import java.util.BitSet;
import java.util.HashMap;

public class Compressor {

    private String fileLocation;
    private String fileTarget;
    private String fileDict;
    private String file;
    private HeapCode heap;
    private UsableBitSet bitFile;
    private HashMap<Character, Integer> frequence;
    private HashMap<Character, UsableBitSet> coding;
    private File destiny;
    private File dict;

    public Compressor(String fileLocation, String fileTarget, String fileDict) {
        this.fileLocation = fileLocation;
        this.fileTarget = fileTarget;
        this.fileDict = fileDict;
        frequence = new HashMap<>();
        coding = new HashMap<>();
        heap = new HeapCode();
        bitFile = new UsableBitSet();
        destiny = new File(fileTarget);
        dict = new File(fileDict);
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
        UsableBitSet bit = new UsableBitSet();
        generateCode(0, heap.peek(), bit);
    }

    private void generateCode(int numero, TreeNode peek, UsableBitSet bit) {
        if(peek.getLetter() == 0){
            UsableBitSet bitLeft = new UsableBitSet(bit);
            bitLeft.set(numero, false);
            UsableBitSet bitRight = new UsableBitSet(bit);
            bitRight.set(numero,true);
            generateCode(numero+1,peek.getLeft(),bitLeft);
            generateCode(numero+1,peek.getRight(), bitRight);
        } else {
            coding.put((char)peek.getLetter(), bit);
        }
    }

    public void createBitArray(){
        for (int i = 0; i < file.length(); i++){
            for (int k = 0; k < coding.get(file.charAt(i)).getTrueSize() ; k++) {
                bitFile.set(bitFile.getTrueSize(),coding.get(file.charAt(i)).get(k));
            }
        }
    }

    public void  desencripty (){
        UsableBitSet bit = new UsableBitSet();
        HashMap<UsableBitSet, Character> bitmap = new HashMap<>();
        for (var value: coding.keySet()){
            bitmap.put(coding.get(value), value);
        }

        for (int i = 0; i <bitFile.getTrueSize(); i++){
            bit.set(bit.getTrueSize(), bitFile.get(i));
            for (var value: bitmap.keySet()) {
                if (bit.equals(value)){
                    bit.clear();
                }
            }
        }
    }

    public void writing(){
        boolean bean;
        try {
            bean = destiny.createNewFile();
            if (!bean){
                System.out.println("File already present at the specified location.");
                return;
            }
        }catch (IOException e) {
            System.out.println("Houve um erro inesperado.");
            e.printStackTrace();
        }

        try {
            bean = dict.createNewFile();
            if (!bean){
                System.out.println("File already present at the specified location.");
                return;
            }
        }catch (IOException e) {
            System.out.println("Houve um erro inesperado.");
            e.printStackTrace();
        }

        FileOutputStream file = null;
        try {
            file = new FileOutputStream(destiny, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            file.write(bitFile.toByteArray());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file = new FileOutputStream(dict, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            for (var value: coding.keySet()) {
                file.write(value);
                for (var varr: coding.get(value).toByteArray()){
                    file.write((int)varr);
                }
                file.write(300);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public HashMap<Character, UsableBitSet> getCoding() {
        return coding;
    }

    public BitSet getBitFile() {
        return bitFile;
    }

    public byte[] toByteArray(){
        return bitFile.toByteArray();
    }

    public String stringStrange (){
        return bitFile.toString();
    }
}