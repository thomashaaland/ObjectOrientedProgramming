#include "DataCluster.h"
#include <iostream>
#include <fstream>
#include <string>

DataCluster::DataCluster(int n) : m_nodes_per_rack(n), m_rack(std::make_unique<Rack>(n)) {}
DataCluster::DataCluster(const char* filename) {
  std::string line;
  std::ifstream rfile(filename);
  if (rfile.is_open()) {
    /*
      Initialize local variables
    */
    int nNodes;
    int memPerNode;
    int nProcPerNode;
    
    getline(rfile, line);
    m_nodes_per_rack = stoi(line);
    std::shared_ptr<Rack> rack(new Rack(m_nodes_per_rack));
    m_data_cluster.push_back(std::move(rack));
    
    while ( getline(rfile, line) ) {
      std::cout << line << std::endl;
    }
  }
}
DataCluster::~DataCluster() {}

void DataCluster::settInnNode(std::shared_ptr<Node> node) {
  if (m_data_cluster.empty()) {
    std::shared_ptr<Rack> rack(new Rack(m_nodes_per_rack));
    m_data_cluster.push_back(std::move(rack));
    m_data_cluster.back()->settInn(std::move(node));
  }
  else if (m_data_cluster.back()->ledigPlass()) {
    m_data_cluster.back()->settInn(std::move(node));
  }
  else {
    std::shared_ptr<Rack> rack(new Rack(m_nodes_per_rack));
    m_data_cluster.push_back(std::move(rack));
    m_data_cluster.back()->settInn(std::move(node));
  }
}

int DataCluster::antProsessorer() {
  int nProc = 0;
  for (auto rack : m_data_cluster)
    nProc += rack->antProsessorer();
  return nProc;
}

int DataCluster::nokMinne(int paaKrevdMinne) {
  int nokMinne = 0;
  for (auto rack : m_data_cluster)
    nokMinne += rack->noderMedNokMinne(paaKrevdMinne);
  return nokMinne;
}

int DataCluster::antRacks() {
  return m_data_cluster.size();
}
