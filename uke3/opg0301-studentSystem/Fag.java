import java.util.ArrayList;

class Fag {
    private String fagName;
    private ArrayList<Student> studentListe;

    public Fag(String name) {
	fagName = name;
	studentListe = new ArrayList<Student>();
    }

    public void leggTilStudent (Student student) {
	studentListe.add(student);
    }

    public void fjernStudent (Student student) {
	studentListe.remove(student);
    }

    public int antallStudenter() {
	return studentListe.size();
    }
}
