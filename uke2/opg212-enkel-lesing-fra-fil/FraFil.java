import java.io.File;
import java.util.Scanner;

class FraFil {
    static public void main(String[] args) throws Exception {
	File text = new File("tekst.txt");

	Scanner input = new Scanner(text);

	
	while (input.hasNextLine()) {
	    String line = input.nextLine();
	    System.out.println(line);
	}
    }
}
