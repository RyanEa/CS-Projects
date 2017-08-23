#include <iostream>
#include "BeRational.h"
using namespace std;

int main() {
   BeRational r1;
   BeRational r2(5, 12);
   cout<<(++r2).ToString();
   cout<<r2.ToString()<<endl;
   cout << r2.actualValue()<<endl;
   r1.SetNumerator(48);
   r1.SetDenominator(36);
   cout << r1.ToString()<<endl;
   cout << r2.ToString()<<endl;
   cout << r1.Equals(r2)<<"=Nope" << endl;
   cout <<(r1.Add(r2).ToString()) << endl;
   system("pause");
}