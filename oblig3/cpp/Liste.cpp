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
  if (pos == 0) leggTilForst(x);
  else
    {
      // Finn indeksen før elementet skal inn
      Node* p = iterate(pos-1);
      Node* temp = new Node(x);
      temp->neste = p->neste;
      p->neste = temp;
    }
}

// Legg til i starten av lista.
template<typename T>
void Lenkeliste<T>::leggTilForst(T x)
{
  Node* temp = new Node(x);
  if (m_start == nullptr)
    m_start = temp;
  else
    {
      temp->neste = m_start;
      m_start = temp;
    }
}

// Legg til i sutten av lista.
template<typename T>
void Lenkeliste<T>::leggTil(T x)
{
  Node* temp = new Node(x);
  if (!m_start) m_start = temp;
  else
    {
      Node* p = m_start;
      // Iterer til slutten
      while (p->neste)
	{
	  p = p->neste;
	}
      p->neste = temp;
    }
}

template<typename T>
void Lenkeliste<T>::sett(int pos, T x)
{
  Node* p = iterate(pos);
  p->data = x;
}

template<typename T>
Lenkeliste<T>::~Lenkeliste()
{
  destroyNodes(m_start);
}


template<typename T>
T Lenkeliste<T>::hent(int pos)
{
  Node* p = iterate(pos);
  return p->data;
}

template<typename T>
T Lenkeliste<T>::fjern(int pos)
{
  T data;
  if (pos == 0)
    data = fjernForste();
  else
    {
      Node* p = iterate(pos);
      if (p->neste == nullptr)
	throw "Out of bounds";
      if (p->neste->neste == nullptr)
	{
	  data = p->neste->data;
	  delete p->neste;
	  p->neste = nullptr;
	}
      else
	{
	  data = p->neste->data;
	  Node* pp = p->neste;
	  p->neste = p->neste->neste;
	  delete pp;
	  pp = nullptr;
	}
    }
  return data;
}

template<typename T>
T Lenkeliste<T>::fjern()
{
  return fjernForste();
}

// Fjern det siste elementet
template<typename T>
T Lenkeliste<T>::fjernSiste()
{
  if (!m_start) throw "List is empty";
  T data;
  Node* p = iterateNestSiste();
  if (p)
    {
      data = p->neste->data;
      delete p->neste;
      p->neste = nullptr;
    }
  else
    {
      data = m_start->data;
      delete m_start;
      m_start = nullptr;
    }
  return data;
}

// Fjern det forste elementet
template<typename T>
T Lenkeliste<T>::fjernForste()
{
  T data;
  if (m_start && m_start->neste)
    {
      data = m_start->data;
      Node* p = m_start->neste;
      delete m_start;
      m_start = p;
    }
  else
    {
      data = m_start->data;
      delete m_start;
      m_start = nullptr;
    }
  return data;
}

template<typename T>
typename Lenkeliste<T>::Node* Lenkeliste<T>::iterate(int pos)
{
  Node* p = m_start;
  while(pos-- > 0)
    {
      if (p == nullptr) return nullptr;
      p = p->neste;
    }
  return p;
}

// Iterer til slutten av lista
template<typename T>
typename Lenkeliste<T>::Node* Lenkeliste<T>::iterateSiste()
{
  if (!m_start) return nullptr;
  Node* p = m_start;
  while (p->neste)
    p = p->neste;
  return p;
}

// Iterer til det nest siste elementet
template<typename T>
typename Lenkeliste<T>::Node* Lenkeliste<T>::iterateNestSiste()
{
  if (!m_start) return nullptr;
  if (!m_start->neste) return nullptr;
  Node* p = m_start;
  while (p->neste->neste)
    p = p->neste;
  return p;
}

template<typename T>
void Lenkeliste<T>::destroyNodes(Lenkeliste<T>::Node* node)
{
  if (node)
    destroyNodes(node->neste);
  delete node;
}

template<typename T>
Lenkeliste<T>::Node::Node(T x)
{
  data = x;
  neste = nullptr;
}

template class Liste<std::string>;
template class Lenkeliste<std::string>;

template class Liste<int>;
template class Lenkeliste<int>;
