import com.example.tictactoe.model.*;


import java.util.Objects;
import java.util.Scanner;

public class Main {

    private Board board;
    private Player[] player;

    private int currentPlayer;
    Main(){
        this.board=new Board();
        this.currentPlayer=1;
        this.player =new Player[3];
        this.player[1] = new Player(1,"Shifali");
        this.player[2]=new Player(2,"Nikhil");
    }
    public void startGame() throws Exception {

        while(!checkWinner() || !this.board.isBoardFilled()){
            this.board.printBoard();
            System.out.println("current player "+this.player[currentPlayer].getName());
            String mark="";
            if(currentPlayer==1)
                mark="X";
            else mark="0";
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter x position :");
            int x = sc.nextInt();
            System.out.println("Enter y position :");
            int y = sc.nextInt();
            Cell cell = this.board.getBox(x,y);
            makeMove(new Move(cell),this.player[0],mark);
            if(checkWinner()){
                this.board.printBoard();
                System.out.println("Player WONN!! "+this.player[currentPlayer].getName());
                break;
            }
            if(this.board.isBoardFilled()){
                this.board.printBoard();
                System.out.println("NOBODY WINNS!!");
                break;
            }
            //switch player
            this.currentPlayer=3-this.currentPlayer;
        }

    }
    public boolean checkWinner() throws Exception {
        for(int i=0 ;i<3 ;i++){
            //for rows
            if(Objects.equals(this.board.getBox(i, 0).getMark(), this.board.getBox(i, 1).getMark()) &&
                    Objects.equals(this.board.getBox(i, 1).getMark(), this.board.getBox(i, 2).getMark())
                    && !Objects.equals(this.board.getBox(i, 1).getMark(),".")) {
                return true;
            }
            //for columns
            if(Objects.equals(this.board.getBox( 0,i).getMark(), this.board.getBox(1,i).getMark()) &&
                    Objects.equals(this.board.getBox(1,i).getMark(), this.board.getBox(2,i).getMark())
                    && !Objects.equals(this.board.getBox(1,i).getMark(),".")) {
                return true;
            }

        }
        //for cross diagonals
        if(Objects.equals(this.board.getBox( 0,0).getMark(), this.board.getBox(1,1).getMark()) &&
                Objects.equals(this.board.getBox(1,1).getMark(), this.board.getBox(2,2).getMark())
                && !Objects.equals(this.board.getBox(1,1).getMark(),".")) {
            return true;
        }
        if(Objects.equals(this.board.getBox( 0,2).getMark(), this.board.getBox(1,1).getMark()) &&
                Objects.equals(this.board.getBox(1,1).getMark(), this.board.getBox(2,0).getMark())
                && !Objects.equals(this.board.getBox(1,1).getMark(),".")) {
            return true;
        }
        return false;
        
    }
    public void makeMove(Move move, Player player,String mark){
        if(move.isValid()){
            move.getCell().setMark(mark);
        }
        else
            System.out.println("Not a valid move");
    }
    public static void main(String[] args) throws Exception {

        Main tic_tac_toe = new Main();
        tic_tac_toe.startGame();
    }
}