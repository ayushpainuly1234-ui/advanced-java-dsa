import java.util.Scanner;
import java.util.*;
public class issametree{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static boolean issametree(node p,node q){
    if(p==null  && q==null) return true;
    if(p==null   ||  q==null) return false;
    if(p.val!=q.val) return false;
    return (issametree(p.left,q.left)  &&   issametree(p.right,q.right));
     
     }

  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node p= new node(1);
         p.left=new node (2);
         p.right=new node(3);
       
         node q=new node(1);
           q.left=new node (2);
           q.right=new node(3);

          boolean flag=issametree(p,q);
          System.out.print(flag);
          
               
    
}
}