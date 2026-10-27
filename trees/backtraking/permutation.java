import java.util.Scanner;
import java.util.*;
public class permutation{
    public static void swap(int i,int j,int[] nums ){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
   public static void helper(int[] arr,int idx, List<List<Integer>> ans){
        if(arr.length-1==idx){
             List<Integer> list=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
            }
            ans.add(list);
       return;
        }
        for(int i=idx;i<arr.length;i++){
            swap(i,idx,arr);
            helper(arr,idx+1,ans);
            swap(i,idx,arr); // backtraking 
           
        }
         return;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr={1,2,3};
        List<List<Integer>> ans=new ArrayList<>();
        helper(arr,0,ans);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}