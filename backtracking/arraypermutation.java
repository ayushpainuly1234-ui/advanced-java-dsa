import java.util.Scanner;
import java.util.*;// IMPORTANT LEETCODE 46
public class arraypermutation{
   public static void helper(int[] arr, List<Integer> nums,boolean[] ismark, List<List<Integer>> ans){
        if(arr.length==nums.size()){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
            list.add(nums.get(i));
            }
            ans.add(list);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(ismark[i]==false){
            nums.add(arr[i]);
            ismark[i]=true;
            helper(arr,nums,ismark,ans);
            ismark[i]=false;
            nums.remove(nums.size()-1);
            }
        }
         return;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr={1,2,3};
        List<Integer> nums=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] ismark=new boolean[arr.length];
        helper(arr,nums,ismark,ans);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}