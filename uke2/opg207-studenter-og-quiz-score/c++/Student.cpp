#include "Student.h"

Student::Student(String name, int totalScore, int antallQuizDeltatt) :
  m_name(name), m_totalScore(totalScore), m_antallQuizDeltatt(antallQuizDeltatt) { }

void Student::leggTilQuizScore(int score) {
  m_totalScore += score;
  m_antallQuizDeltatt++;
}

String Student::getName() {
  return m_name;
}

int Student::hentTotalScore() {
  return m_totalScore;
}

double Student::hentGjennomsnittligScore() {
  return (double)m_totalScore / m_antallQuizDeltatt;
}
