#include "Bil3.h"
#include "Person.h"
#include <iostream>

int main() {
  Bil3 *bilen = new Bil3("123");
  Person *personen = new Person(bilen);
  
  personen->skrivBilNummer();

  delete bilen; bilen = nullptr;
  delete personen; personen = nullptr;

  Bil3 bil2 = Bil3("123");
  Person person2 = Person(&bil2);
  
  return 0;
}
