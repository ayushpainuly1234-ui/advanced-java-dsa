import java.util.Scanner;
import java.util.*;
public class pathsumsecond{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }

}
public static void pathsumfirstsecond(node root, List<Integer> arr,  List<List<Integer>> ans,int targetsum){
   if(root==null) return;
   if(root.left==null  && root.right==null){
    arr.add(root.val);
    if(root.val==targetsum) {
         List<Integer> a=new ArrayList<>();
     for(int i=0;i<arr.size();i++){
      a.add(arr.get(i));
     }
        ans.add(a);
    }
   
   
 arr.remove(arr.size()-1);
    return;

   }
   arr.add(root.val);
   pathsumfirstsecond(root.left,arr,ans,targetsum-root.val);
   pathsumfirstsecond(root.right,arr,ans,targetsum-root.val);
    arr.remove(arr.size()-1);
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

               List<Integer> arr=new ArrayList<>();
                 List<List<Integer>> ans=new ArrayList<>();
                 System.out.print("Enter a target sum :");
                 int targetsum=sc.nextInt();
               pathsumfirstsecond(root,arr,ans,targetsum);
             System.out.print(ans);
             
            
          
    
}
}