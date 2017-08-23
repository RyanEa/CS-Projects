#include <iostream>
#include <string>
using namespace std;
#include "Date.h"
int main(int argc, char* argv[]) {
   Date one(12, 5, 2015);
   Date two(42, 2, 2012);
   one.DisplayDate();
   two.DisplayDate();
   system("pause");
}