import java.util.Scanner;
import java.util.*;
public class zigzagordertraversal{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static int height(node root){
    if(root==null) return 0;
   return  1+Math.max( height(root.left) , height(root.right));
}
public static void nthlevel1(node root,int n){
    if(root==null) return;
    if(n==1){
         System.out.print(root.val+" ");
         return;
    }
   nthlevel1(root.left,n-1);
    nthlevel1(root.right,n-1);
    


}
public static void nthlevel2(node root,int n){
    if(root==null) return;
    if(n==1){
         System.out.print(root.val+" ");
         return;
    }
    nthlevel2(root.right,n-1);
    nthlevel2(root.left,n-1);
    
    


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
               node f=new node(7);
               b.left=e;
               b.right=f;

               int n=height(root);
               if(root==null) return;
            for(int i=1;i<=n;i++){
               if(i%2!=0){
                nthlevel1(root,i);
               }
               else{
              nthlevel2(root,i);
               }
               System.out.println("  ");
            }
            
          
    
}
}