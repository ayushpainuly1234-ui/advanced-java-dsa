import java.util.Scanner;
import java.util.*;
public class sortedorderbst{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static void bst(node root, List<Integer> arr){
  if(root==null) return;
  bst(root.left,arr);
 arr.add(root.val);
  bst(root.right,arr);
  return;
}
    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
        node root = new node(4);
        root.left = new node(2);
        root.right = new node(7);

        root.left.left = new node(1);
       
         root.left.right=new node(3);

         List<Integer> arr=new ArrayList<>();
           bst(root,arr);
           System.out.print(arr);
     
} 

}