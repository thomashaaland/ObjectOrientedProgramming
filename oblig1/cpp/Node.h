#ifndef NODE_H
#define NODE_H

class Node {
private:
  int mem;
  int nProc;

public:
  Node(int minne, int antallProc);
  ~Node();
  int antallProsessorer();
  bool nokMinne(int paaKrevdMinne);
};

#endif
