GXX = g++
CFLAGS = -O
SRC = testLegemiddel.cpp Legemiddel.cpp
OBJ = $(SRC:.cpp = .o)

testLegemiddel: $(OBJ)
	$(GXX) $(CFLAGS) -o testLegemiddel $(OBJ)

clean:
	rm -f core *.o
