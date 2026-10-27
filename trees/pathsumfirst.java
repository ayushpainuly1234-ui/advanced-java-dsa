import java.util.Scanner;
import java.util.*;
public class pathsumfirst{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static boolean pathsumfirst(node root,int target){
   if(root==null) return false;
  if(root!=null  && root.left==null && root.right==null){
    if(root.val==target  )  return true;
  }
  
    return (pathsumfirst(root.left,target-root.val)  ||  pathsumfirst(root.right,target-root.val));
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
               System.out.print("Enter a target :");
               int target=sc.nextInt();
               boolean flag=pathsumfirst(root,target);
               System.out.print(flag);

             
            
          
    
}
}