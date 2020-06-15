import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.event.*;

import javafx.collections.ObservableList;

import java.util.Random;

public class TicTacController {

    @FXML
    private GridPane rutenett;
    @FXML
    private Text statusinfo;

    @FXML
    protected void stopSpill(ActionEvent e) {
	Platform.exit();
    }

    class Klikkbehandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
	    if (!ferdig)
		spillO((Rute) e.getSource());
	}
    }

    private Rute[] brett;
    private boolean ferdig = false;
    private Random tilfeldig = new Random();

    public void initialize() {
	brett = new Rute[9];
	Klikkbehandler klikk = new Klikkbehandler();

	int rader = 3, kolonner = 3, indeks;
	for (int i = 0; i < rader; i++) {
	    for (int j = 0; j < kolonner; j++) {
		indeks = (i * rader) + j;
		brett[indeks] = new Rute();
		brett[indeks].getStyleClass().add("rute");
		brett[indeks].setOnAction(klikk);
		rutenett.add(brett[indeks], i, j);
	    }
	}
	
	spillX();
    }

    void spillO(Rute r) {
	if (r.hentMerke() != ' ') {
	    statusinfo.setText("Ruten er opptatt; velg en annen");
	    return;
	}
	else {
	    statusinfo.setText("Velg en rute");
	}

	r.settMerke('O');
	if (harVunnet('O')) utropVinner('O');

	if (!ferdig) spillX();
    }

    void spillX() {
	int p;
	do {
	    p = tilfeldig.nextInt(9);
	} while (brett[p].hentMerke() != ' ');
	brett[p].settMerke('X');

	if (harVunnet('X')) utropVinner('X');
	else if (erUavgjort()) utropUavgjort();
    }

    boolean harVunnet(char c) {
	return
	    trePaaRad(0, 1, 2, c) ||
	    trePaaRad(3, 4, 5, c) ||
	    trePaaRad(6, 7, 8, c) ||
	    trePaaRad(0, 3, 6, c) ||
	    trePaaRad(1, 4, 7, c) ||
	    trePaaRad(2, 5, 8, c) ||
	    trePaaRad(0, 4, 8, c) ||
	    trePaaRad(2, 4, 6, c);
    }

    boolean trePaaRad(int r1, int r2, int r3, char c) {
	if (brett[r1].hentMerke() != c) return false;
	if (brett[r2].hentMerke() != c) return false;
	if (brett[r3].hentMerke() != c) return false;
	return true;
    }

    boolean erUavgjort() {
	for (int i = 0; i <= 8; i++)
	    if (brett[i].hentMerke() == ' ') return false;
	return true;
    }

    void utropVinner(char c) {
	statusinfo.setText(c + " har vunnet!");
	ferdig = true;
    }

    void utropUavgjort() {
	statusinfo.setText("Det ble uavgjort!");
	ferdig = true;
    }
}
