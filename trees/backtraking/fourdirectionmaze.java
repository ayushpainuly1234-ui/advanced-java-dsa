import java.util.Scanner;
public class fourdirectionmaze{
    private static void maze(int sr,int sc,int er,int ec,String s, boolean[][] flag){
        if(sr<0  ||  sc<0) return;
        if(sr>er || sc>ec) return;
        if(sr==er  &&  sc==ec){
               System.out.println(s);
               return;
        }
        if(flag[sr][sc]==true){
            return;
        }
        flag[sr][sc]=true;
        // go down
        maze(sr+1,sc,er,ec,s+"d",flag);
        //go right
        maze(sr,sc+1,ec,er,s+"r",flag);
        // go up
        maze(sr-1,sc,ec,er,s+"b",flag);
        //go back
        maze(sr,sc-1,ec,er,s+"u",flag);
        flag[sr][sc]=false;
        return;
        
    }
    public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
        System.out.print("Enter a row :");
        int row=sc.nextInt();
        System.out.print("Enter a column :");
        int column=sc.nextInt();
            boolean[][] flag=new boolean[row][column];
        maze(0,0,row-1,column-1," ",flag);
    }
}