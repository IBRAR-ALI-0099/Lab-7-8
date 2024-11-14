/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lab_practicle.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Ibrar Ali
 */
public class Binary_TREE {
    
    BTNode root;

    public void insert(int data){
        root = insertRec(root,data);
    }
    public BTNode insertRec(BTNode root,int data){
        if(root == null){
            root = new BTNode(data);
        }
        else if(data<root.data){
            root.left = insertRec(root.left,data);
        }else{
            root.right = insertRec(root.right,data);
        }
        return root;
    }

    public boolean isEmpty(){
        return root== null;
    }
     public void count(){
         if(root == null){
             System.out.println(" it's empty "); 
             return;
         }
         
         int count = 0;
         Queue<BTNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             BTNode current = queue.poll();
             ++count;
             if(current.left != null){
                 queue.add(current.left);
             }
             if(current.right != null){
                 queue.add(current.right);
             }
         }
         System.out.print("\n Total nodes: ");
         System.out.print(count);
         //return count; 
     }

    //Inorder 
    public void inorder(){
        inorderRec(root);
    }
    public void inorderRec(BTNode root){
    if(root != null){
        inorderRec(root.left);
        System.out.print(root.data+" ");
        inorderRec(root.right);
    }    
    }

   public void preorder(){
        preorderRec(root);
    }
    public void preorderRec(BTNode root){
        if(root != null){
            System.out.print(root.data+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }


    public void postorder(){
        postorderRec(root);
    }
    public void postorderRec(BTNode root){
        if(root!= null){
            preorderRec(root.left);
            preorderRec(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void levelorder(){
     Queue<BTNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             BTNode current = queue.poll();
                System.out.print(current.data+" ");
             if(current.left != null){
                 queue.add(current.left);
             }
             if(current.right != null){
                 queue.add(current.right);
             }
         }
    }
   
    
    public static void main(String []args){
        Binary_TREE obj = new Binary_TREE();
        
        obj.insert(10);
        obj.count();
        obj.insert(20);
        obj.count();
        obj.insert(30);
        obj.count();
        obj.insert(40);
        obj.count();
        obj.insert(50);
        obj.count();
        obj.insert(60);
        obj.count();
        obj.insert(70);
        obj.count();
        obj.insert(80);
        obj.count();
        obj.insert(90);
        obj.count();
        obj.insert(100);
        obj.count();
        
        System.out.print("\n In-order traversal: ");
        obj.inorder();
        
        System.out.print("\n Pre-order traversal:");
        obj.preorder();
        
        System.out.print("\n Post-order traversal: ");
        obj.postorder();
        
        System.out.print("\n Level-order traversal: ");
        obj.levelorder();
        
    }

}    
