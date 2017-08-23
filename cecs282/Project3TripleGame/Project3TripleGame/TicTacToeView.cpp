#include "TicTacToeView.h"

void TicTacToeView::PrintBoard(std::ostream &s) const {
   s << "+ 0 1 2" << std::endl;
   for (int a = 0; a < TBOARD_SIZE; a++){
      s << a << " ";
      for (int b = 0; b < TBOARD_SIZE; b++){
         if (mTicTacToeBoard->mBoard[a][b] == 1)
            s << "X ";
         if (mTicTacToeBoard->mBoard[a][b] == -1)
            s << "O ";
         if (mTicTacToeBoard->mBoard[a][b] == 0)
            s << ". ";
      }
      s << std::endl;
   }
}