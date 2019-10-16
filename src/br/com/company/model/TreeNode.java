package br.com.company.model;

public class TreeNode extends  Node{
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Character character, int frequency, TreeNode left, TreeNode right) {
        super(character, frequency);
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
