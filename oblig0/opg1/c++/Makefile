CFLAGS = -O
GXX = g++
SRC = main.cpp Bil1.cpp
OBJ = $(SRC:.cpp = .o)

bilTest: main.o Bil1.o
	$(GXX) $(CFLAGS) -o bilTest $(OBJ)

clean:
	rm -f core *.o
