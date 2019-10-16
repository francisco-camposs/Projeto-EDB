package br.com.company.model;

import java.util.Arrays;

public class HeapCode {

    private Node[] node;
    private int size;
    private int maxSize;

    public HeapCode() {
       node = new Node[10];
       size = 0;
       maxSize = 10;
    }

    public HeapCode(int maxSize) {
        node = new Node[maxSize];
        size = 0;
        this.maxSize = maxSize;
    }

    public void add(Integer frequency, Character character){
        add(new Node(character, frequency));
    }

    private void add(Node node) {
        if (isFull()){
            resize();
        }
        this.node[size] = node;
        heapIfUp(size);
        size += 1;
    }

    private void heapIfUp(int index) {
        if (!(hasParent(index))){
            return;
        }
        int parentIndex = getParentIndex(index);

        Node here = node[index];
        Node father = node[parentIndex];

        if (here.getFrequency() > father.getFrequency()){
            node[index] = father;
            node[parentIndex] = here;
            heapIfUp(parentIndex);
        }
    }

    public boolean hasParent(int index){
        return getParentIndex(index) >= 0 && getParentIndex(index) <size;
    }

    private int getParentIndex(int index) {
        return Math.floorDiv(index-1,2);
    }

    private void resize() {
        this.node = Arrays.copyOf(this.node, getSize()*2);
        maxSize *= 2;
    }

    private boolean isFull() {
        return getSize() == getMaxSize();
    }

    public Node[] getNode() {
        return node;
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
