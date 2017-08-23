#include "TicTacToeBoard.h"
// Default constructor initializes the board to its starting "new game" state   
TicTacToeBoard::TicTacToeBoard()
   :mMoveCount(0) {
   mNextPlayer = 'X';
}

/*
Fills in a vector with all possible moves on the current board state for
the current player. The moves should be ordered based first on row, then on
column. Example ordering: (0, 5) (0, 7) (1, 0) (2, 0) (2, 2) (7, 7).
If no moves are possible, then a single OthelloMove representing a Pass is
put in the vector.
Precondition: the vector is empty.
Postcondition: the vector contains all valid moves for the current player.
*/
void TicTacToeBoard::GetPossibleMoves(std::vector<GameMove *> *list) const {
   for (int x = 0; x < TBOARD_SIZE; x++)
      for (int y = 0; y < TBOARD_SIZE; y++)
         if (mBoard[x][y] == 0) {
            TicTacToeMove *move = new TicTacToeMove(x, y);
            list->push_back(move);
         }
   if (list->empty()){
      list->push_back(new TicTacToeMove());
   }
}

/*
Applies a valid move to the board, updating the board state accordingly.
You may assume that this move is valid, and is consistent with the list
of possible moves returned by GetAllMoves.
*/
void TicTacToeBoard::ApplyMove(GameMove *move) {
   TicTacToeMove *p = dynamic_cast<TicTacToeMove*>(move);
   int row = p->mRow, col = p->mCol;
   mNextPlayer = (mNextPlayer == 'X') ? 'O' : 'X';
   mBoard[row][col] = (mNextPlayer == 'X') ? 1 : -1;
   mHistory.push_back(move);
   mNextPlayer = (mNextPlayer == 'X') ? 'O' : 'X';
   mMoveCount++;
}

/*
Undoes the last move applied to the board, restoring it to the state it was
in prior to the most recent move.
*/
void TicTacToeBoard::UndoLastMove() {
   GameMove* move = GetMoveHistory()->back();
   TicTacToeMove *p = dynamic_cast<TicTacToeMove*>(move);
   int row = p->mRow;
   int col = p->mCol;
   mBoard[row][col] = 0;
   mValue = (mNextPlayer == 'X')
      ? mValue + 1 : mValue - 1;
   mMoveCount--;
   mHistory.pop_back();
   delete move;
   mNextPlayer = (mNextPlayer == 'X') ? 'O' : 'X';
}
bool TicTacToeBoard::IsWon() const {
   for (int y = -1; y <= 0; y++){
      for (int x = -1; x < 2; x++) {
         if (y < 1) {
            if (mBoard[CENTER + y][CENTER + x] == mBoard[CENTER][CENTER] &&
               mBoard[CENTER - y][CENTER - x] == mBoard[CENTER][CENTER])
               return true;
         }
         if (y == 0)
            if (mBoard[CENTER][CENTER - x] == mBoard[CENTER][CENTER] &&
               mBoard[CENTER - y][CENTER - x] == mBoard[CENTER][CENTER])
               return true;
            else break;
      }
   }
   if (mBoard[CENTER - 1][CENTER - 1] == mBoard[CENTER][CENTER - 1] &&
      mBoard[CENTER + 1][CENTER - 1] == mBoard[CENTER][CENTER - 1])
      return true;
   if (mBoard[CENTER - 1][CENTER + 1] == mBoard[CENTER][CENTER + 1] &&
      mBoard[CENTER + 1][CENTER + 1] == mBoard[CENTER][CENTER + 1])
      return true;
   return false;
}