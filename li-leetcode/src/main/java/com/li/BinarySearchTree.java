package com.li;

 class Node {
     int key;
     Node left, right;

     public Node(int item) {
         key = item;
         left = right = null;
     }
 }

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(366);
        bst.insert(205);
        bst.insert(450);
        bst.insert(720);
        bst.insert(630);
        bst.insert(8210);

        bst.inOrderTraversal();
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.key + " ");
            inOrderTraversalRec(root.right);
        }
    }


}


//package com.li;
//
//import java.util.HashMap;
//import java.util.Objects;
//
//public class BinarySearchTree {
//    public static void main(String[] args) {
//        //根结点
//        Node<Integer> node1 = new Node<>();
//        node1.setData(3);
//
//        Node<Integer> node2 = new Node<Integer>();
//
//
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("ii", 0);
//        System.out.println(node1);
//    }
//
//
//}
//
///**
// * 定义树的结点类
// *
// * @param <E>
// */
//class Node<E> {
//
//
//    //左子节点
//    private Node<E> leftSon;
//
//    //右子节点
//
//    private Node<E> rightSon;
//
//    private E data;
//
//    public void put(Node<E> node) {
//        //新子节点hashcode
//        int i = node.hashCode();
//        //自身hashcodde
//        int i1 = this.hashCode();
//
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "leftSon=" + leftSon +
//                ", rightSon=" + rightSon +
//                ", data=" + data +
//                '}';
//    }
//
//    public Node<E> getLeftSon() {
//        return leftSon;
//    }
//
//
//    public Node<E> getRightSon() {
//        return rightSon;
//    }
//
//    public void setRightSon(Node<E> rightSon) {
//        this.rightSon = rightSon;
//    }
//
//    public E getData() {
//        return data;
//    }
//
//    public void setData(E data) {
//        this.data = data;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Node<?> node = (Node<?>) o;
//        return Objects.equals(leftSon, node.leftSon) && Objects.equals(rightSon, node.rightSon) && Objects.equals(data, node.data);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(leftSon, rightSon, data);
//    }
//}