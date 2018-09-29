/**
 * @file 	main.cpp
 * @author 	Inst. Duc Ta
 * @author	Ratna Lama 
 * @date	7/5/2018
 * @version	1.07.0
 * 
 * @brief	CSC340, Part I TicTacToe
 * 
 * @section DESCRIPTION
 * 
 * A program to play game of Tic-Tac-Toe
 * 
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

#include <iostream>
#include <string>
using namespace std;

// Function Prototypes
void displayBoard(char board[][3]);
void makeAMove(char board[][3], char player);
bool isDraw(char board[][3]);
bool isWon(char player, char board[][3]);


// Begin Main Function
int main() {
	//
	//	PLEASE DO NOT CHANGE main()
	//
	char board[3][3] = { { ' ', ' ', ' ' },{ ' ', ' ', ' ' },{ ' ', ' ', ' ' } };
	displayBoard(board);
	
	while (true) {
		// The first player makes a move
		makeAMove(board, 'X');
		displayBoard(board);
		if (isWon('X', board)) {
			cout << "X player won" << endl;
			exit(0);
		}
		else if (isDraw(board)) {
			cout << "No winner" << endl;
			exit(0);
		}

		// The second player makes a move
		makeAMove(board, 'O');
		displayBoard(board);

		if (isWon('O', board)) {
			cout << "O player won" << endl;
			exit(0);
		}
		else if (isDraw(board)) {
			cout << "No winner" << endl;
			exit(0);
		}
	}
	
	return 0;
	
} // end Main Function


/**
* Function displayBoard
* Displays a 3x3 gameboard each cell filled with " " separated by "|"
*/
void displayBoard(char board[][3] ) {	
	cout <<"--------------" <<endl;
	
	for (int row=0; row<3; row++) {
		for (int col=0; col<3; col++) {
			cout <<"| " << board[row][col] <<" ";			
		} 
		cout <<" | " <<"\n--------------" <<endl;
	} 
	cout << endl;
	
} // end displayBoard


/**
* Function isWon
* Declares a winner if any player has scored three 'O' or 'X' along the same row
* or column or along any of the two diagonals.
* @param	player	the current player 'O' or 'X'
* 		 	board 	game board
* @return	hasWon	True if any player has scored three '0' or 'X' along the same row
*					or column or along any of the two diagonals.
*/
bool isWon(char player, char board[][3]) {
	bool hasWon {};

	if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][0] == player)){
		hasWon = true;
	}else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][1] == player)) {
		 hasWon = true;
	}else if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] == player)) {
		 hasWon = true;
	}else if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][0] == player)) {
		 hasWon = true;
	}else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[1][0] == player)) {
		 hasWon = true;
	}else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[2][0] == player)) {
		 hasWon = true;
	}else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == player)) {
		 hasWon = true;
	}else if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && (board[2][0] == player)) {
		 hasWon = true;
	}else {
		 hasWon = false;
	}
	return hasWon;	
	
} // end isWon


/**
* Function isDraw
* Checks if game is a draw by checking if all the cell in the
* boad has been filled with 'O' or 'X'
* @return	boardFull	If the TicTacToe game is a  draw returns
*						returns True else false.
*/
bool isDraw(char board[][3]) {
	bool boardFull = true;
	for (int row=0; row<3; row++) {
		for (int col=0; col<3; col++) {
			if (board[row][col] == ' ') {
				boardFull = false;				
			}
		}
 	}
	return boardFull;
} // isDraw


/**
* Function makeAMove
* Asks user for row and column input
* to replace the char at user specified cell location
* in the gameboard. If the user specified cell location is
* already occupied with a 'X' or 'O' then asks user to input
* new sets of row and column.
* @param	board	game board 	
* 			player 	character to make a move in gameboard
*/
void makeAMove(char board[][3], char player) {
	int row {};
	int col {};
	
	cout <<"Enter a row (0,1,2) for player " << player <<" : ";
	cin >>row;
	cout <<"Enter a column (0,1,2) for player " << player <<" : ";
	cin >>col;
	
	while (board[row][col] == 'X' || board[row][col] == 'O') {
		cout <<"\nThis cell is already occupied. Try a different cell" << endl;
		cout <<"Enter a row (0,1,2) for player " << player <<" : ";
		cin >>row;
		cout <<"Enter a column (0,1,2) for player " << player <<" : ";
		cin >>col;		
	} 
	
	board[row][col] = player;
	
} // end makeAMove