import java.util.Scanner;

class Handletur {
    public static void main(String[] args) {

	int nBroed;
	int nMelk;
	int nOst;
	int nYoughurt;
	int totPrice;
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Hei! Velkommen til IFI-butikken.");
	System.out.print("Hvor mange brød vil du ha? ");
	nBroed = input.nextInt();
	System.out.print("Hvor mange melk vil du ha? ");
	nMelk = input.nextInt();
	System.out.print("Hvor mange ost vil du ha? ");
	nOst = input.nextInt();
	System.out.print("Hvor mange youghurt vil du ha?");
	nYoughurt = input.nextInt();

	totPrice = nBroed * 20 +
	    nMelk * 15 +
	    nOst * 40 +
	    nYoughurt * 12;

	System.out.println("Du skal betale " + totPrice + " kr.");
    }
}
