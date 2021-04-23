GXX = g++
CFLAGS = -O

SRCA = main.cpp Legemiddel.cpp Lege.cpp Resept.cpp
OBJA = $(SRCA:.cpp = .o)

SRCLM = testLegemiddel.cpp Legemiddel.cpp
OBJLM = $(SRCLM:.cpp = .o)

SRCR = testResept.cpp Legemiddel.cpp Lege.cpp Resept.cpp
OBJR = $(SRCR:.cpp = .o)

testAlt: $(OBJA)
	$(GXX) $(CFLAGS) -o testAlt $(OBJA)

testLegemiddel: $(OBJLM)
	$(GXX) $(CFLAGS) -o testLegemiddel $(OBJLM)

testResept: $(OBJR)
	$(GXX) $(CFLAGS) -o testResept $(OBJR)

clean:
	rm -f core *.o
