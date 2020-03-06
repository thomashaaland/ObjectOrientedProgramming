import java.io.File;
import java.util.Scanner;

class Gruppeoppmoete {
    private String[] navn = new String[14];
    private boolean[] oppmoete = new boolean[14];

    public void lesInnNavn() {
	File file = new File("./gruppeliste.txt");
	Scanner in = new Scanner(file);
	int i = 0;
	while(in.hasNextLine()) {
	    navn[i] = in.nextLine();
	    i += 1;
	}
    }
    
    public void registrerStudent(String studNavn, boolean studOppmote) {
	for (int i = 0; i < navn.length; i++) {
	    if (studNavn == navn[i]) {
		oppmoete[i] = studOppmote;
	    }
	}
    }

    public void skrivUtOppmote() {
	for (int i = 0; i < navn.length; i++) {
	    System.out.println(navn[i] + ": " + oppmoete[i]);
	}
    }
    
}
