#include "Liste.h"

template<typename T>
Lenkeliste<T>::Lenkeliste()
  : m_ant(0)
{ }

template<typename T>
int Lenkeliste<T>::stoerrelse()
{
  int ant = 0;
  Node * p = m_start;
  while (p)
    {
      p = p->neste;
      ant++;
    }
  return ant;
}
template<typename T>
void Lenkeliste<T>::leggTil(int pos, T x)
{
  leggTil(x);
}

template<typename T>
void Lenkeliste<T>::leggTil(T x)
{
  Node* temp = new Node(x);
  if (m_start)
    {
      Node* p = m_start;
      while (!(p->neste))
	{
	  p = p->neste;
	}
      p->neste = temp;
    }
  else
    {
      m_start = temp;
    }
}

template<typename T>
void Lenkeliste<T>::sett(int pos, T x)
{
  Node* p = m_start;
  while (pos-- && p->neste)
    p = p->neste;
  p->data = x;
}

template<typename T>
T Lenkeliste<T>::hent(int pos)
{
  Node* p = m_start;
  while (pos-- && p->neste)
    p = p->neste;
  return p->data;
}

template<typename T>
T Lenkeliste<T>::fjern(int pos)
{
  Node* p = m_start;
  Node* prev = p;
  T d;
  while (pos-- && p)
    {
      prev = p;
      p = p->neste;
    }
  //if (pos > 0) return nullptr;
  if (p)
    {
      prev->neste = p->neste;
      d = p->data;
      delete p;
      return d;
    }
  else
    {
      prev->neste = nullptr;
      d = p->data;
      delete p;
      return d;
    }
}
template<typename T>
T Lenkeliste<T>::fjern()
{
  Node* p = m_start;
  Node* prev = p;
  while (p)
    {
      prev = p;
      p = p->neste;
    }
  prev->neste = nullptr;
  delete p;
  return prev->data;
}

template<typename T>
Lenkeliste<T>::Node::Node(T x)
{
  data = x;
  neste = nullptr;
}

template class Liste<std::string>;
template class Lenkeliste<std::string>;
