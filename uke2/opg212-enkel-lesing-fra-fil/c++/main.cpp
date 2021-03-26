#include <iostream>
#include <fstream>
#include <string>

int main() {
  std::string infile = "../tekst.txt";
  std::ifstream fs(infile);
  std::string line;
  
  while(std::getline(fs, line)) {
    std::cout << line << std::endl;
  }

  fs.close();
  
  return 0;
}
