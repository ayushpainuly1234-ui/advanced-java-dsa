import java.util.Scanner;
import java.util.*;
public class inorderpredecessor{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static void inorder(node root,int key,  List<Integer> arr){
    if(root==null) return;
    node temp=root;
   
    inorder(root.left,key, arr);
     if(temp!=null){
      arr.add(temp.val);
    }
    inorder(root.right,key,  arr);
    return;
  



}

    public static void  main(String[] args){
        Scanner sc= new Scanner(System.in);
      node root = new node(4);
root.left = new node(1);
root.right = new node(7);

root.left.right = new node(3);
root.right.right = new node(8);


       int key = 7;
        List<Integer> arr=new ArrayList<>();
   
       inorder(root,key,arr);
        int idx=-1;
    for(int i=0;i<arr.size();i++){
        if(arr.get(i)==key){
            idx=i;
            break;
        }
    }
    int p=arr.get(idx-1);
    int s=arr.get(idx+1);
    System.out.println("the p "+p);
    System.out.print("the s "+s);

        
     
} 

}   