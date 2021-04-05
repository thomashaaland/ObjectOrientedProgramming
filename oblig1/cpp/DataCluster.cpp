#include "DataCluster.h"

DataCluster::DataCluster(int n) : m_nodes_per_rack(n), m_rack(std::make_unique<Rack>(n)) {}
DataCluster::~DataCluster() {}
