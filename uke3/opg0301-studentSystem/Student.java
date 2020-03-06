import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<String> oppmeldteFag;

    public Student(String initName) {
	name = initName;
	oppmeldteFag = new ArrayList<String>();
    }

    public Student(String initName, String fag) {
	name = initName;
	oppmeldteFag = new ArrayList<String>(){
		{
		    add(fag);
		}
	    };
    }

    public void leggTilFag(String fag) {
	oppmeldteFag.add(fag);
    }

    public void fjernFag(String fag) {
	oppmeldteFag.remove(fag);
    }
    
    public int antallFag() {
	return oppmeldteFag.size();
    }

    public void skrivUtFag() {
	System.out.print(name + " tar fagene: ");
	for (String fag : oppmeldteFag) {
	    System.out.print(fag + " ");
	}
	System.out.println(".");
    }

    
}
