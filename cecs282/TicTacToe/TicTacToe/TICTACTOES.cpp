#include <iostream>
#include "tictactoe.h"
using namespace std;
char checkReturn(char);
const int TURNS = 9;
int main(int argc, char* argv[]) {
   char board[3][3] = { 0 };
   int col, row, counter = 0;
   bool turns=true;
   int *colVal=&col, *rowVal=&row;
   cout << "WELCOME TO THE GAME OF TIC TAC TOE" << endl;
   while (counter < 9) {
      while (turns&&counter<=9) {
         PrintBoard(board);
         cout << "X's turn:";
         GetMove(rowVal, colVal);
         turns = !MoveIsValid(board, row, col);
      }
      board[row][col] = 1;
      counter++;
      while (!turns&&counter<9) { 
         PrintBoard(board);
         cout << "O's turn:";
         GetMove(rowVal, colVal);
         turns = MoveIsValid(board, row, col);
      }
      board[row][col] = -1;
      counter++;
   }
   PrintBoard(board);
   system("Pause");
}

void PrintBoard(char board[3][3]) {
   cout << "+ " << "  " << "0 "<< "  " << "1 " << "  " << "2 " << endl;
   for (int i = 0; i < 3; i++) {
      cout << i;
      for (int j = 0; j < 3; j++){
         cout << " | " << checkReturn(board[i][j]);
      }
      cout << " | " << endl;
   }
}
char checkReturn(char boardValue) {
   if (boardValue == 1)
      return 'X';
   else if (boardValue == -1)
      return 'O';
   else return '.';
}
void GetMove(int *row, int *col) {
   cin >> *row;
   cin.ignore(1, ',');
   cin >> *col;
}
bool MoveIsValid(char board[3][3], int row, int col) {
   if ((row < 3 && row >= 0) && (col < 3 && col >= 0))
   {
      if (board[row][col] == 0)
         return true;
      else {
         cout << "You can't do that!" << endl;
         return false;
      }
   }
   else {
      cout << "You can't do that!" << endl;
      return false;
   }
}