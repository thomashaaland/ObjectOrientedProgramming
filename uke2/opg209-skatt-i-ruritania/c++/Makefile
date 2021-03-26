CFLAGS = -O
GXX = g++
SRC = main.cpp
OBJ = $(SRC:.cpp = .o)

skattBeregn: main.o
	$(GXX) $(CFLAGS) -o skattBeregn $(OBJ)

clean:
	rm -f core *.o
