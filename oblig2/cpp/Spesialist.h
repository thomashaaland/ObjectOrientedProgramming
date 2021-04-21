#ifndef SPESIALIST_H
#define SPESIALIST_H

#include "Godkjenningsfritak.h"
#include "Lege.h"

class Spesialist : public Lege, public Godkjenningsfritak {
 public:
  Spesialist();
  int hentKontrollID();
};

#endif
