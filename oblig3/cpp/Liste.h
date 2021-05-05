#ifndef Liste_H
#define Liste_H

template <class T>
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

#endif
