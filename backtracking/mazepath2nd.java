import java.util.Scanner;
public class mazepath2nd{
    public static void maze(int sc,int sr,int ec, int er,String s){
        if(sc==ec  && sr==er) {
            System.out.println(s);
            return ;
        }
        if(sc>ec  ||  sr>er) return ;
       maze(sc+1,sr,ec,er,s+"r");
        maze(sc,sr+1,ec,er,s+"d");
        return;
      
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a row :");
        int row=sc.nextInt();
        System.out.print("Enter a column :");
        int column=sc.nextInt();
        maze(1,1,row,column," ");
    }
}