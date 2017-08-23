#include <iostream>
#include "OthelloGame.h"
using namespace std;
void PrintBoard(char board[BOARD_SIZE][BOARD_SIZE]) {
   cout << "+ 0 1 2 3 4 5 6 7" << endl;
   for (int a = 0; a < BOARD_SIZE; a++){
      cout << a<<" ";
      for (int b = 0; b < BOARD_SIZE; b++){
         if (board[a][b] == 1)
            cout << "B ";
         if (board[a][b] == -1)
            cout << "W ";
         if (board[a][b] == 0)
            cout << ". ";
      }
      cout << endl;
   }
}
bool InBounds(int row, int col) {
   return (row < BOARD_SIZE && row >=0 && 
      col < BOARD_SIZE && col >= 0) ? true : false;
}
bool IsValidMove(char board[BOARD_SIZE][BOARD_SIZE], int row, int col) {
   return (InBounds(row, col) && board[row][col] 
      == 0 || row == -1 && col == -1) ? true : false;
}
void GetMove(int *row, int *col) {
   char d;
   cin >> d >> *row >> d >> *col >> d; 
}
void ApplyMove(char board[BOARD_SIZE][BOARD_SIZE], int row, int col,
   char currentPlayer) {
   board[row][col] = (currentPlayer == 'B') ? 1 : -1;
   for (int y = 1; y >= -1; y--) {
      for (int x = -1; x <= 1; x++) {
         int n = 1, count = 0;
         while (InBounds((row + n*y), (col + n * x)) && board[row + n*y]
            [col + n*x] != 0 && (x != 0 || y != 0)) {
            count = (currentPlayer == 'W' && board[row + n*y][col + n*x]
               == 1) ? ++count : count;
            count = (currentPlayer == 'B' && board[row + n*y][col + n*x]
               == -1) ? ++count : count;
            n = (count > 0) ? ++n : n;
            if (board[row][col] == board[row + n*y][col + n*x]){
               break;
            }
            if (board[row + n*y][col + n*x] == 0 ||
               !InBounds((row + n*y), (col + n * x))) {
               count = 0;
               break;
            }
         }
         while (count-- > 0 && --n > 0){
            board[row + n*y][col + n*x] = (currentPlayer == 'W') ? -1 :
               (currentPlayer == 'B') ? 1 : board[row + n*y][col + n*x];
         }
      }
   }
}
int GetValue(char board[BOARD_SIZE][BOARD_SIZE]) {
   int value = 0;
   for (int x = 0; x < BOARD_SIZE*BOARD_SIZE; x++) {
      (board[0][x] == 1) ? value++ : value;
      (board[0][x] == -1) ? value-- : value;
   }
   return value;
}
