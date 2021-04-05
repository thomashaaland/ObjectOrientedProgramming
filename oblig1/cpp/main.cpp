#include "DataCluster.h"
#include <memory>
#include <cassert>

int main(int argc, char** argv) {
  auto abel = std::make_unique<DataCluster>(10);
  std::shared_ptr<Node> nodeType01(new Node(32, 8));
  std::shared_ptr<Node> nodeType02(new Node(64, 4));
  std::shared_ptr<Node> nodeType03(new Node(128, 2));

  for (int i = 0; i < 10; i++) {
    abel->settInnNode(nodeType01);
  }
  
  return 0;
}
