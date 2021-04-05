#ifndef DATA_CLUSTER_H
#define DATA_CLUSTER_H

#include <vector>
#include <memory>
#include "Rack.h"

class DataCluster {
private:
  std::vector<std::unique_ptr<Rack>> m_data_cluster;
  int m_nodes_per_rack;
  std::unique_ptr<Rack> m_rack;
  
public:
  DataCluster(int n);
  ~DataCluster();
};

#endif
