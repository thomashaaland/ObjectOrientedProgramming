#include "DataCluster.h"
#include <memory>
#include <cassert>
#include <iostream>

int main(int argc, char** argv) {
  auto abel = std::make_unique<DataCluster>(10);
  std::shared_ptr<Node> nodeType01(new Node(32, 8));
  std::shared_ptr<Node> nodeType02(new Node(64, 4));
  std::shared_ptr<Node> nodeType03(new Node(128, 2));

  for (int i = 0; i < 10; i++) {
    abel->settInnNode(nodeType01);
    abel->settInnNode(nodeType02);
    abel->settInnNode(nodeType03);
  }

  std::cout << "Abel:" << std::endl;
  std::cout << "Noder med minst 32GB minne:\n" << abel->nokMinne(32) << std::endl;
  std::cout << "Noder med minst 64GB minne:\n" << abel->nokMinne(64) << std::endl;
  std::cout << "Noder med minst 128GB minne:\n" << abel->nokMinne(128) << std::endl;

  std::cout << "Antall prosessorer:\n" << abel->antProsessorer() << std::endl;
  std::cout << "Antall racks:\n" << abel->antRacks() << std::endl;

  auto abel2 = std::make_unique<DataCluster>("dataklynge.txt");
  std::cout << "Abel2:" << std::endl;
  std::cout << "Noder med minst 32GB minne:\n" << abel2->nokMinne(32) << std::endl;
  std::cout << "Noder med minst 64GB minne:\n" << abel2->nokMinne(64) << std::endl;
  std::cout << "Noder med minst 128GB minne:\n" << abel2->nokMinne(128) << std::endl;

  std::cout << "Antall prosessorer:\n" << abel2->antProsessorer() << std::endl;
  std::cout << "Antall racks:\n" << abel2->antRacks() << std::endl;
  
  
  return 0;
}
