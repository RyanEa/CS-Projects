#include <iostream>

using namespace std;
class Animal {
public:
   Animal() { cout << "Constuct Animal" << endl; }
   virtual ~Animal() { cout << "Destruct Animal" << endl; }
   virtual void Speak() = 0;
};

class Dog : public Animal {
public:
   Dog() :Animal() { cout << "Construct Dog" << endl; }
   virtual ~Dog() { cout << "Destruct DOg" << endl; }
   virtual void Speak() { cout << "Meow" << endl; }
   void Beg() { cout << "Feed me!" << endl; }
};

class Cat : public Animal {
public:
   Cat() : Animal() { cout << "Construct Cat" << endl; }
   virtual ~Cat() { cout << "Destruct Cat" << endl; }
   virtual void Speak() { cout << "Woof" << endl; }
};

int main() {
   Animal *a = new Cat();
   a->Speak();
   delete a;
   Animal *ptr = new Dog();
   ((Dog*)ptr)->Beg();
   system("pause");
}