#include "ConnectFourBoard.h"
#include "ConnectFourMove.h"
// Default constructor initializes the board to its starting "new game" state   
int ConnectFourMove::mOnHeap = 0;
ConnectFourBoard::ConnectFourBoard()
   :mMoveCount(0) {
   mNextPlayer = 'Y';
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
void ConnectFourBoard::GetPossibleMoves(std::vector<GameMove *> *list) const {
      for (int y = 0; y < C4WIDTH; y++)
         if (mBoard[0][y] == 0) {
            ConnectFourMove *move = new ConnectFourMove(y);
            list->push_back(move);
         }
}

/*
Applies a valid move to the board, updating the board state accordingly.
You may assume that this move is valid, and is consistent with the list
of possible moves returned by GetAllMoves.
*/
void ConnectFourBoard::ApplyMove(GameMove *move) {
   ConnectFourMove *p = dynamic_cast<ConnectFourMove*>(move);
   int col = p->mCol;
   bool isAdded = false;
   while (!isAdded){
      for (int y = C4HEIGHT-1; y > -1; y--)
         if (mBoard[y][col] == 0){
            mBoard[y][col] = (mNextPlayer == 'Y') ? -1 : 1;
            isAdded = true;
            break;
         }
   }
   mMoveCount++;
   mHistory.push_back(move);
   mValue = (mNextPlayer == 'Y') ? mValue+1 : mValue-1;
   mNextPlayer = (mNextPlayer == 'Y') ? 'R' : 'Y';
   if (isWon())
      mValue = -1;
   }

/*
Undoes the last move applied to the board, restoring it to the state it was
in prior to the most recent move.
*/
void ConnectFourBoard::UndoLastMove() {
   GameMove* move = GetMoveHistory()->back();
   ConnectFourMove *p = dynamic_cast<ConnectFourMove*>(move);
   int col = p->mCol;
   for (int x = 0; x < C4HEIGHT; x++){
      if (mBoard[x][col] != 0){
         mBoard[x][col] = 0;
         break;
      }
   }
   mValue = (mNextPlayer == 'Y')
      ? mValue - 1 : mValue + 1;
   mMoveCount--;
   mHistory.pop_back();
   delete move;
   mNextPlayer = (mNextPlayer == 'Y') ? 'R' : 'Y';
}
bool ConnectFourBoard::isWon() const {
   for (int row = 0; row < C4HEIGHT; row++) {
      for (int col = 0; col < C4WIDTH; col++) {
         for (int y = 1; y >= -1; y--) {
            for (int x = -1; x <= 1; x++) {
               int count = 1, n = 1;
               while (InBounds(row + n*y, col + n*x) && mBoard[row][col] != 0){
                  if (mBoard[row][col] == mBoard[row + n*y][col + n*x]){
                     if (n*y == 0 && n*x == 0){
                        count = 1;
                        break;
                     }
                     n++;
                     count++;
                     if (count == 4 && InBounds((row+n*y), (col+n*x)))
                        return true;
                  }
                  else break;
               }
            }
         }
      }
   }
   return false;
}