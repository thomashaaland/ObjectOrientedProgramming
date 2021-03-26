CFLAGS = -O
GXX = g++
SRC = main.cpp
OBJ = $(SRC:.cpp = .o)

readFile: main.o
	$(GXX) $(CFLAGS) -o readFile $(SRC)

clean:
	rm -f core *.o
