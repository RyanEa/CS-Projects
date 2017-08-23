#include <algorithm>
#include <iostream>
#include <vector>
#include <string>
#include <fstream>
using namespace std;
int main() {
   string strings = "omn,ip,o,tato";
   cout << strings.at(3) << endl;//retrieve char at index 3
   string substrs = strings.substr(2, 4);//substring
   cout << substrs<<endl;
   cout<<strings.length()<<endl;//size
   cout << strings.size() << endl;//size
   reverse(strings.begin(), strings.end());
   cout << strings<<endl;
   replace(strings.begin(),strings.end(),',', '+');
   cout << strings << endl;
   ifstream openfile("numbers.txt");
   double temp,total = 0.0, average, count = 0.0;
   while (!openfile.eof){
      openfile >> temp;
      total += temp;
      count++;
   }
   average = total / count;
   ofstream outputfile("output.txt");
   Rational temp = Rational(1, 3);
   outputfile << temp;
   outputfile.close();
   openfile.close();
   system("pause");
}