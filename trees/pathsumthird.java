import java.util.Scanner;
import java.util.*;
public class pathsumthird{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static int helper(node root,int target){
    if(root==null) return 0;
    int count=0;
    if(root.val==target) count++;

  count =count+helper(root.left, target - root.val)+ helper(root.right, target - root.val);

        return count;

}
public static int pathsumthird(node root,int target){
   if(root==null) return 0;
    int count= helper(root,target);
   
  count+= pathsumthird(root.left,target)+pathsumthird(root.right,target) ;

   return count;
}



  
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root = new node(5);
        root.left = new node(4);
        root.right = new node(8);

        root.left.left = new node(11);
        root.left.left.left = new node(7);
        root.left.left.right = new node(2);

        root.right.left = new node(13);
        root.right.right = new node(4);
        root.right.right.left = new node(5);
        root.right.right.right = new node(1);

              
                 System.out.print("Enter a target sum :");
                 int targetsum=sc.nextInt();
            int ans=  pathsumthird(root,targetsum);
             System.out.print("the count is-> :"+ans);
             
            
          
    
}
}