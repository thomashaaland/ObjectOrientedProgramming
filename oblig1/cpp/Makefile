CFLAGS = -O
GXX = g++
SRC = main.cpp Rack.cpp DataCluster.cpp Node.cpp
OBJ = $(SRC:.cpp = .o)

rackTest: main.o DataCluster.o Node.o Rack.o
	$(GXX) $(CFLAGS) -o rackTest $(OBJ)

clean:
	rm -f core *.o
