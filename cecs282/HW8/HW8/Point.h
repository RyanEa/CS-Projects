#ifndef POINT_H
#define POINT_H
//using namespace std;
class Point {
public:
   int x;
   int y;
   friend double operator-(const Point &lhs, const Point &rhs);
   Point(const int a, const int b);
};
 
#endif