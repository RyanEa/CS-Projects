#include "Point.h"
#include <math.h>
#include <iostream>
using namespace std;

double operator-(const Point &lhs, const Point &rhs) {
   return abs(sqrt(pow(lhs.x - rhs.x, 2) + pow(lhs.y- rhs.y, 2)));
}

Point::Point(const int a, const int b) {
   x = a;
   y = b;
}