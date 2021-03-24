CFLAGS = -O
GXX = g++
SRC = main.cpp Brev.cpp
OBJ = $(SRC:.cpp = .o)

brevTest: main.o Brev.o
	$(GXX) $(CFLAGS) -o brevTest $(OBJ)

clean:
	rm -f core *.o

