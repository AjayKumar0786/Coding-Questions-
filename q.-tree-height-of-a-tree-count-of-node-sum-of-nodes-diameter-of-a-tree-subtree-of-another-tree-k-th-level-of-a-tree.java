import java.util.*;

public class Main{
    
     static class Node{
            int data;
            Node left, right;
        
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
    
        }
            }
            
    //code for calculating height 
            
            public static int height(Node root){
                if(root == null){
                    return 0;
                }
                
                int lh = height(root.left); 
                int rh = height(root.right);
                return Math.max(lh, rh)+1;
            }
            
            
    // Calculating total nodes 
            
    public static int count(Node root){
        if(root == null){
            return 0;
            
        }
        
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount+1;
    }    
    
    
    
    // Calculating sum of Nodes
    
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
        
    }   
       
       
    // Calculating diameter of tree  Approach - 1    Tc=0(n^2)
    
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        
       int  leftDiam = diameter(root.left);
       int  leftHt = height(root.left);
       int rightDiam = diameter(root.right);
       int rightHt = height(root.right);
       
       int selfDiam = leftHt + rightHt +1;
       
       return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        
    }
    
    // Calculating diameter of tree  Approach - 2     Tc=0(n)
    
   /* static class Info{
        int diam;
        int Ht;
        
        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht ;
        }
        
    }
    public static Info diameter(Node root){
    if(root == null){
        return new Info (0, 0);
        
    }
    
    Info leftInfo = diameter(root.left);
    Info rightInfo = diameter(root.right);
    
    int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo +1);
    int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;
    return new Info(diam, ht);
    
        
    } 
            
    */
    
    //Subtree of another tree question
    
    public static boolean isIdentical(Node node, Node subRoot){
        
        if(node == null && subRoot == null){
            return true;
            
        }else if(node == null || subRoot == null || node.data == subRoot.data){
            return false;
        }
        
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        
        if(!isIdentical(node.right, subRoot.right)){
            return false;
            
        }
        
        return true;
    }
    
    
    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
         
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
    
    
    
    // K th lenel of tree
    public static void KLevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        
        if(level== k){
            System.out.print(root.data+" ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }
        
    
    public static void main(String[]args){
        
     /*   
           tree
           
             1
           /  \
          2    3
         / \  / \
        4  5 6   7
        
    */
        
        
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7); 
       
       /* 
       
         sub tree
          
             2
            / \
           4   5
       
       */
       
       Node subRoot = new Node(2);
       subRoot.left = new Node(4);
       subRoot.right = new Node(5);
       
       
       System.out.println(height(root));
        
        System.out.println(count(root));
        
        System.out.println(sum(root));
        
        System.out.println(diameter(root));
         
       //System.out.println(diameter(root).diam);
       
       System.out.println(isSubtree(root, subRoot));
       
       int  k = 2;
       KLevel(root, 1, k);
    }
}