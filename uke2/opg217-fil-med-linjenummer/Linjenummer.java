import java.util.Scanner;
import java.io.File;
class Linjenummer {
    public static void main(String[] args) throws Exception {
	int line = 1;
	File text = new File("./tekst.txt");
	Scanner in = new Scanner(text);
	while (in.hasNextLine()) {
	    System.out.println("# Linje " + line + ": " + in.nextLine());
	    line += 1;
	}
    }
}
