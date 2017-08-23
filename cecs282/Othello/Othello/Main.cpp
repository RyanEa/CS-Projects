#include <iostream>
#include "OthelloGame.h"
using namespace std;
int main() {
   char gameBoard[BOARD_SIZE][BOARD_SIZE] = { 0 };
   gameBoard[3][3] = -1;
   gameBoard[4][4] = -1;
   gameBoard[3][4] = 1;
   gameBoard[4][3] = 1;
   char turn;
   bool valid = true, end1 = false, end2 = false;
   int col, row, outcome;
   int *colVal = &col, *rowVal = &row;
   cout << "Welcome to Othello" << endl;
   turn = 'B';
   while ((!end1 || !end2)) {
      while (turn == 'B' && valid) {
         PrintBoard(gameBoard);
         cout << "Black's turn:";
         GetMove(rowVal, colVal);
         valid = !IsValidMove(gameBoard, row, col);
         cout << (valid ? "Invalid Move" : "") << endl;
      }
      end1 = (row == -1 && col == -1) ? true : false;
      if (row>-1 && col > -1)
         ApplyMove(gameBoard, row, col, turn = 'B');
      else
         cout << "Black passed." << endl;
      turn = 'W';
      while (turn == 'W' && !valid && !end2) {
         PrintBoard(gameBoard);
         cout << "White's turn:";
         GetMove(rowVal, colVal);
         valid = IsValidMove(gameBoard, row, col);
         cout << (valid ? "Invalid Move" : "") << endl;
      }
      end2 = (row == -1 && col == -1) ? true : false;
      if (row > -1 && col > -1)
         ApplyMove(gameBoard, row, col, turn = 'W');
      else
         cout << "White passed." << endl;
      turn = 'B';
   }
   outcome = GetValue(gameBoard);
   cout << ((outcome < 0) ? "White Wins!" : (outcome>0) 
      ? "Black wins!" : "It's a tie!");
   cout << endl;
   system("pause");
}