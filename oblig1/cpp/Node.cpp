#include "Node.h"

Node::Node(int minne, int antallProc) : mem(minne), nProc(antallProc) {}
Node::~Node() { }
int Node::antallProsessorer() { return nProc; }
bool Node::nokMinne(int paaKrevdMinne) { return mem >= paaKrevdMinne; }
