package br.com.company.model;

public class Node {
    private int letter;
    private int frequency;


    public Node(int character) {
        letter = character;
        frequency = 1;

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
}
