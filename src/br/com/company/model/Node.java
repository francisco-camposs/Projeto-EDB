package br.com.company.model;

public class Node {
    protected int letter;
    protected int frequency;


    public Node(int character, Integer frequency) {
        letter = character;
        this.frequency = frequency;

    }

    public int getLetter() {
        return letter;
    }

    public int getFrequency() {
        return frequency;
    }

    public void update(){
        frequency++;
    }

    public boolean biggerOrEqualThen(Node node){
        return this.frequency >=  node.frequency;
    }
}
