CFLAGS = -O
GXX = g++
SRC = main.cpp Student.cpp
OBJ = $(SRC:.cpp = .o)

studentTest: main.o Student.o
	$(GXX) $(CFLAGS) -o studentTest $(OBJ)
clean:
	rm -f core *.o
