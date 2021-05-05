#include "Liste.h"

template<class T>
Lenkeliste<T>::Lenkeliste()
  : m_ant(0)
{ }

template<class T>
int Lenkeliste<T>::stoerrelse()
{
  return m_ant;
}
template<class T>
void Lenkeliste<T>::leggTil(int pos, T x)
{
  leggTil(x);
}

template<class T>
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

template<class T>
void Lenkeliste<T>::sett(int pos, T x)
{
  Node* p = m_start;
  while (pos-- && p->neste)
    p = p->neste;
  p->data = x;
}

template<class T>
T Lenkeliste<T>::hent(int pos)
{
  Node* p = m_start;
  while (pos-- && p->neste)
    p = p->neste;
  return p->data;
}

template<class T>
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
template<class T>
T Lenkeliste<T>::fjern()
{
  Node* p = m_start;
  while (p)
    p = p->neste;
  return ;
}

template<class T>
Lenkeliste<T>::Node::Node(T x)
{
  data = x;
  neste = nullptr;
}
