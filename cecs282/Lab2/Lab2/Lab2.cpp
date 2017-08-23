#include <iostream>
#include <random>
#include <cmath>
#include <iomanip>
using namespace std;
double doubleinputs(double &, double &);
int main(int argc, char* argv[]){
   int seed;
   double gunpowder, angle, xVel, travelDistance, target, difference;
   bool win;
   const double GRAVITY = 9.8;
   const double PI = 3.141592653589793238463;
   const int THOUSAND = 1000;
   cout << "Enter a positive seed."<<setprecision(2)<<fixed<<endl;
   cin >> seed;
   while (seed <= 0){
      cout << "Enter a positive seed."<<endl;
      cin >> seed;
   }
   //default_random_engine engine(seed);
   uniform_real_distribution<double> distr(1, THOUSAND);
   target = distr(seed);
   cout << "The target is " << target << "away." << endl;
   do{
      doubleinputs(angle, gunpowder);
      xVel = gunpowder * 30;
      travelDistance = (xVel*xVel*sin(2 * PI * (angle / 180)) / GRAVITY);
      difference = target - travelDistance;
      if (target - travelDistance <= 1 && target - travelDistance >= -1){
         cout << "It's a hit!";
         win = true;
      }
      else
            cout << "You were off by" << abs(difference) << endl;
   }while(win);
}
double doubleinputs(double &anAngle, double &powder){
   cout << "Enter an angle from 0-90" << endl;
   cin >> anAngle;
   while (anAngle > 90 || anAngle < 0){
      cout << "Enter again." << endl;
      cin >> anAngle;
   }
      cout << "Enter amount of gunpowder to use" << endl;
      cin >> powder;
      while (powder < 0){
         cout << "Enter gunpowder again." << endl;
         cin >> powder;
      }
   }