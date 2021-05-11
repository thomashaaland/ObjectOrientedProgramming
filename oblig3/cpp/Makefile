GXX = g++
CFLAGS = -O

SRC = testLenkeliste.cpp Liste.cpp
OBJ = $(SRC:.cpp = .o)

testLenkeliste: $(OBJ)
	$(GXX) $(CFLAGS) -o testLenkeliste $(OBJ)

clean:
	rm -f core *.o
