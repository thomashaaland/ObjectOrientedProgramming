/**
   Klassen Node tar vare på informasjonen per node. De grunnleggende 
   byggesteinene er variablene mem=Minne og nProc= antall prossessorer.
 **/

class Node {
    // Initierer variabler for hvor mye minne og antall prosessorer
    // en gitt node tar.
    private int mem;
    private int nProc;

    // Konstruktor, oppretter en node med gitt minne størrelse og antall
    // prosessorer
    public Node(int minne, int antPros) {
	mem = minne;
	nProc = antPros;
    }

    // Henter antall prosessorer i noden
    public int antProsessorer() {
	return nProc;
    }

    // Sjekker om noden har tilstrekkelig minne for et program
    public boolean nokMinne(int paakrevdMinne) {
	return (mem >= paakrevdMinne);
    }
}
