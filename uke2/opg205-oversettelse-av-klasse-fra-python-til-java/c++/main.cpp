#include "Brev.h"

int main() {
  Brev brevet("Per Askeladd", "Espen Askeladd");
  brevet.skrivLinje("Hvordan har du det?");
  brevet.skrivLinje("Jeg har det bra.");
  brevet.lesBrev();
  
  return 0;
}
