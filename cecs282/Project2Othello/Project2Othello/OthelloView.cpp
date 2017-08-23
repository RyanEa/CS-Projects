#include "OthelloBoard.h"
#include "OthelloView.h"
#include <iostream>
using namespace std;

std::ostream& operator<< (std::ostream &lhs, const OthelloView &rhs){
   rhs.PrintBoard(lhs);
   return lhs;
}
void OthelloView::PrintBoard(std::ostream &lhs) const { 
      lhs << "+ 0 1 2 3 4 5 6 7" << endl;
   for (int a = 0; a < BOARD_SIZE; a++){
      lhs << a << " ";
      for (int b = 0; b < BOARD_SIZE; b++){
         if (mOthelloBoard->mBoard[a][b] == 1)
            lhs << "B ";
         if (mOthelloBoard->mBoard[a][b] == -1)
            lhs << "W ";
         if (mOthelloBoard->mBoard[a][b] == 0)
            lhs << ". ";
      }
      lhs << endl;
   }
}