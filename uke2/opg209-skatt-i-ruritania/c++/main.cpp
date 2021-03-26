#include <iostream>

const static int SKATTEGRENSE = 10000;
const static double SKATTLESS = 0.1;
const static double SKATTMORE = 0.2;

int main() {
  std::cout << "Hvor mye tjener du?" << std::endl;
  int pengerTjent;

  std::cin >> pengerTjent;

  pengerTjent < SKATTEGRENSE ?
		(std::cout << "Du må betale " << pengerTjent*SKATTLESS << " kr i skatt." << std::endl)
    :
    (std::cout << "Du må betale " << pengerTjent*SKATTMORE << " kr i skatt." << std::endl);
  
  return 0;
}
