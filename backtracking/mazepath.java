import java.util.Scanner;
public class mazepath{
    public static int maze(int sc,int sr,int ec, int er){
        if(sc==ec  && sr==er) return 1;
        if(sc>ec  ||  sr>er) return 0;
        int rightways=maze(sc+1,sr,ec,er);
        int downways=maze(sc,sr+1,ec,er);
        int totalways=rightways+downways;
        return totalways;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a row :");
        int row=sc.nextInt();
        System.out.print("Enter a column :");
        int column=sc.nextInt();
        int count=maze(1,1,row,column);
        System.out.print("the count is a :"+count);
    }
}