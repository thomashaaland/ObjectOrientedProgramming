#include "Liste.h"

template<class T>
int Lenkeliste<T>::stoerrelse()
{
  return 0;
}
template<class T>
void Lenkeliste<T>::leggTil(int pos, T x)
{ }
template<class T>
void Lenkeliste<T>::leggTil(T x)
{ }
template<class T>
void Lenkeliste<T>::sett(int pos, T x)
{ }
template<class T>
T Lenkeliste<T>::hent(int pos)
{
  return ;
}
template<class T>
T Lenkeliste<T>::fjern(int pos)
{
  return ;
}
template<class T>
T Lenkeliste<T>::fjern()
{
  return ;
}

template<class T>
Lenkeliste<T>::Node::Node(T x)
{
  data = x;
  neste = nullptr;
}
