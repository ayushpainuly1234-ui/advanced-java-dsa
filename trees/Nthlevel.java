import java.util.*;
public class Nthlevel{


    public static class node{
        int val;
        node left;
        node right;
        public node(int val){
            this.val=val;
        }

    }
    public static void nthlevel(node root,int n){
        if(root==null) return;
          if(n==1) System.out.print(root.val+" ");
        nthlevel(root.left,n-1);
        nthlevel(root.right,n-1);

    }
    public static int  height(node root){
        if(root==null){
             return 0;
        }
        if(root.left==null  &&  root.right==null){
             return 0;
        }

      return 1+Math.max(height(root.left),height(root.right));
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
             int n=3;
               
      int level=height(root)+1;
      for(int i=1;i<=level;i++){
        nthlevel(root,i);
        System.out.println("");
      }
          



      
      
    }
}