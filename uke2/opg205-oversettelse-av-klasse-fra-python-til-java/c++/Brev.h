#ifndef BREV_H
#define BREV_H

#include <string>
#include <vector>

using String = std::string;

class Brev {
 private:
  String m_avsender;
  String m_mottaker;
  std::vector<String> m_linjer;

 public:
  Brev(String, String);
  void skrivLinje(String);
  void lesBrev();
};

#endif
