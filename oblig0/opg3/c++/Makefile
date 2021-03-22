CFLAGS = -O
GXX = g++
SRC = main.cpp Bil3.cpp Person.cpp
OBJ = $(SRC:.cpp = .o)

bil3Test: main.o Bil3.o Person.o
	$(GXX) $(CFLAGS) -o bil3Test $(OBJ)

clean:
	rm -f core *.o
