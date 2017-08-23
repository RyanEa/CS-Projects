#include <iostream>
#include <string>
#include "BeRational.h"
using namespace std;
BeRational::BeRational() {
   SetNumerator(0);
   SetDenominator(1);
}
BeRational::BeRational(const int &Numerator, const int &Denominator) {
   mNumerator = Numerator;
   mDenominator = Denominator;
}
const double BeRational::actualValue() {
   return (double)mNumerator / mDenominator;
}
const int &BeRational::GetNumerator() const {
   return mNumerator;
}
void BeRational::SetNumerator(const int &numerator) {
   mNumerator = numerator;
   Normalize();
}

const int &BeRational::GetDenominator() const {
   return mDenominator;
}
void BeRational::SetDenominator(const int &denominator) {
   mDenominator = denominator;
   Normalize();
}

const int BeRational::GCD(int top, int bot) {
   if (bot == 0)
      return top;
   else
      return GCD(bot, top%bot);
}
const void BeRational::Normalize() {
   if ((mNumerator < 0 || mNumerator>0) && mDenominator < 0) {
      mNumerator *= -1;
      mDenominator *= -1;
   }
   int gcd = GCD(mNumerator, mDenominator);
   mNumerator = mNumerator / gcd;
   mDenominator = mDenominator / gcd;
}
const bool BeRational::Equals(const BeRational &other) {
   if (mNumerator == other.mNumerator){
      if (mDenominator == other.mDenominator)
         return true;
   }
   return false;
}
const string BeRational::ToString() const{
   string temp;
   if (mDenominator == 0 || mDenominator == 1)
      return temp = to_string(mNumerator);
   else
      temp = to_string(mNumerator) + "/" + to_string(mDenominator);
   return temp;
}
BeRational BeRational::Add(const BeRational &other) {
   int tempNumerator = mNumerator * other.mDenominator +
      other.mNumerator * mDenominator;
   int tempDenominator = other.mDenominator * mDenominator;
   BeRational temp(tempNumerator, tempDenominator);
   temp.Normalize();
   return temp;
}

BeRational &operator++(BeRational &rhs) {
   rhs.mNumerator = rhs.mNumerator + rhs.mDenominator; //Increments total value by 1/1
   return rhs;
}

BeRational &operator++(BeRational &lhs, int zero) {
   BeRational current = lhs;
   lhs.mNumerator = lhs.mNumerator + lhs.mDenominator;//Increments total value by 1/1
   return current;
}
