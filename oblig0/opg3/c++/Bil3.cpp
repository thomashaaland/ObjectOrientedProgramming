#include "Bil3.h"

Bil3::Bil3(std::string nummer) : bilnummer(std::move(nummer)) { }
std::string Bil3::hentNummer() { return bilnummer; }
