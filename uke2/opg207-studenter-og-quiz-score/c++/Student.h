#include <string>

using String = std::string;

class Student {
 private:
  String m_name;
  int m_totalScore;
  int m_antallQuizDeltatt;
 public:
  Student(String, int, int);
  void leggTilQuizScore(int);
  String getName();
  int hentTotalScore();
  double hentGjennomsnittligScore();
};
