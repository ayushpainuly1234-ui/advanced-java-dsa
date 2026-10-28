import java.util.Scanner;
import java.util.*;
public class knight{
   static  int maxknight=-1;
   static int number=3;
      public static boolean issafe(int row, int col, char[][] grid) {
        int n = grid.length;

        // All 8 knight moves
        int[][] moves = {
            {-2,-1}, {-2,1}, {-1,-2}, {1,-2},
            {2,-1}, {2,1}, {1,2}, {-1,2}
        };

        for (int[] m : moves) {
            int nr = row + m[0];
            int nc = col + m[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (grid[nr][nc] == 'K') return false;
            }
        }
        return true;
    }

    public static void knight(char[][] grid,int row,int col, List<List<String>> ans,int nums){
       int n=grid.length;
       // basecase
     if(n==row){
      // if(number==nums){ 
         
    // List<String> list= new ArrayList<>();
       //    for(int i=0;i<n;i++){
          //     String str="";
         //  for(int j=0;j<n;j++){
             //    str+=grid[i][j];
              //     System.out.print(grid[i][j]+" ");
             //  }
                
    //    list.add(str);
    //    }
        
   // ans.add(list);
     //  }
          maxknight=Math.max(maxknight,nums);
          return;

       }
       



     else   if(issafe(row,col,grid)){
        grid[row][col]='k';
        if(col!=n-1){
            knight(grid,row,col+1,ans,nums+1);
        }
        else{
             knight(grid,row+1,0,ans,nums+1);

        }
         grid[row][col]='x';

       }
        if(col!=n-1){
            knight(grid,row,col+1,ans,nums);
        }
        else{
            knight(grid,row+1,0,ans,nums);

        }
        return;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=3;
   char[][] grid=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               grid[i][j]='x';
            }

        }
      List <List<String>> ans=new ArrayList<>();
        knight(grid,0,0,ans,0);
      //  for(int i=0;i<ans.size();i++){
         //  System.out.print(ans.get(i)+" ");
    //   }
    System.out.print(maxknight);

        
    
    }
}

