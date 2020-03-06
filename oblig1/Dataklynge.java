/**
   Dataklynge holder rede paa Racks som igjen holder rede 
   paa nodes. All interaksjon for å opprette nodes skjer gjennom 
   Dataklynge. Når man oppretter en dataklynge kan man 
   assigne nodes manuelt stykkvis etter at dataklyngen er
   opprettet eller man kan opprette en direkte gjennom en
   konstruktor.
 **/

// Imports
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
    

class Dataklynge {
    // Initierer variabler som blir brukt av Dataklynge
    private ArrayList<Rack> dataKlynge;
    private int noderPerRack;
    private Rack rack;
    
    // Oppretter tom dataklynge for racks med oppgitt max
    // antall noder per rack
    public Dataklynge(int nodesPerRack) {
	//Rack[] dataKlynge = new Rack[noderPerRack];
	dataKlynge = new ArrayList<Rack>();
	noderPerRack = nodesPerRack;
	rack = new Rack(noderPerRack);
    }

    // Konstruktor for aa lese inn fra fil. Benytter seg av
    // settInnNode() metoden som kommer senere.
    // Filen maa ha formatet:
    // # 1> noderPerRack
    // # 2> antall Noder; minne per node; antall prosessorer per node
    // # 3> gjenta #2>
    // # 4> osv.
    public Dataklynge(String fileName) throws Exception {
	// Oppretter fil
	File inPut = new File(fileName);
	// initierer Scanner
	Scanner in = new Scanner(inPut);

	// Henter inn overordnet variabel noderPerRack
	noderPerRack = in.nextInt();

	// Initierer dataklynge og rack som skal settes inn
	dataKlynge = new ArrayList<Rack>();
	rack = new Rack(noderPerRack);

	// Iterer gjennom alle linjer etter den første
	// og henter inn variablene som bestemmer hvor mange
	// noder og hva slags noder som skal settes inn
	while(in.hasNextLine() && in.hasNextInt()) {
	    int nNodes = in.nextInt();
	    int memPerNode = in.nextInt();
	    int nProcPerNode = in.nextInt();
	    Node node = new Node(memPerNode, nProcPerNode);
	    for (int i=0; i<nNodes; i++) {
		settInnNode(node);
	    }
	}
    }
    
    // Setter inn en node i en rack med ledig plass, eller i
    // en ny node. isEmpty() returnerer en boolean, true for tom
    // false for ikke tom. 
    // Maa sjekke en gitt rack i dataklyngen og om det er plass
    // til flere noder i den racken.
    // metoden boolean ledigPlass() returnerer true dersom det er
    // ledig plass, false dersom ikke.
    public void settInnNode(Node node) {
	if (dataKlynge.isEmpty()) {
	    dataKlynge.add(rack);
	    dataKlynge.get(dataKlynge.size()-1).settInn(node);
	}
	else if (dataKlynge.get(dataKlynge.size()-1).ledigPlass()) {
	    dataKlynge.get(dataKlynge.size()-1).settInn(node);
	}
	else if (!dataKlynge.get(dataKlynge.size()-1).ledigPlass()) {
	    dataKlynge.add(new Rack(noderPerRack));
	    dataKlynge.get(dataKlynge.size()-1).settInn(node);
	}
    }

    // Beregner hvor mange prosessorer vi har totalt
    public int antProsessorer() {
	int nProc = 0;
	for (Rack rack : dataKlynge) {
	    nProc += rack.antProsessorer();
	}
	return nProc;
    }

    // beregner antall noder i dataklyngen med minne over angitt grense
    public int noderMedNokMinne(int paakrevdMinne) {
	int nokMinne = 0;
	for (Rack rack : dataKlynge) {
	    nokMinne += rack.noderMedNokMinne(paakrevdMinne);
	}
	return nokMinne;
    }

    // Henter antall racks i regneklyngen
    public int antRacks() {
	return dataKlynge.size();
    }
}
