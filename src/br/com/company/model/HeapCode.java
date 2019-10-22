package br.com.company.model;

import java.util.Arrays;

public class HeapCode {

    private TreeNode[] node;
    private int size;
    private int maxSize;

    public HeapCode() {
       node = new TreeNode[10];
       size = 0;
       maxSize = 10;
    }

    public HeapCode(int maxSize) {
        node = new TreeNode[maxSize];
        size = 0;
        this.maxSize = maxSize;
    }

    public void add(Integer frequency, Integer character){
        add(new TreeNode(character, frequency));
    }

    public void add(TreeNode node) {
        if (isFull()){
            resize();
        }
        this.node[size] = node;
        heapifyUp(size);
        size += 1;
    }

    private void heapifyUp(int index) {
        if (!(hasParent(index))){
            return;
        }
        int parentIndex = getParentIndex(index);

        TreeNode here = node[index];
        TreeNode father = node[parentIndex];

        if (here.getFrequency() < father.getFrequency()){
            node[index] = father;
            node[parentIndex] = here;
            heapifyUp(parentIndex);
        }
    }

    public void remove(){
        node[0] = node[getSize()-1];
        node[getSize() -1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int index){
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;

        if (leftChild < getSize()){
            childIndex = leftChild;
        }

        if (childIndex < 0){
            return;
        }

        if (rightChild < getSize()){
            if (node[rightChild].getFrequency() < node[leftChild].getFrequency()){
                childIndex = rightChild;
            }
        }


        if (node[index].getFrequency() > node[childIndex].getFrequency()){
            TreeNode tmp = node[index];
            node[index] = node[childIndex];
            node[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }

    public TreeNode peek(){
        return node[0];
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

    public TreeNode[] getTreeNode() {
        return node;
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
