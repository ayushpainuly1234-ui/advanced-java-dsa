import java.util.*;
public class preinpost{


    public static class node{
        int val;
        node left;
        node right;
        public node(int val){
            this.val=val;
        }

    }
    public static void preorder(node root){
        if (root==null) return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);


        
    }
    public static void inorder(node root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);


    }
    public static void postorder(node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

     
   
    
   

   
    
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root= new node(1);
        node a=new node(2);
            node b=new node(3);
            root.left=a;
            root.right=b;
                node c=new node(4);
                node d=new node(5);
                a.left=c;
                a.right=d;
               node e=new node(6);
               b.right=e;
               
        //  preorder(root);
       // inorder(root);
       postorder(root);



      
      
    }
}