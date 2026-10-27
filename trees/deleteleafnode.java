import java.util.Scanner;
import java.util.*;
public class deleteleafnode{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static void display(node root,int n){
    if(root==null) return ;
    node temp=root;
   if(n==1){
        System.out.print(temp.val+" ");
   }
    display(root.left,n-1);
    display(root.right,n-1);
    return;
}
public static node delete(node root,int delete){
  if(root==null) return null;
    if(root.val>delete){
        if(root.left.val==delete) return root.left=null;
      else   delete(root.left,delete);
    }
    else{ // root.val<delete
          if(root.right.val==delete) return root.right=null;
   else      delete(root.right,delete);

    }
    return root;    
}



public static node delete2(node root,int delete){
  if(root==null) return null;

    if(root.val>delete){
      
        if(root.left.val==delete ){
            node temp=root.left;
        if(temp.left==null  &&  temp.right==null){
          return root.left=null;
        }
          if(temp.left!=null)  root.left=temp.left;
          else  root.left=temp.right;  
        }
         else{
    delete2(root.left,delete);        
   }
  
    }
    else{ // root.val<delete
       
          if(root.right.val==delete){
              node semp=root.right;
           if(semp.left==null  &&  semp.right==null){
          return root.right=null;
        }
            if(semp.left!=null){
           return root.right=semp.left;
            }
            else{
               return root.right=semp.right;
            }
          }

            
         else {
            delete(root.right,delete);
    }

    }
    return root;    
}
public static int hi(node root){
    if(root==null) return 0;
    int ans=1+Math.max(hi(root.left),hi(root.right));
    return ans;
}
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
      node root = new node(4);
root.left = new node(1);
root.right = new node(7);

root.left.right = new node(3);
root.right.right = new node(8);


     int delete = 1;
       int height=hi(root);
      //   node ans=  delete(root,delete);
         node ans=delete2(root,delete);
         for(int i=1;i<=height;i++){
          display(ans,i);
          System.out.println("");
         }
     
} 

}   //output

//     4
 //    3 7
 //      8