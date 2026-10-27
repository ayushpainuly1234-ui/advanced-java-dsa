import java.util.Scanner;
import java.util.*;
public class diameterofbinarytree{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static int height(node root){
    if(root==null){
        return 0;
    }
    if(root.left==null   &&  root.right==null){
        return 0;
    }
    return 1+Math.max(height(root.left),height(root.right));
}
public static int diameter(node root){
    return 2+height(root.left)+height(root.right);
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
            System.out.print(diameter(root));
          
               
    
}
}