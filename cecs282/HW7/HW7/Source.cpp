#include <sstream>
#include <string>
#include <iostream>
using namespace std;
int main() {
   std::string s = "100 200 300";
   int a, b, c;
   istringstream is (s);
   is >> a;
   is >> b;
   is >> c;
   ostringstream os;
    //os << a << " | " << b << " | " << c << endl;
    //cout << a << " - " << b << " - " << c << endl;
   os << s;
    cout << os.str() << endl;
    system("pause");
}