#ifndef __TICTACTOEBOARD_H
#define __TICTACTOEBOARD_H

#include <vector>
#include "TicTacToeMove.h"
#include "GameBoard.h"
#include "GameMove.h"

const int TBOARD_SIZE = 3;
const int CENTER = 1;
/*
An OthelloBoard encapsulates data needed to represent a single game of Othello.
This includes the state of the board, tracking the current player, and keeping
a history of moves on the board.
*/
class TicTacToeBoard : public GameBoard {

public:
   enum Player { EMPTY = 0, BLACK = 1, WHITE = -1 };

   TicTacToeBoard();
   bool IsWon() const;
   virtual void GetPossibleMoves(std::vector<GameMove *> *list) const;

   virtual void ApplyMove(GameMove *move);

   virtual void UndoLastMove();

   virtual GameMove *CreateMove() const { return new TicTacToeMove(); }
   virtual std::string GetPlayerString(char player) {
      return (player == 'X') ? "X" : "O";
   }
   virtual std::string SwitchPlayer(std::string player) {
      return (player == "X") ? "O" : "X";
   }
   inline static bool InBounds(int row, int col) {
      return row >= 0 && row < TBOARD_SIZE && col >= 0 && col < TBOARD_SIZE;
   }
   // Returns true if the game is finished.
   virtual bool IsFinished() const {
      return IsWon()||mMoveCount==9;
   }
private:
   friend class TicTacToeView;

   // NOTE: we inherit mNextPlayer, mValue, and mHistory from GameBoard.
   char mBoard[TBOARD_SIZE][TBOARD_SIZE];
   int mMoveCount;
};
#endif