#include "OthelloMove.h"
#include <sstream>
#include <string>
#include <iostream>
int OthelloMove::mOnHeap = 0;
// KEEP THESE CONSTRUCTORS PRIVATE.
// Default constructor: initializes this move as a PASS.
OthelloMove::OthelloMove()
:mRow(-1),mCol(-1){
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
OthelloMove& OthelloMove::operator=(const std::string &rhs) {
   OthelloMove temp;
   if (rhs == "pass"){  
   }
   else{
      std::istringstream moveInputs(rhs);
      char dummy;
      moveInputs >> dummy >> mRow >> dummy >> mCol >> dummy;
      return temp=OthelloMove(mRow, mCol);
   }
   return temp=OthelloMove();
}
/*
Compares two OthelloMove objects for equality (if rows and cols are same).
*/
bool operator==(const OthelloMove &lhs, const OthelloMove &rhs) {
   if (lhs.mCol == rhs.mCol && lhs.mRow == rhs.mRow)
      return true;
   else return false;
}

/*
Converts the OthelloMove into a string representation, one that could be
used correctly with operator=(string). Returns "pass" if move is a pass.
*/
OthelloMove::operator std::string() const {
   if (mRow == -1 || mCol == -1)
      return "pass";
   std::ostringstream temp;
   temp << "(" << mRow << "," << mCol << ")";
   return temp.str();
}