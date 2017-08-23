#include <iostream>
#include <random>
#include <cmath>
#include <iomanip>
using namespace std;
void angleIntput(double &);
void powderInput(double &);
int main(int argc, char* argv[]){
   int seed;
   double gunpowder, angle, xVel, travelDistance, target, difference;
   bool win=true;
   const double GVELOCITY = 30;
   const double GRAVITY = 9.8;
   const double PI = 3.141592653589793238463;
   const int MAXDISTANCE = 1000;
   double &gref = gunpowder;
   double &angleref = angle;
   cout << "Enter a positive seed." << setprecision(2) << fixed << endl;
   cin >> seed;
   while (seed <= 0){
      cout << "Enter a positive seed." << endl;
      cin >> seed;
   }
   default_random_engine engine(seed);
   uniform_real_distribution<double> distr(1, MAXDISTANCE);
   target = distr(engine);
   cout << "The target is " << target << "away." << endl;
   while(win){
      angleIntput(angleref);
      powderInput(gref);
      xVel = gunpowder * GVELOCITY;
      travelDistance = (xVel*xVel*sin(2 * PI * (angle / 180)) / GRAVITY);
      difference = target - travelDistance;
      if (difference <= 1 && difference >= -1){
         cout << "It's a hit!";
         win = false;
      }
      else{
         win = true;
         cout << "You were off by " << abs(difference) << endl;
      }
   } 
}
void angleIntput(double &angle){
   cout << "Enter an angle from 0-90" << endl;
   cin >> angle;
   while (angle > 90 || angle < 0){
      cout << "Enter again." << endl;
      cin >> angle;
   }
}
void powderInput(double &gunpowder){
   cout << "Enter amount of gunpowder to use" << endl;
   cin >> gunpowder;
   while (gunpowder < 0){
      cout << "Enter gunpowder again." << endl;
      cin >> gunpowder;
   }
}