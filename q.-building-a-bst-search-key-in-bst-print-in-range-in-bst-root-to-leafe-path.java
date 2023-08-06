import java.util.*;

public class Main{
    static class Node{
        
        int data;
        Node left;
        Node right;
        
        Node(int data){
            
            this.data = data;
        }
        
    }
    
    public static Node insert(Node root, int val) {
        if(root == null){
            root = new Node(val);
            return root;
        }
        
        if(root.data>val){
            //left subtree
           root.left = insert(root.left, val );
        }else{
            
            //right subtree
            root.right = insert(root.right, val);
        }
        
        return root;
    }
    
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    //Search in BST  
    public static boolean search(Node root, int key){
        if(root== null){
            return false;
        }
        
        if(root.data == key){
            return true;
        }
        
        if(root.data>key){
           return search(root.left, key);
        }
        
        else{
            
            return search(root.right, key);
        }
        
        
        
    }
    
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return ;
        }
        
        
        
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.println(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        
        else if(root.data < k1 ){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
        
    }
    
    public static void printPath( ArrayList<Integer>path){
        for(int i=0; i<path.size(); i++){
            System.out.println(path.get(i)+" --> ");
        }
        System.out.println("Null");
    }
    
    public static void printRoot2leaf(Node root, ArrayList<Integer>path){
       if(root == null){
           return ;
       }
       
        if(root.left == null && root.right == null);
        path.add(root.data);
        printRoot2leaf(root.left, path);
        printRoot2leaf(root.right, path);
        path.remove(path.size()-1);
        
        
        
        
    }
    
    public static void main(String[]args){
        int values []={5, 1, 3, 4, 2, 7};
        Node root = null;
        
        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        
        inorder(root);
        System.out.println();
        
        
        // Search key in BST
        if(search(root, 1)){
            System.out.println("Found");
        }else{
           System.out.println("Not Found");
           
        }
        
        // print in range 
        printInRange(root, 5, 12);
        
        // printRoot2leaf
        printRoot2leaf(root, new ArrayList<>());
        
    }
}