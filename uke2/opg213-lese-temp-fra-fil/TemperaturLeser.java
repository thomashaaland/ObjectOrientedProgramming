import java.util.Scanner;
import java.io.File;

class TemperaturLeser {
    public static void main(String[] args) throws Exception {
	String[] temp = new String[12];

	Scanner fil = new Scanner(new File("temperatur.txt"));

	int linje = 0;
	while (fil.hasNextLine()) {
	    temp[linje] = fil.nextLine();
	    linje++;
	}

	for (String element : temp) {
	    System.out.println(element);
	}
    }
}
