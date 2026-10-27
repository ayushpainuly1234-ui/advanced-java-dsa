import java.util.Scanner;
import java.util.*;
public class nqueen{
    public static boolean issafezone(int row,int col,char[][] nums){
          //row cheak
          int n=nums.length;
          for(int i=0;i<n;i++){
           if (nums[i][col]=='Q'){
            return false;
           }
          }             
          // column cheak
          for(int j=0;j<n;j++){
          if( nums[row][j]=='Q'){
              return false;
          }
          }
         // up right 
         int i=row;
         int j=col;
          while(i>=0 &&  j<n){
            if(nums[i][j]=='Q'){
                return false;
            }
            i--;
          j++;
          }
             i=row;
             j=col;
          //down right
            while(i<n &&  j<n){
            if(nums[i][j]=='Q'){
                return false;
            }
            i++;
          j++;
          }
            i=row;
             j=col;
          //up left
            while(i>=0 &&  j>=0){
            if(nums[i][j]=='Q'){
                return false;
            }
            i--;
          j--;
          }
            i=row;
             j=col;
          // down left
            while(i<n &&  j>=0){
            if(nums[i][j]=='Q'){
                return false;
            }
            i++;
          j--;
          }
          return true;


    }
    public static void nqueen(char[][] board,int row, List<List<String>> ans){
        int n=board.length;
        if(n==row){
            List<String> list=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                 String str="";
                for(int j=0;j<n;j++){
                    str+=board[i][j];
                }
                //System.out.println("");
              list.add(str);
            }
        
         ans.add(list);
         return;
            
           
              

        }
        for(int j=0;j<n;j++){
         if(issafezone(row,j,board)==true){
             board[row][j]='Q';
             nqueen(board,row+1,ans);
              board[row][j]='.';   // bactraking if is no fit a q in your position so thats why backtrack
         }

        }
        return;


    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a length of the board ::");
        int n=sc.nextInt();
       char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
            System.out.println("");
        }
        System.out.println("");
  
    List<List<String>> ans= new ArrayList<>();
 int row=0;
   nqueen(board,row,ans);
   for(int i=0;i<ans.size();i++){
   System.out.print(ans.get(i));

   }
    System.out.println(); 
   sc.close();
}

}


