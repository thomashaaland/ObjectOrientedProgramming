// -*-Java-*-

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Rute extends Button {
    private char merke = ' ';

    public Rute() {
	super(" ");
    }

    public char hentMerke() {
	return merke;
    }

    public void settMerke(char c) {
	setText("" + c);
	merke = c;
    }
}
