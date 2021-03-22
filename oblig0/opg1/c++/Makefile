CFLAGS = -O
GXX = g++

bilTest: main.o Bil1.o
	$(GXX) $(CFLAGS) -o bilTest main.o Bil1.o
main.o:
	$(GXX) $(CFLAGS) -c main.cpp
Bil1.o:
	$(GXX) $(CFLAGS) -c Bil1.cpp

clean:
	rm -f core *.o
