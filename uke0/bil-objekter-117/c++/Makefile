CFLAGS = -O
GXX = g++
SRC = main.cpp Bil.cpp
OBJ = $(SRC:.cpp = .o)

testBil: main.o Bil.o
	$(GXX) $(CFLAGS) -o testBil $(OBJ)

clean:
	rm -f core main.o Bil.o
