package br.com.company.model;

public class Node {
    protected char letter;
    protected int frequency;


    public Node(char character, Integer frequency) {
        letter = character;
        this.frequency = frequency;

    }

    public char getLetter() {
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
