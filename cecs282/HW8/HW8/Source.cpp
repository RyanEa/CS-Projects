#include <iostream>
#include "Point.h"
using namespace std;

int main() {
   Point a(-1, 2);
   Point b(-3, -2);
   double temp = a - b;
   cout << temp << endl;
   system("pause");
}