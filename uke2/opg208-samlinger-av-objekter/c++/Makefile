CFLAGS = -O
GXX = g++
SRC = main.cpp Person.cpp
OBJ = $(SCR:.cpp = .o)

telefonBok: main.o Person.o
	$(GXX) $(CFLAGS) -o telefonBok $(SRC)
clean:
	rm -f core *.o
