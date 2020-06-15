import java.io.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;

public class Bildeleser extends Application {
    static Pane pane = new Pane();
    final static int PADDINGY = 50; // padding fra toppen

    Button velgFilKnapp;
    Button lastInnKnapp;
    
    public static void main(String[] args) {
	launch();
    }

    // KlikkBehandler
    class Klikkbehandler implements EventHandler<ActionEvent> {
	TextField filFelt;
	
	public Klikkbehandler(TextField filfelt) {
	    this.filFelt = filfelt;
	}

	public void handle(ActionEvent e) {
	    if ((Button)e.getSource() == velgFilKnapp) {
		FileChooser fileChooser = new FileChooser();
		ExtensionFilter filter = new ExtensionFilter("Text Files", "*.txt", "*.in");
		fileChooser.getExtensionFilters().add(filter);
		fileChooser.setTitle("Velg tekstfil");
		File selectedFile = fileChooser.showOpenDialog(null);

		if (selectedFile != null) {
		    filFelt.setText(selectedFile.getPath());
		}
	    }

	    else if ((Button)e.getSource() == lastInnKnapp) {
		try {
		    lesInn(new File(filFelt.getText()));
		}
		catch (FileNotFoundException fne) {}
	    }
	}
    }

    // LagToppBoks metode for å lage toppBoks
    private HBox lagToppBoks() {
	TextField filFelt = new TextField();
	Klikkbehandler klikk = new Klikkbehandler(filFelt);

	velgFilKnapp = new Button("Velg fil");
	velgFilKnapp.setOnAction(klikk);
	
	lastInnKnapp = new Button("Last inn");
	lastInnKnapp.setOnAction(klikk);
	return new HBox(PADDINGY, velgFilKnapp,
			filFelt, lastInnKnapp);
    }

    public static void lesInn(File fil) throws FileNotFoundException {
	Scanner sc = new Scanner(fil);
	String[] figur = sc.nextLine().split(" ");
	while (sc.hasNextLine()) {

	    // Rektangler:
	    if (figur[1].equals("Rectangles")) {
		while (sc.hasNextLine()) {
		    figur = sc.nextLine().split(" ");
		    if (figur[0].equals("#")) {
			break;
		    }

		    // Save values
		    int x = Integer.parseInt(figur[0]);
		    int y = Integer.parseInt(figur[1]);
		    int width = Integer.parseInt(figur[2]);
		    int height = Integer.parseInt(figur[3]);
		    
		    // Oppretter rektangel
		    Rectangle s = new Rectangle();
		    s.setX(x);
		    s.setY(y + PADDINGY);
		    s.setWidth(width);
		    s.setHeight(height);
		    
		    // farge
		    if (figur.length == 5) {
			if (figur[4].compareToIgnoreCase("red") == 0) {
			    s.setFill(Color.RED);
			}
			else if (figur[4].compareToIgnoreCase("blue") == 0) {
			    s.setFill(Color.BLUE);
			}
			else {
			    s.setFill(Color.BLACK);
			}
		    }
		    else {
			s.setFill(Color.BLACK);
		    }
		    
		    // legger til i pane
		    pane.getChildren().add(s);
		}
	    }
	    
	    // Sirkler:
	    if (figur[1].equals("Circles")) {
		while (sc.hasNextLine()) {
		    figur = sc.nextLine().split(" ");
		    if (figur[0].equals("#")) {
			break;
		    }

		    // Save values
		    int x = Integer.parseInt(figur[0]);
		    int y = Integer.parseInt(figur[1]);
		    int radius = Integer.parseInt(figur[2]);

		    // Opprett sirkel
		    Circle s = new Circle();
		    s.setCenterX((double) x);
		    s.setCenterY((double) y + (double) PADDINGY);
		    s.setRadius(radius);

		    // Farge
		    if (figur.length == 4) {
			if (figur[3].equalsIgnoreCase("red")) {
			    s.setFill(Color.RED);
			}
			else if (figur[3].equalsIgnoreCase("blue")) {
			    s.setFill(Color.BLUE);
			}
			else {
			    s.setFill(Color.BLACK);
			}
		    }
		    else {
			s.setFill(Color.BLACK);
		    }

		    // lagrer sirkel i pane
		    pane.getChildren().add(s);
		}
	    }
	}
    }
	    
    @Override
    public void start(Stage stage) {
	// Lag kulisser, eller pane
	pane.getChildren().add(lagToppBoks());
	pane.setPrefSize(500, 500);

	// sett opp senen
	Scene scene = new Scene(pane);
	stage.setTitle("Bildeleser");
	stage.setScene(scene);
	stage.show();	       
    }
    
}
