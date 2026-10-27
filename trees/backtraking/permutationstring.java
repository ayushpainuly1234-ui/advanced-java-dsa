import java.util.Scanner;
import java.util.*;
public class permutationstring{
   
        public static void permutation(String str,String t, List<String> arr){
            if(str.isEmpty()){
             //   System.out.println(t);
             arr.add(t);
               return;
            }
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                String left=str.substring(0,i);
                String right=str.substring(i+1);
                String remain=left+right;
                permutation(remain,t+ch,arr);
            }
        }
         public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       // System.out.print("Enter a string :");
        String str="abc";
        List<String> arr=new ArrayList<>();
        permutation(str,"",arr);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
    
}