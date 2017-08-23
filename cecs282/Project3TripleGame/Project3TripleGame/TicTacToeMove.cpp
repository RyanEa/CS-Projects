#include "TicTacToeMove.h"
//#include "GameMove.h"
#include <sstream>
#include <string>
TicTacToeMove::TicTacToeMove() {
   mRow = -1;
   mCol = -1;
}
/*
2-parameter constructor: initializes this move with the given
row and column.
*/
TicTacToeMove::TicTacToeMove(int row, int col) {
   mRow = row;
   mCol = col;
}

GameMove& TicTacToeMove::operator=(const std::string &rhs) {
   std::istringstream moveInputs(rhs);
   if (rhs != "pass"){
      char dummy;
      moveInputs >> dummy >> mRow >> dummy >> mCol >> dummy;
      return *this;
   }
   else
      return *this;
}
bool TicTacToeMove::Equals(const GameMove &other) const {
   const TicTacToeMove &m = dynamic_cast<const TicTacToeMove &>(other);
   if ((this->mRow == m.mRow) && (this->mCol == m.mCol))
      return true;
   return false;
}

TicTacToeMove::operator std::string() const {
   std::ostringstream tostrings;
   tostrings << "(" << mRow << "," << mCol << ")";
   return tostrings.str();
}
