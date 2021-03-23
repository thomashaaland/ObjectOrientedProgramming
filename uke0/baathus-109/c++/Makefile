CFLAGS = -O
GXX = g++
SRC = main.cpp Baat.cpp BaatHus.cpp
OBJ = $(SRC:.cpp = .o)

baatHusTest: main.o Baat.o BaatHus.o
	$(GXX) $(CFLAGS) -o baatHusTest $(OBJ)

clean:
	rm -f core main.o Baat.o BaatHus.o
