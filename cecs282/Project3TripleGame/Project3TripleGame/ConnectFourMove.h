#ifndef __CONNECTFOURMOVE_H
#define __CONNECTFOURMOVE_H

#include "GameMove.h"
#include <string>
#include <iostream>

class ConnectFourMove : public GameMove {
private:
   friend class ConnectFourBoard;
   int mRow, mCol;
   ConnectFourMove();
   ConnectFourMove(int col);

public:
   static int mOnHeap;
   static void* operator new(std::size_t sz){
      mOnHeap++;
      std::cout << "operator new: " << mOnHeap << " ConnectFourMoves on the heap" << std::endl;
      return ::operator new(sz);
   }

      static void operator delete(void* ptr, std::size_t sz) {
      mOnHeap--;
      std::cout << "operator delete: " << mOnHeap << " ConnectFourMoves on the heap" << std::endl;
      ::operator delete(ptr);
   }
   virtual GameMove& operator=(const std::string &);
   virtual bool Equals(const GameMove &other) const;
   virtual operator std::string() const;
   inline bool IsPass() const { return mRow == -1 && mCol == -1; }
};

#endif