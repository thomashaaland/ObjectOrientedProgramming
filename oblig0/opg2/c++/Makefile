CFLAGS = -O
GXX = g++
SRC = main.cpp Bil2.cpp
OBJ = $(SRC:.cpp = .o)

bil2Test: $(OBJ)
	$(GXX) $(CFLAGS) -o bil2Test $(OBJ)

clean:
	rm -f core *.o
