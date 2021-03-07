#pragma once
#include "dataCluster.h"
#include <vector>

class rack
{
 private:
  std::vector<node> the_rack;
  int max_nodes;
  int n_nodes;
};
