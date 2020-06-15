/*
  --*java*--
  SpillKontroll staar for oppsett og kaller selve spill klassen Spill
*/

import java.util.Scanner;
import java.util.ArrayList;

// Javafx
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SpillKontroll extends Application {
    public static void main(String[] args){
	launch(args);
    }

    @Override
    public void start(Stage stage) {
	
	/*
	Terminal spillerKonsoll = new Terminal(new Scanner(System.in));
	int valg = spillerKonsoll.beOmKommando("Velg:", new String[]{"En", "To", "Tre"}); 
	System.out.println("Du valgte " + valg);
	*/

	// 1. Opprett terreng
	Terreng terreng = new Terreng();
	// Sjekk om terreng funker
	/*
	Sted her = terreng.hentStart();
	while (her != null) {
	    System.out.println("Stedsbeskrivelse: " + her);
	    her = her.gaaVidere();
	}
	*/
	// 2. Opprett spiller
	Spiller spiller = new Spiller(terreng.hentStart(), new Terminal(new Scanner(System.in)));
	Spiller robot = new Spiller(terreng.hentStart(), new Robot());
	
	// 3. opprett og kjor Spill()
	Spill spill = new Spill(spiller);
	spill.spill();

	
	// 4. Oppgi resultatet av spillingen ( navn og formue )
	// Start et vindu

	// Setter opp stage
	stage.setTitle("Resultat");
	Pane pane = new Pane();
	pane.setStyle("-fx-background-color: gray");

	// setter opp text
	// Lager dropshadow
	DropShadow ds = new DropShadow();
	ds.setOffsetY(2.0f);
	ds.setColor(Color.color(0f, 0f, 0f));
	
	// Tekst
	Text score = new Text(50, 50, "Resultatet av spillet ble:\n" +
			      "Formue: " + spill.formueResultat());
	score.setFont(new Font("Verdana", 20));
	score.setFill(Color.color(1f, 1f, 1f));
	score.setEffect(ds);

	// Legger til knapp
	Button avslutt = new Button("Avslutt");
	avslutt.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
		    stage.close();	    
		}
	    });
	avslutt.setLayoutX(50);
	avslutt.setLayoutY(120);
	avslutt.setPrefSize(200, 100);
	
	// setter opp pane
	pane.getChildren().add(score);
	pane.getChildren().add(avslutt);

	// vis vindu
	stage.setScene(new Scene(pane, 480, 360));
	Runnable tellNed = new Teller();
	Thread teller = new Thread(tellNed);
	teller.start();
	stage.show();
    }
}

// Teller
class Teller implements Runnable {
    @Override
    public void run() {
	try {
	    Thread.sleep(5000);
	}
	catch (InterruptedException e) {
	    System.out.println(e);
	}
	Platform.exit();
    }
}
