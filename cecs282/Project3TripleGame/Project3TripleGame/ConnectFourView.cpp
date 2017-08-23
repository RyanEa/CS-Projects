#include "ConnectFourView.h"

void ConnectFourView::PrintBoard(std::ostream &s) const {
   s << "+ 0 1 2 3 4 5 6" << std::endl;
   for (int a = 0; a < C4HEIGHT; a++){
      s << a << " ";
      for (int b = 0; b < C4WIDTH; b++){
         if (mConnectFourBoard->mBoard[a][b] == 1)
            s << "R ";
         if (mConnectFourBoard->mBoard[a][b] == -1)
            s << "Y ";
         if (mConnectFourBoard->mBoard[a][b] == 0)
            s << ". ";
      }
      s << std::endl;
   }
}