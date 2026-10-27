import java.util.Scanner;
import java.util.*;
public class buildtree{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static node helper(int[] preorder,int prelow,int prehigh ,int[] inorder,int inlow,int inhigh ){
  if(prelow>prehigh || inlow > inhigh) return null;
  int i=inlow;
   
        while (i <= inhigh && inorder[i] != preorder[prelow]) {
            i++;
        }
        
    int leftsize=i-inlow;

    node root=new node(preorder[prelow]);
    root.left=helper(preorder,prelow+1,prehigh,inorder,inlow,i-1);
    root.right=helper(preorder,prelow+leftsize+1,prehigh,inorder,i+1,inhigh);
    return root;
}
public static node buildtree(int[] preorder,int[] inorder){
    int n=preorder.length;
    return helper(preorder,0,n-1,inorder,0,n-1);


        
  
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
      int[] preorder=new int[n];
      int[] inorder=new int[n];
      System.out.print("ENTER A 1st ELEMENTS OF THE ARRAY :");
      for(int i=0;i<n;i++){
        preorder[i]=sc.nextInt();
      }

      //second array
       
    
      System.out.print("ENTER A  2nd ELEMENTS OF THE ARRAY :");
      for(int i=0;i<n;i++){
        inorder[i]=sc.nextInt();
      }
    node z=  buildtree(preorder,inorder);
      int k=height(z);
            
            for(int i=1;i<=k;i++){
            
                nthlevel1(z,i);
          
              System.out.println();
            }
            
            
          
    
}
}