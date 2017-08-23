#include <iostream>
#include <string>
#include "Rational.h"
using namespace std;
Rational::Rational() {
   SetNumerator(0);
   SetDenominator(1);
}
Rational::Rational(const Rational &copy) {
   mNumerator = copy.mNumerator;
   mDenominator = copy.mDenominator;
}
Rational::Rational(int Numerator, int Denominator) {
   mNumerator = Numerator;
   mDenominator = Denominator;
}
double Rational::actualValue() {
   return (double)mNumerator / mDenominator;
}
int Rational::GetNumerator() const {
   return mNumerator;
}
void Rational::SetNumerator(int numerator) {
   mNumerator = numerator;
}

int Rational::GetDenominator() const {
   return mDenominator;
}
void Rational::SetDenominator(int denominator) {
   mDenominator = denominator;
   Normalize();
}

int Rational::GCD(int top, int bot) {
   if (bot == 0)
      return top;
   else
      return GCD(bot, top%bot);
}
void Rational::Normalize() {
   int gcd = GCD(mNumerator, mDenominator);
   mNumerator = mNumerator / gcd;
   mDenominator = mDenominator / gcd;
   if ((mNumerator < 0 || mNumerator>0) && mDenominator < 0) {
      mNumerator *= -1;
      mDenominator *= -1;
   }
}
bool Rational::Equals(const Rational &other) const {
   if (mNumerator == other.mNumerator){
      if (mDenominator == other.mDenominator)
         return true;
   }
   return false;
}
const string Rational::ToString() const {
   string temp;
   if (mDenominator == 0 || mDenominator == 1)
      return temp = to_string(mNumerator);
   else
      temp = to_string(mNumerator) + "/" + to_string(mDenominator);
   return temp;
}
Rational Rational::Add(const Rational &other) const {
   int tempNumerator = mNumerator * other.mDenominator +
      other.mNumerator * mDenominator;
   int tempDenominator = other.mDenominator * mDenominator;
   Rational temp(tempNumerator, tempDenominator);
   temp.Normalize();
   return temp;
}
Rational operator-(Rational &rhs) {
   int numerator = rhs.mNumerator * -1;
   int denominator = rhs.mDenominator;
   return Rational(numerator, denominator);
}
Rational operator-(const Rational &lhs, const Rational &rhs) {
   int tempNumerator = lhs.mNumerator * rhs.mDenominator -
      rhs.mNumerator * lhs.mDenominator;
   int tempDenominator = lhs.mDenominator * rhs.mDenominator;
   Rational temp(tempNumerator, tempDenominator);
   temp.Normalize();
   return temp;
}
Rational operator+(const Rational &lhs, const Rational &rhs) {
   Rational temp = lhs.Add(rhs);
   return lhs.Add(rhs); lhs.Add(rhs);
}
Rational operator*(const Rational &lhs, const Rational &rhs) {
   Rational newRational(lhs.mNumerator*rhs.mNumerator,
      lhs.mDenominator*rhs.mDenominator);
   newRational.Normalize();
   return newRational;
}
Rational operator/(const Rational &lhs, const Rational &rhs) {
   int tempNumerator, tempDenominator;
   tempNumerator = lhs.mNumerator*rhs.mDenominator;
   tempDenominator = lhs.mDenominator*rhs.mNumerator;
   Rational newRational(tempNumerator, tempDenominator);
   newRational.Normalize();
   return newRational;
}
Rational Rational::operator=(const Rational &rhs) {
   mNumerator = rhs.mNumerator;
   mDenominator = rhs.mDenominator;
   return *this;
}
bool operator==(const Rational &lhs, const Rational &rhs) {
   return lhs.Equals(rhs);
}
const bool operator!=(const Rational &lhs, const Rational &rhs) {
   bool temp;
   return temp = !(lhs == rhs);
}
const bool operator<(const Rational &lhs, const Rational &rhs) {
   int rightNumerator, leftNumerator;
   leftNumerator = lhs.mNumerator*rhs.mDenominator;
   rightNumerator = rhs.mNumerator*lhs.mDenominator;
   return (leftNumerator < rightNumerator);
}
const bool operator<=(const Rational &lhs, const Rational &rhs) {
   int rightNumerator, leftNumerator;
   leftNumerator = lhs.mNumerator*rhs.mDenominator;
   rightNumerator = rhs.mNumerator*lhs.mDenominator;
   return (leftNumerator <= rightNumerator);
}
const bool operator>(const Rational &lhs, const Rational &rhs) {
   int rightNumerator, leftNumerator;
   leftNumerator = lhs.mNumerator*rhs.mDenominator;
   rightNumerator = rhs.mNumerator*lhs.mDenominator;
   return (leftNumerator > rightNumerator);
}
const bool operator>=(const Rational &lhs, const Rational &rhs) {
   int rightNumerator, leftNumerator;
   bool value;
   leftNumerator = lhs.mNumerator*rhs.mDenominator;
   rightNumerator = rhs.mNumerator*lhs.mDenominator;
   return (leftNumerator >= rightNumerator);
}
ostream &operator<<(ostream &lhs, const Rational &rhs) {
   lhs << rhs.mNumerator << "/" << rhs.mDenominator;
   return lhs;
}