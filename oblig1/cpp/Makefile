CFLAGS = -O
GXX = g++
SRC = main.cpp data_cluster.cpp node.cpp rack.cpp
OBJ = $(SRC:.cpp = .o)

rackTest: main.o data_cluster.o node.o rack.o
	$(GXX) $(CFLAGS) -o rackTest $(OBJ)

clean:
	rm -f core *.o
