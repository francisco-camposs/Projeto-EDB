package br.com.company.model;

public class NodeChar {
    private char Character;
    private int frequency;
    private NodeChar left;
    private NodeChar right;

    public NodeChar(char character) {
        Character = character;
        frequency += 1;
        left = null;
        right = null;
    }

    public NodeChar getLeft() {
        return left;
    }

    public void setLeft(NodeChar left) {
        this.left = left;
    }

    public NodeChar getRight() {
        return right;
    }

    public void setRight(NodeChar right) {
        this.right = right;
    }

    public char getCharacter() {
        return Character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void update(){
        frequency++;
    }


}
