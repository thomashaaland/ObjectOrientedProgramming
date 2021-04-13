GXX = g++
CFLAGS = -O

SRCLM = testLegemiddel.cpp Legemiddel.cpp
OBJLM = $(SRCLM:.cpp = .o)

SRCR = testResept.cpp Legemiddel.cpp Lege.cpp Resept.cpp
OBJR = $(SRCR:.cpp = .o)

testLegemiddel: $(OBJLM)
	$(GXX) $(CFLAGS) -o testLegemiddel $(OBJLM)

testResept: $(OBJR)
	$(GXX) $(CFLAGS) -o testResept $(OBJR)

clean:
	rm -f core *.o
