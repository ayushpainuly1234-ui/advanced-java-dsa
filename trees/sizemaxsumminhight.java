import java.util.*;
public class sizemaxsumminhight{
   static int size=0;

    public static class node{
        int val;
        node left;
        node right;
        public node(int val){
            this.val=val;
        }

    }
     
    public static void sizehain(node root){
        if(root==null){
            return ;
        }
      size++;
       sizehain(root.left);
       sizehain(root.right);

      
    }
    public static int size(node root){
        if(root==null){
            return 0;
        }
        return  1+size(root.left)+size(root.right);


    }
    public static int sum(node root){
        if(root==null){
            return 0;
        }
        return  root.val+sum(root.left)+sum(root.right);

    }
    public static int max(node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int a=max(root.left);
        int b=max(root.right);
        return Math.max(root.val,Math.max(a,b));

    }
    public static int hight(node root){
        if(root==null){
            return 0;
        }
        if(root.left==null  &&  root.right==null){
            return 0;
        }
        return 1+Math.max(hight(root.left),hight(root.right));
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
                sizehain(root);
                System.out.print(size);
                System.out.println("");
               System.out.println( size(root));
               System.out.println(sum(root));
               System.out.println(max(root));
               System.out.println(hight(root));



      
      
    }
}