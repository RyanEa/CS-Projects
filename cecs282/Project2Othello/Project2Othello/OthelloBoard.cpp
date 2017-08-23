#include "OthelloBoard.h"
#include "OthelloMove.h"
// Default constructor initializes the board to its starting "new game" state
OthelloBoard::OthelloBoard()
   :mPassCount(0){
   const int PRESET = 3;
   mBoard[BOARD_SIZE][BOARD_SIZE] = { EMPTY };
   mBoard[PRESET][PRESET] = WHITE;
   mBoard[PRESET+1][PRESET+1] = WHITE;
   mBoard[PRESET][PRESET+1] = BLACK;
   mBoard[PRESET+1][PRESET] = BLACK;
   mNextPlayer = 'B';
}

/*
Fills in a vector with all possible moves on the current board state for
the current player. The moves should be ordered based first on row, then on
column. Example ordering: (0, 5) (0, 7) (1, 0) (2, 0) (2, 2) (7, 7)
If no moves are possible, then a single OthelloMove representing a Pass is
put in the vector.
Any code that calls ApplyMove is responsible for first checking that the
requested move is among the possible moves reported by this function.

Precondition: the vector is empty.
Postcondition: the vector contains all valid moves for the current player.
*/
void OthelloBoard::GetPossibleMoves(std::vector<OthelloMove *> *list) const {
   for (int x = 0; x < BOARD_SIZE; x++){
      for (int y = 0; y < BOARD_SIZE; y++){
         if (mBoard[x][y] == 0){
            bool isAdded = false;
            for (int a = -1; a <=1; a++){
               for (int b = 1; b>=-1; b--){
                  int count=0, s = 1;
                     while (mBoard[x + s*a][y + s*b] != 0
                        && (InBounds((x + s*a), (y + s*b)))){
                        count = (mNextPlayer == 'W' && mBoard[x + s*a][y + s*b]
                           == 1) ? ++count : count;
                        count = (mNextPlayer == 'B' && mBoard[x + s*a][y + s*b]
                           == -1) ? ++count : count;
                        if ((mNextPlayer == 'W' && mBoard[x + s*a][y + s*b] 
                           == -1) || (mNextPlayer == 'B' 
                           &&mBoard[x + s*a][y + s*b] == 1)
                           && InBounds((x + s*a), (y + s*b))){
                           if (count > 0 && !isAdded){
                              OthelloMove *move = new OthelloMove(x, y);
                              list->push_back(move);
                              isAdded = true;
                           }
                        }
                        if (count > 0)
                           s++;
                        else
                           break;
                     }

               }
            }
         }
      }
   }
   if (list->empty()){
      list->push_back(new OthelloMove());
   }
}

/*
Applies a valid move to the board, updating the board state accordingly.
You may assume that this move is valid, and is consistent with the list
of possible moves returned by GetAllMoves. Make sure you account for changes
to the current player, pass count, and board value.
*/
void OthelloBoard::ApplyMove(OthelloMove *move) {
   int row = move->mRow, col = move->mCol;
   if (row != -1 || col != -1){
      mPassCount = 0;
      mBoard[move->mRow][move->mCol] = (mNextPlayer == 'B') ? 1 : -1;
      mValue = (mBoard[row][col] == -1) ? --mValue : ++mValue;
      for (int y = 1; y >= -1; y--) {
         for (int x = -1; x <= 1; x++) {
            int n = 1, count = 0;
            while (mBoard[row + n*y][col + n*x] != 0) {
               count = (mNextPlayer == 'W' && mBoard[row + n*y][col + n*x]
                  == 1) ? ++count : (mNextPlayer == 'B' &&
                  mBoard[row + n*y][col + n*x] == -1) ? ++count : count;
               n = (count > 0) ? ++n : n;
               if (mBoard[row][col] == mBoard[row + n*y][col + n*x]
                  && InBounds((row + n*y), (col + n*x))){
                  break;
               }
               if (mBoard[row + n*y][col + n*x] == 0 ||
                  !InBounds((row + n*y), (col + n * x))) {
                  count = 0;
                  break;
               }
            }
            move->AddFlipSet(OthelloMove::FlipSet(count, y, x));
            while (count-- > 0 && --n > 0){
               mBoard[row + n*y][col + n*x] = (mNextPlayer == 'W') ? -1 :
                  (mNextPlayer == 'B') ? 1 : mBoard[row + n*y][col + n*x];
               mValue = (mBoard[row + n*y][col + n*x] == -1) 
                  ? mValue - 2 : mValue + 2;
            }
         }
      }

   }
   else{
      ++mPassCount;
   }
   mHistory.push_back(move);
   mNextPlayer = (mNextPlayer == 'B') ? 'W' : 'B';
}

/*
Undoes the last move applied to the board, restoring it to the state it was
in prior to the most recent move (including whose turn it is, what the
board value is, and what the pass count is).
*/
void OthelloBoard::UndoLastMove() {
   OthelloMove* move = GetMoveHistory()->back();
   int row = move->mRow;
   int col = move->mCol;
   mBoard[row][col] = 0;
   mValue = (mNextPlayer == 'B') 
      ? mValue+1 : mValue-1;
   if (mPassCount == 1) {
      mPassCount=0;
   }
   for (OthelloMove::FlipSet start : move->mFlips) {
      for (int i = start.switched; i > 0; i--) {
         int x = (start.rowDelta)*i;
         int y = (start.colDelta)*i;
         mBoard[row + x][col + y] = (mBoard[row + x][col + y] == 1) ? -1 : 1;
         mValue = (mBoard[row + x][col + y] == -1)
            ? mValue - 2 : mValue + 2;
      }
   }
   move->mFlips.clear();
   mHistory.pop_back();
   delete move;
   mNextPlayer = (mNextPlayer=='B') ? 'W' : 'B';
}

