#include "Rack.h"

Rack::Rack(int n) : n_nodes(0), max_nodes(n) { }

Rack::~Rack() { }

bool Rack::ledigPlass() { return (max_nodes - n_nodes) != 0; }

void Rack::settInn(std::shared_ptr<Node> node) {
  the_rack.push_back(std::move(node));
  n_nodes++;
}

int Rack::antProsessorer() {
  int antall = 0;
  for (auto node : the_rack) {
    antall += node->antallProsessorer();
  }
  return antall;
}
