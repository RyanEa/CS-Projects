#include "GameMove.h"
#include "OthelloMove.h"
#include <sstream>
#include <string>
// KEEP THESE CONSTRUCTORS PRIVATE.
// Default constructor: initializes this move as a PASS.
OthelloMove::OthelloMove() {
   mRow = -1;
   mCol = -1;
}
/*
2-parameter constructor: initializes this move with the given
row and column.
*/
OthelloMove::OthelloMove(int row, int col) {
   mRow = row;
   mCol = col;
}


/*
This assignment operator takes a string representation of an Othellomove
and uses it to initialize the move. The string is in the format
(r, c); OR is the string "pass". [The user will not enter (-1,-1) to pass
anymore.]
*/
GameMove& OthelloMove::operator=(const std::string &rhs) {
   std::istringstream moveInputs(rhs);
   if (rhs != "pass"){
      char dummy;
      moveInputs >> dummy >> mRow >> dummy >> mCol >> dummy;
      return *this;
   }
   else
      return *this;
}

/*
Compares two OthelloMove objects for equality.
*/
bool OthelloMove::Equals(const GameMove &other) const {
   const OthelloMove &m = dynamic_cast<const OthelloMove &>(other);
   if ((this->mRow == m.mRow) && (this->mCol == m.mCol))
      return true;
   return false;
} 

// Converts the OthelloMove into a string representation, one that could be
// used correctly with operator=(string). Returns "pass" if move is a pass.
OthelloMove::operator std::string() const {
   std::ostringstream tostrings;
   tostrings << "(" << mRow << "," << mCol << ")";
   if (mRow == -1 || mCol == -1){
      tostrings << "pass";
      return tostrings.str();
   }
   return tostrings.str();
}
