/**
   Klassen Rack holder rede på noder. Metodene er designet for å 
   aktiveres via klassen Dataklynge. Det er maks plass til antall noder
   og en ny rack må opprettes dersom den er full.
 **/

import java.util.ArrayList;

class Rack{
    // Initierer variabler som blir brukt internt i Rack.
    // rack er selve racken, maxNodes er maks plass på en rack
    // og nNodes er hvor mange noder det for oyeblikket er
    // paa racken.
    private ArrayList<Node> rack;
    private int maxNodes;
    private int nNodes = 0;

    // Konstruktor. Oppretter en rack der det senere kan plasseres
    // en node
    public Rack(int maximumNodes) {
	rack = new ArrayList<Node>();
	maxNodes = maximumNodes;
    }

    // Metode for å få false eller true om det er ledig plass på denne
    // racken.
    public boolean ledigPlass() {
	return (maxNodes - nNodes) != 0;
    }
    
    // Plasserer en ny node inn i racket
    public void settInn(Node node) {
        rack.add(node);
	nNodes += 1;
    }

    //Beregner sammenlagt antall prosessorer i nodene i et rack
    public int antProsessorer() {
	int antall = 0;
	for (Node node : rack) {
	    antall += node.antProsessorer();
	}
	return antall;
    }

    // Beregner antall noder i racket med minne over gitt grense
    // returner antall noder med tilstrekkelig minne
    public int noderMedNokMinne(int paaKrevdMinne) {
	int nokMinne = 0;
	for (Node node : rack) {
	    nokMinne += node.nokMinne(paaKrevdMinne) ? 1 : 0;
	}
	return nokMinne;
    }
}
