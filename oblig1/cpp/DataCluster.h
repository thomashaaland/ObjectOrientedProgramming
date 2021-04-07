#ifndef DATA_CLUSTER_H
#define DATA_CLUSTER_H

#include <vector>
#include <memory>
#include "Rack.h"

class DataCluster {
private:
  std::vector<std::shared_ptr<Rack>> m_data_cluster;
  int m_nodes_per_rack;
  std::unique_ptr<Rack> m_rack;
  
public:
  DataCluster(int n);
  DataCluster(const char* filename);
  ~DataCluster();
  void settInnNode(std::shared_ptr<Node> node);
  int antProsessorer();
  int nokMinne(int paaKrevdMinne);
  int antRacks();
};

#endif
