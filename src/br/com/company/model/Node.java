package br.com.company.model;

public class Node {
    private int letter;
    private int frequency;
    private Node left;
    private Node right;

    public Node(int character) {
        letter = character;
        frequency += 1;
        left = null;
        right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
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


    public Node search(char character, int frequency) {

    }
}
