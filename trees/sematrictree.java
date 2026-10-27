import java.util.Scanner;
import java.util.*;
public class sematrictree{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static node invert(node root){
    if(root==null) return root;
   node l=root.left;
   node r=root.right;
    root.left=invert(r);
    root.right=invert(l);
    return root;

}
public static boolean issametree( node p,node q){
          if(p==null && q==null)  return true;
          if(p==null  ||  q==null) return false;
          if(p.val!=q.val) return false;
    return (issametree(p.left,q.left) &&  issametree(p.right,q.right));
}
public static boolean sematrictree(node root){
    
    root.right=invert(root.right);
    return  issametree( root.left,root.right);
    
} 



  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root= new node(1);
        node a=new node(2);
            node b=new node(2);
            root.left=a;
            root.right=b;
                node c=new node(4);
                node d=new node(5);
                a.left=c;
                a.right=d;
               node e=new node(5);
                node f=new node(4);
               b.right=f;
               b.left=e;
             System.out.print(sematrictree(root));

            
          
    
}
}