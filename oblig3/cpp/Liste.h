#ifndef Liste_H
#define Liste_H

#include <string>
#include <iostream>

/*
  Liste virtual class
*/
template <typename T>
class Liste {
 public:
  virtual int stoerrelse() = 0;
  virtual void leggTil(int pos, T x) = 0;
  virtual void leggTil(T x) = 0;
  virtual void sett(int pos, T x) = 0;
  virtual T hent(int pos) = 0;
  virtual T fjern(int pos) = 0;
  virtual T fjern() = 0;
};

/*
  Lenkeliste
*/
template <typename T>
class Lenkeliste : virtual public Liste<T>
{
 public:
  Lenkeliste();
  ~Lenkeliste();
  
  int stoerrelse() override;
  void leggTil(int pos, T x) override;
  void leggTil(T x) override;
  void sett(int pos, T x) override;
  T hent(int pos) override;
  T fjern(int pos) override;
  T fjern() override;
  
  class Node
  {
  public:
    Node(T x);
    Node* neste;
    T data;
  };
  
protected:
  Node* m_start;
  int m_ant;
  
private:
  T fjernForste();
  T fjernSiste();
  void leggTilForst(T x);
  Node* iterate(int pos);
  Node* iterateSiste();
  Node* iterateNestSiste();
  void destroyNodes(Node* node);
};

#endif
