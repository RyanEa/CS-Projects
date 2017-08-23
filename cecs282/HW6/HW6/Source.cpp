#include <array>
#include <iostream>

//using namespace std;

int main() {
   std::array<int, 10> a1{ { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };//A
   a1.at(2) = 100;//B
   std::cout << a1.at(2)<<std::endl;
   std::array<std::array<int, 8>, 8 > a2;//C
   std::array<std::array<int, 4>, 4> a3 = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {10,11,12} } };
   std::cout<<(a3.at(3)).at(2)<<std::endl;//D
   //E: False
   //F: C-style arrays don't know it's own size unlike std::arrays
   system("pause");
}