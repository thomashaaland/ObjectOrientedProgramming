#include "Liste.h"
#include <iostream>

static int antallTester = 0;
static int antallPasserte = 0;
static int antallFeil = 0;

void sjekkPasserte();
void sjekkFeilet(const char* testMelding);

template<typename T>
void sjekk(T forventet, T faktisk, const char* testMelding);

void testTom()
{
  std::cout << "Tester tom liste" << std::endl;
  Liste<std::string>* liste = new Lenkeliste<std::string>;
  sjekk<int>(0, liste->stoerrelse(), "stoerrelse() i tom liste");
}

void testEttElement()
{
  std::cout << std::endl << "Test ett element" << std::endl;
}

template<typename T>
void sjekk(T forventet, T faktisk, const char* testMelding)
{
  if (forventet == faktisk)
    {
      sjekkPasserte();
    }
  else
    {
      sjekkFeilet(testMelding);
      std::cout << " > Forventet verdi: " << forventet << std::endl;
      std::cout << " > Faktisk verdi: " << faktisk << std::endl;
    }
}

void sjekkPasserte()
{
  antallTester++;
  antallPasserte++;
  std::cout << "- Test " + antallPasserte << ": OK" << std::endl;
}

void sjekkFeilet(const char* testmelding)
{
  antallTester++;
  antallFeil++;
  std::cout << "- Test " << antallTester << " feilet: " << testmelding << std::endl;
}

int main()
{
  testTom();
  testEttElement();
  return 0;
}
