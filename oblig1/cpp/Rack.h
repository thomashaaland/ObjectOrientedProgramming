#ifndef RACK_H
#define RACK_H

#include "Node.h"
#include <vector>
#include <memory>

class Rack {
private:
  std::vector<std::shared_ptr<Node>> the_rack;
  int max_nodes;
  int n_nodes;
  
public:
  Rack(int n);
  ~Rack();
  bool ledigPlass();
  void settInn(std::shared_ptr<Node> node);
  int antProsessorer();
  int noderMedNokMinne(int paaKrevdMinne);
};

#endif
