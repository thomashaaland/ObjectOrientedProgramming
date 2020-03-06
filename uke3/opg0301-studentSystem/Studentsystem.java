import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class Studentsystem {



    public static void main(String[] args) throws Exception {
	HashMap<String, Fag> fagListe = new HashMap<>();
	HashMap<String, Student> studentListe = new HashMap<>();
	//ArrayList<Fag> fagListe = new ArrayList<Fag>();

	File fil = new File("emnestudenter.txt");
	Scanner in = new Scanner(fil);
	String naaVaerendeFag = "";
	while(in.hasNextLine()) {
	    String line = in.nextLine();
	    if (line.charAt(0) == "*".charAt(0)) {
		naaVaerendeFag = line.substring(1);
		fagListe.put(naaVaerendeFag, new Fag(naaVaerendeFag));
	    }
	    else {
		if (studentListe.containsKey(line)) {
		    studentListe.get(line).leggTilFag(naaVaerendeFag);
		    fagListe.get(naaVaerendeFag).leggTilStudent(studentListe.get(line));
		}
		else {
		    Student student = new Student(line, naaVaerendeFag);
		    studentListe.put(line, student);
		    fagListe.get(naaVaerendeFag).leggTilStudent(student);
		}
	    }
	}

	
	fagListe.forEach((name,fag) -> System.out.println(name + ": " + fag.antallStudenter() ));
	studentListe.forEach((name, student) -> System.out.println(name + ": " + student.antallFag() ));
	
	
	//lesInnFraFil("emnestudenter.txt");
    }

}
