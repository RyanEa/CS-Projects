#ifndef __CONNECTFOURBOARD_H
#define __CONNECTFOURBOARD_H

#include <vector>
#include "ConnectFourMove.h"
#include "GameBoard.h"
#include "GameMove.h"

const int C4WIDTH = 7;
const int C4HEIGHT = 6;

/*
An OthelloBoard encapsulates data needed to represent a single game of Othello.
This includes the state of the board, tracking the current player, and keeping
a history of moves on the board.
*/
class ConnectFourBoard : public GameBoard {

public:
   ConnectFourBoard();
   virtual void GetPossibleMoves(std::vector<GameMove *> *list) const;
   virtual void ApplyMove(GameMove *move);

   /*
   Undoes the last move applied to the board, restoring it to the state it was
   in prior to the most recent move.
   */
   virtual void UndoLastMove();

   /*
   Creates an OthelloMove object on the heap. Whoever calls this method is
   responsible for managing the move's lifetime (or transferring that task to
   someone else.)
   */
   virtual GameMove *CreateMove() const { return new ConnectFourMove; }
   virtual std::string GetPlayerString(char player) {
      return (player == 'Y') ? "Yellow" : "Red";
   }
   virtual std::string SwitchPlayer(std::string player) {
      return (player == "Yellow") ? "Red" : "Yellow";
   }
   inline static bool InBounds(int row, int col) {
      return row >= 0 && row < C4HEIGHT && col >= 0 && col < C4WIDTH;
   }
   bool isWon() const;
   // Returns true if the game is finished.
   virtual bool IsFinished() const {
      return (isWon()|| mMoveCount==C4HEIGHT*C4WIDTH);
   }

private:
   friend class ConnectFourView;
   char mBoard[C4HEIGHT][C4WIDTH];
   int mMoveCount;
};
#endif