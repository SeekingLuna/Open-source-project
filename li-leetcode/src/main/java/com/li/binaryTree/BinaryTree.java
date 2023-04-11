package com.li.binaryTree;

public class BinaryTree {
    private TreeNode rootNode;

    private void insert(int val) {
        TreeNode treeNode = new TreeNode(val);
        insert(val, rootNode);


    }

    private TreeNode insert(int val, TreeNode node) {
        //找到空结点就插入
        if (node == null) {


            return new TreeNode(val);
        }//当前递归到的结点不是空结点，且val<node.val,往左继续递归
        else if (val < node.val) {

            node.leftNode = insert(val, node.leftNode);
            //当前递归到的结点不是空结点，且val>node.val,往右继续递归

        } else if (val > node.val) {


            node.rightNode = insert(val, node.rightNode);

        }

        return null;
    }




}
