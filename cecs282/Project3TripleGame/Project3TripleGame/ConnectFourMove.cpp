#include "ConnectFourMove.h"
#include "GameMove.h"
#include <sstream>
#include <string>
ConnectFourMove::ConnectFourMove() {
   mCol = -1;
}
ConnectFourMove::ConnectFourMove(int col) {
   mCol = col;
}


/*
This assignment operator takes a string representation of an Othellomove
and uses it to initialize the move. The string is in the format
(r, c); OR is the string "pass". [The user will not enter (-1,-1) to pass
anymore.]
*/
GameMove& ConnectFourMove::operator=(const std::string &rhs) {
   std::istringstream moveInputs(rhs);
      char dummy;
      moveInputs >> dummy >> mCol >> dummy;
      return *this;
}

bool ConnectFourMove::Equals(const GameMove &other) const {
   const ConnectFourMove &m = dynamic_cast<const ConnectFourMove &>(other);
   if (this->mCol == m.mCol)
      return true;
   return false;
}

ConnectFourMove::operator std::string() const {
   std::ostringstream tostrings;
   tostrings << "(" << mCol << ")";
   return tostrings.str();
}
