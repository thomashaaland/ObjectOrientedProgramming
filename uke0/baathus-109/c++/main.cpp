#include "Baat.h"
#include "BaatHus.h"

int main() {
  Baat b1 = Baat("Triton");
  Baat b2 = Baat("Chaparral");
  Baat b3 = Baat("Mercury");
  Baat b4 = Baat("Mercury");

  BaatHus baatHus = BaatHus(3);
  baatHus.settInn("Ford");
  baatHus.skrivBaater();
  baatHus.settInn("Ferrari");
  baatHus.settInn("Boeing");
  baatHus.skrivBaater();
  baatHus.settInn("Tesla");
  baatHus.skrivBaater();
  
  return 0;
}
