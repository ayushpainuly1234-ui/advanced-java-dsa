import java.util.Scanner;
import java.util.*;
public class binarytreepath{
public static class node{
    int val;
     node left;
        node right;
        public node(int val){
            this.val=val;
        }
}
public static void helper(node root,List<String> ans,String str){
    if(root==null) return ;
    if(root.left==null  && root.right==null) {
        str+=root.val;
        ans.add(str);
        return;
    }
    helper(root.left,ans,str+root.val+"->");
    helper(root.right,ans,str+root.val+"->");
}
public  static List<String> binarytreepath(node root){
  List<String> ans=new ArrayList<>();
 helper(root,ans,"");
return ans;
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
               List <String> path=binarytreepath(root);
               System.out.print(path);
            
     
    
}
}