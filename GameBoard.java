/**
 * GameBoard.java 	--A program class to create a displayboard to play the game of Tic-Tac-Toe
 * @author    				Ratna Lama / King Arthur Alagao
 * @version   				1.0
 * @since     				11/01/2017
*/
import java.util.Scanner;

public class GameBoard{
	private char[][] board;
	private Scanner input;
	final int range = 3;
	boolean hasWon;

	/**
	* Creates a 3x3 gameboard and fills each cell with '*'
	*/
	public GameBoard(){
		board = new char[range][range];
		for(int row=0; row<range; row++){
			for(int col=0; col<range; col++){
				board[row][col] = '*';
			}
		}
	} // end GameBoard()

	/**
	* Displays a 3x3 gameboard each cell filled with '*'
	*/
	public void displayBoard(){
		System.out.println("-------------------");
		for(int row=0; row<range; row++){
			for(int col=0; col<range; col++){
				System.out.print(" | "  + board[row][col]);
			}
		System.out.println(" | " + "\n-------------------");
		}
	} // end displayBoard()

	/**
	* Asks user for row and column input
	* to replaces the char at user specified cell location
	* in the gameboard. If the user specified cell location is
    * already occupied with a 'X' or 'O' then asks user to input
    * new sets of row and column.
    * @param 	player 	character to make a move in gameboard
	*/
	public void makeAMove(char player){
		input = new Scanner(System.in);
		System.out.print("Enter a row for player " + player + ": ");
		int rowInput = input.nextInt();
		System.out.print("Enter a column for player " + player + ": ");
		int columnInput = input.nextInt();

		/**
		* Checks if a cell is already occupied with a 'X' or 'O'.
		*/
		while(board[rowInput][columnInput] == 'X' || board[rowInput][columnInput] =='O'){
			System.out.println("This cell is already occupied. "
				+ "Try a different cell.");
			System.out.print("Enter a row for player " + player + ": ");
			rowInput = input.nextInt();
			System.out.print("Enter a column for player " + player + ": ");
			columnInput = input.nextInt();
		}
		board[rowInput][columnInput] = player;
	} // end makeAMove()

	/**
	* Checks if game is a draw by checking if all the cell in the
	* boad has been filled with 'O' or 'X'
	* @return	fullBoard	If the TicTacToe game is a  draw returns
	*						returns True else false.
	*/
	public boolean isDraw(){
		boolean fullBoard = true;
		for(int row = 0; row<range; row++){
			for(int col=0; col<range; col++){
				if (board[row][col]== '*'){
					fullBoard = false;
				}
			}
		}
		return fullBoard;
	} // end isDraw()

	/**
	* Declares a winner if any player has scored three 'O' or 'X' along the same row
	* or column or along any of the two diagonals.
	* @param	player	the current player 'O' or 'X'
	* @return 	hasWon 	True if any player has scored three '0' or 'X' along the same row
	*					or column or along any of the two diagonals.
	*/

	public boolean isWon(char player){

		boolean hasWon;
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0]
                && (board[0][0] == player))
                hasWon = true;
        else if(board[0][1] == board[1][1] && board[1][1] == board[2][1]
                && (board[0][1] == player))
                hasWon = true;
        else if(board[0][2] == board[1][2] && board[1][2] == board[2][2]
                && (board[0][2] == player))
                hasWon = true;
        else if(board[0][0] == board[0][1] && board[0][1] == board[0][2]
                && (board[0][0] == player))
                hasWon = true;
        else if(board[1][0] == board[1][1] && board[1][1] == board[1][2]
                && (board[1][0] == player))
                hasWon = true;
        else if(board[2][0] == board[2][1] && board[2][1] == board[2][2]
                && (board[2][0] == player))
                hasWon = true;
        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2]
                && (board[0][0] == player))
                hasWon = true;
        else if(board[2][0] == board[1][1] && board[1][1] == board[0][2]
                && (board[2][0] == player))
                hasWon = true;
        else
            hasWon = false;
        return hasWon;

	} // end isWon()

} // end class GameBoard
