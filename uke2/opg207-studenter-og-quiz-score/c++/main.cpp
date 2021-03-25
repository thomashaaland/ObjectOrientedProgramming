#include "Student.h"
#include <iostream>

int main() {
  Student joakim("Joakim", 10, 24);
  Student kristin("Kristin", 14, 2);
  Student dag("Dag", 53, 5);

  joakim.leggTilQuizScore(5);
  joakim.leggTilQuizScore(3);

  kristin.leggTilQuizScore(34);
  kristin.leggTilQuizScore(23);

  dag.leggTilQuizScore(4);
  dag.leggTilQuizScore(55);

  std::cout << "Student: " << joakim.getName() << std::endl;
  std::cout << "Score: " << joakim.hentTotalScore() << std::endl;
  std::cout << "Gjennomsnitt: " << joakim.hentGjennomsnittligScore() << std::endl;

  std::cout << "Student: " << kristin.getName() << std::endl;
  std::cout << "Score: " << kristin.hentTotalScore() << std::endl;
  std::cout << "Gjennomsnitt: " << kristin.hentGjennomsnittligScore() << std::endl;

  std::cout << "Student: " << dag.getName() << std::endl;
  std::cout << "Score: " << dag.hentTotalScore() << std::endl;
  std::cout << "Gjennomsnitt: " << dag.hentGjennomsnittligScore() << std::endl;
  
  return 0;
}
