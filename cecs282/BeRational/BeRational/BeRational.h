#ifndef __BERATIONAL_H
#define __BERATIONAL_H

#include <string>

class BeRational {
private:
   int mNumerator;
   int mDenominator;

public:
   BeRational();
   BeRational(const int &Numerator, const int &Denominator);
   const int &GetNumerator() const;
   void SetNumerator(const int &numerator);
   const double actualValue();
   const int &GetDenominator() const;
   void SetDenominator(const int &denominator);
   const int GCD(int top, int bot);
   const void Normalize();
   const bool Equals(const BeRational &other);
   const std::string ToString() const;
   BeRational Add(const BeRational &other);

   friend BeRational &operator++(BeRational &rhs);
   friend BeRational &operator++(BeRational &lhs, int zero);
};

#endif