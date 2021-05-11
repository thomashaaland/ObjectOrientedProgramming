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
  delete liste;
  liste = nullptr;
}

void testEttElement()
{
  std::cout << std::endl << "Test ett element" << std::endl;
  Liste<int>* liste = new Lenkeliste<int>;
  liste->leggTil(0);
  sjekk<int>(1, liste->stoerrelse(), "stoerrelse() i liste med ett element");
  int hentetElement = liste->hent(0);
  sjekk<int>(0, hentetElement, "hent(0) i liste med ett element");
  // Hent skal ikke fjerne elementet, la oss sjekke at fjerning stemmer
  int fjernetElement = liste->fjern(0);
  sjekk<int>(0, fjernetElement, "fjern(0) i liste med ett element");
  sjekk<int>(0, liste->stoerrelse(), "stoerrelse() etter at element er fjernet");
}

void testLeggTilOgFjerningAvFlereElementer()
{
  std::cout << std::endl << "Test leggTil() og fjern() med flere elementer" << std::endl;
  Liste<std::string>* liste = new Lenkeliste<std::string>;
  liste->leggTil("Element 0");
  liste->leggTil("Element X");
  liste->leggTil("Element X");
  liste->leggTil("Element 3");
  sjekk<int>(4, liste->stoerrelse(), "stoerrelse() i liste med 4 elementer");
  sjekk<std::string>("Element 0", liste->hent(0), "hent(0) i liste med 4 elementer");
  sjekk<std::string>("Element 3", liste->hent(3), "hent(3) i liste med 4 elementer");
  sjekk<std::string>("Element 0", liste->fjern(), "fjern() i liste med 4 elementer");
  sjekk<std::string>("Element X", liste->fjern(), "fjern() (for andre gang) i liste med 3 elementer");
  sjekk<int>(2, liste->stoerrelse(), "stoerrelse() etter fjerning av 2 av 4 elementer");
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
  std::cout << "- Test " << antallPasserte << ": OK" << std::endl;
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
  testLeggTilOgFjerningAvFlereElementer();
  return 0;
}
