#pragma once
#include <vector>
#include "rack.h"

class data_cluster {
 private:
  std::vector<rack> data_cluster;
  int nodes_per_rack;
  rack rack;
};
