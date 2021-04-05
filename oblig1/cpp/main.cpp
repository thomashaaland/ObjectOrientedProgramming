#include "DataCluster.h"
#include <memory>
#include <cassert>

int main(int argc, char** argv) {
  auto abel = std::make_unique<DataCluster>(10);
  
  return 0;
}
