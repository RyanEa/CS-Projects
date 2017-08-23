#ifndef __RATIONAL_H
#define __RATIONAL_H
#include <sstream>
#include <string>

class Rational {
private:
   int mNumerator;
   int mDenominator;

public:
   Rational();
   Rational(const Rational &copy);
   Rational(int Numerator, int Denominator);
   int GetNumerator() const;
   void SetNumerator(int numerator);
   double actualValue();
   int GetDenominator() const;
   void SetDenominator(int denominator);
   int GCD(int top, int bot);
   void Normalize();
   bool Equals(const Rational &other) const;
   const std::string ToString() const;
   Rational Add(const Rational &other) const;
   friend Rational operator-(Rational &rhs);
   friend Rational operator-(const Rational &lhs, const Rational &rhs);
   friend Rational operator+(const Rational &lhs, const Rational &rhs);
   friend Rational operator*(const Rational &lhs, const Rational &rhs);
   friend Rational operator/(const Rational &lhs, const Rational &rhs);
   Rational operator=(const Rational &rhs);
   friend bool operator==(const Rational &lhs, const Rational &rhs);
   friend const bool operator!=(const Rational &lhs, const Rational &rhs);
   friend const bool operator<(const Rational &lhs, const Rational &rhs);
   friend const bool operator<=(const Rational &lhs, const Rational &rhs);
   friend const bool operator>(const Rational &lhs, const Rational &rhs);
   friend const bool operator>=(const Rational &lhs, const Rational &rhs);
   friend std::ostream &operator<<(std::ostream &lhs, const Rational &rhs);
};

#endif