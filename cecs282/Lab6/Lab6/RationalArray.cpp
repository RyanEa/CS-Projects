#include <iostream>
#include <string>
#include "Rational.h"
#include "RationalArray.h"
using namespace std;

// Construct an array with the specified size, which is not known until
// runtime. 
RationalArray::RationalArray(int size) {
   mSize = size;
   mArray = new Rational[mSize];
}

// Destructor: clean up any memory placed on the heap by this object.
RationalArray::~RationalArray() {
   delete[] mArray;
   mArray = nullptr;
}

// Copy constructor: make a deep copy of the parameter's array.
RationalArray::RationalArray(const RationalArray &other) {
   mSize = other.mSize;
   mArray = new Rational[other.Size()];
   for (int i = 0; i < other.mSize; i++) {
      mArray[i] = other.mArray[i];
   }
}

// Assignment operator: make a deep copy of the rhs parameter. This will 
// override any array currently held by this object; do not leak the old
// array!
RationalArray& RationalArray::operator=(const RationalArray& rhs) {
   if (mSize < rhs.mSize){
      delete[] mArray;
      mArray = new Rational[rhs.mSize];
   }
   mSize = rhs.mSize;
   for (int i = 0; i < rhs.mSize; i++) {
      mArray[i] = rhs.mArray[i];
   }
   return *this;
}

// Indexing operator: given an index, return the value at that index in 
// mArray. Should throw std::out_of_range from <stdexcept> if the rhs index
// is not in bounds of the array.
Rational& RationalArray::operator[](int rhs) {
   if (rhs > mSize - 1){
      throw std::out_of_range("Number out of range");
   }
   return mArray[rhs];
}

