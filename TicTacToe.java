/**
 * TicTacToe.java 	--A program to play game of Tic-Tac-Toe.
 * @author    				Ratna Lama / King Arthur Alagao
 * @version   				1.0
 * @since     				11/01/2017
*/

/**
 * Algorithm:
 * 1.) Displays the current board status.
 * 2.) Prompts the user for a row and column input.
 * 3.) Displays the current board status.
 * 4.) Checks if the player succeeds in placing three of their marks in a
 *     horizontal, vertical, or diagonal row and declare that player as the
 *     winner.
 * 5.) Checks if the board is full and if there is no winner yet.
 * 6.) Gives the turn to the next player and repeat steps 2-5.
 */
public class TicTacToe{

	public static void main(String[] args) {

		GameBoard tictactoe = new GameBoard();
		boolean keepPlaying = true;

		System.out.println();
		tictactoe.displayBoard();			// Displays Tic-Tac-Toe Board
		while(keepPlaying){
			tictactoe.makeAMove('X');		// Player 'X' makes a move
			tictactoe.displayBoard();
			if(tictactoe.isWon('X')){		// Checks if player 'X' has Won
				System.out.println("X has won.");
				keepPlaying = false;
			}else if(tictactoe.isDraw() && !tictactoe.isWon('X')){		// Checks if game is a draw
				System.out.println("The game is a draw.");
				keepPlaying = false;
			}

			if(keepPlaying){
				tictactoe.makeAMove('O');	// Player 'O' makes a move
				tictactoe.displayBoard();
				if(tictactoe.isWon('O')){	// Checks if player 'O' has won
					System.out.println("O has won.");
					keepPlaying = false;
				}
			}
		} // end while loop
	} // end main method
} // end class TicTacToe
