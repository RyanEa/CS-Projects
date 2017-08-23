#include <iostream>
#include <random>
using namespace std;

int main(int argc, char* argv[]){
   int chosen, correctDoor;
   random_device rd;
   default_random_engine engine(rd());
   uniform_distribution<int> distr(1, 3);
   char switch;
   cout << "Choose a door from #1,2,or 3.";
   cin >> chosen;
   correctDoor = distr(engine);
   cout << correctDoor;
   if (chosen != 1 && correctDoor != 1)
      cout << "Door #1 is revealed to have a goat";
   else if (chosen != 2 && correctDoor != 2)
      cout << "Door #2 is revealed to have a goat";
   else if (chosen != 3 && correctDoor != 3)
      cout << "Door #3 is revealed to have a goat";
}
