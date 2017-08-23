#include <iostream>
#include "Rational.h"

using namespace std;
void equalityTest(Rational, Rational);
int main() {
   Rational r1(7, 21);
   Rational r2(r1);
   cout << r1 << " <-Rational R1 " << r2 << " <-Rational R2 copy of r1 " << endl;
   r1.SetNumerator(5);
   cout << r1 << "<-Changed Rational R1" << r2 << "<-Rational R2" << endl;
   cout << r1 <<" negation is " << -r1 << endl;
   cout << (r2 = r1) <<" sets r2=r1 "<<endl;
   r1.SetNumerator(9);
   r1.SetDenominator(22);
   cout << "R1 changed to " << r1 <<" while r2 is "<< r2 << endl;
   cout << r1 << " + " << r2 << "=" << (r1 + r2) << endl;
   cout << r1 << "-" << r2 << "=" << (r1 - r2) << endl;
   cout << r1 << "*" << r2 << "=" << (r1*r2) << endl;
   cout << r1 << "/" << r2 << "=" << (r1/r2) << endl;
   cout << "Equality Tests" << endl;
   cout << r1 << "     " << r2 << endl;
   equalityTest(r1, r2);
   r1.SetNumerator(2);
   r1.SetDenominator(5);
   r2.SetNumerator(6);
   r2.SetDenominator(5);
   cout << r1 << "     " << r2 << endl;
   equalityTest(r1, r2);
   r1.SetNumerator(42);
   r1.SetDenominator(31);
   r2.SetNumerator(42);
   r2.SetDenominator(31);
   cout << r1 << "     " << r2 << endl;
   equalityTest(r1, r2);
   system("pause");
}

void equalityTest(Rational r1, Rational r2) {
   cout << ((r1 == r2) ? "Yes, r1==r2" : "No r1!=r2, test for != next line")
      << endl;
   cout << ((r1 != r2) ? "Yes, r1!=r2" : "No, r1==r2") << endl;
   cout << ((r1 < r2) ? "Yes, r1<r2" : "No") << endl;
   cout << ((r1 <= r2) ? "Yes, r1<=r2" : "No") << endl;
   cout << ((r1 > r2) ? "Yes, r1>r2" : "No") << endl;
   cout << ((r1 >= r2) ? "Yes, r1>=r2" : "No") << endl;
}