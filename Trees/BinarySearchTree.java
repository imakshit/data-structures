import java.util.*;
public class BinarySearchTree{
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(){

        }
        public Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int[] arr , int si , int ei){
        Node node = new Node();
        int mid = (ei+si)/2;
        node.data = arr[mid-1];

        node.left = construct(arr, si, mid-1);
        node.right = construct(arr, mid+1, ei);

        return node;
    }

    public static int min(Node node){
        if(node.left==null){
            return node.data;
        }
        return min(node.left);
    }

    public static int max(Node node){
        if(node.right==null){
            return node.data;
        }
        return max(node.left);
    }

    public static boolean find(Node node , int data){
        if(node==null){
            return false;
        }if(node.data==data){
            return true;
        }if(node.data>data){
            return find(node.left , data);
        }if(node.data<data){
            return find(node.right ,data);
        }
        return false;
    }


    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left != null? node.left.data+" -> " : ". -> ";
        str += node.data;
        str += node.right != null? " <- "+node.right.data : " <- .";
        System.out.println(str);
        
        display(node.left);
        display(node.right);

    }

    public static void main(String[] args){
        int[] arr = {12,25,37,50,62,75,87};
        Node root = construct(arr, 0, arr.length-1);
        display(root);
    }
}