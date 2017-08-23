#include "OthelloView.h"

void OthelloView::PrintBoard(std::ostream &s) const {
   s << "+ 0 1 2 3 4 5 6 7" << std::endl;
   for (int a = 0; a < BOARD_SIZE; a++){
      s << a << " ";
      for (int b = 0; b < BOARD_SIZE; b++){
         if (mOthelloBoard->mBoard[a][b] == 1)
            s << "B ";
         if (mOthelloBoard->mBoard[a][b] == -1)
            s << "W ";
         if (mOthelloBoard->mBoard[a][b] == 0)
            s << ". ";
      }
      s << std::endl;
   }
}