import java.util.Scanner;
import java.util.*;
public class bfs{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}


    public static void bfs(node root){
        Queue<node> q=new LinkedList<>();
        if(root!=null){
            q.add(root);

        }
        while(!q.isEmpty()){
            node temp=q.peek();
          if(temp.left!=null)   q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            System.out.print(temp.val+" ");
            q.remove();
        }
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
               bfs(root);
          
               
    
}
}