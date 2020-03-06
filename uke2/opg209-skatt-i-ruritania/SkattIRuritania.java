import java.util.Scanner;

class SkattIRuritania {
    static int SKATTEGRENSE = 10000;
    static double SKATTLESS = 0.1;
    static double SKATTMORE = 0.3;
    static public void main(String[] args) {
	System.out.print("Hvor mye tjener du? ");

	Scanner input = new Scanner(System.in);
	int pengerTjent = input.nextInt();

	if (pengerTjent < SKATTEGRENSE) {
	    System.out.println("Du må betale " +
			       (pengerTjent*SKATTLESS) + " kr i skatt");
	}
	else {
	    System.out.println("Du må betale " +
			       (SKATTEGRENSE*SKATTLESS +
				(pengerTjent - SKATTEGRENSE)*SKATTMORE) +
			       " kr i skatt");
	}
    }
}
