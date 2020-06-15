/*
  --*java*--
  Fungerer som klassen terminal, men trekker tlfeldig blandt alternativene
*/
import java.util.Scanner;
import java.util.Random;

class Robot implements Brukergrensesnitt {
    Random rand;
    // Konstruktor
    // param sc henter et scanner objekt for aa vaere komaptible med spiller.
    // Scanner brukes ikke til noe
    public Robot(){
	rand = new Random();
    }

    // beOmKommando trekker et tilfeldig valg
    @Override
    public int beOmKommando(String spoersmaal, String[] alternativer) {
	int valg = rand.nextInt(alternativer.length);
	return valg;
    }

    // Gir status
    @Override
    public void giStatus(String status) {
	System.out.println(status);
    }
}
