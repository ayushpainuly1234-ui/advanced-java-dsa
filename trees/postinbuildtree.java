import java.util.Scanner;
import java.util.*;
public class postinbuildtree{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static  node helper(int[] postorder,int postlow,int posthigh,int[] inorder,int inlow,int inhigh){
    if(postlow>posthigh)  return null;
     node root=new node(postorder[posthigh]);
     int i=inlow;
    while(postorder[posthigh]!=inorder[i]){
        i++;
    }
    int rightsize=inhigh-i;
     root.left=helper(postorder,postlow,posthigh-rightsize-1,inorder,inlow,i-1);
     root.right=helper(postorder,posthigh-rightsize,posthigh-1,inorder,i+1,inhigh);
     return root;





}
public static node buildtree(int[] postorder,int[] inorder){
    int n=postorder.length;
    return  helper(postorder,0,n-1,inorder,0,n-1);
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
public static int height(node root){
    if(root==null) return 0;
   return  1+Math.max( height(root.left) , height(root.right));
}




  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
      System.out.print("Enter a legth of the array :");
      int n=sc.nextInt();
      int[] postorder=new int[n];
      int[] inorder=new int[n];
      System.out.print("ENTER A 1st ELEMENTS OF THE ARRAY :");
      for(int i=0;i<n;i++){
        postorder[i]=sc.nextInt();
      }

      //second array
       
    
      System.out.print("ENTER A  2nd ELEMENTS OF THE ARRAY :");
      for(int i=0;i<n;i++){
        inorder[i]=sc.nextInt();
      }
    node z=  buildtree(postorder,inorder);
      int k=height(z);
            
            for(int i=1;i<=k;i++){
            
                nthlevel1(z,i);
          
              System.out.println();
            }
            
            
          
    
}
}