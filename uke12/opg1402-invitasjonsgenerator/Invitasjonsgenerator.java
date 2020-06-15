import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Invitasjonsgenerator extends Application {

    public String[] readInfo() {

	String[] info = new String[3];
	
	Scanner in = new Scanner(System.in);

	System.out.println("Oppgi navn på arrangementet: ");
	info[0] = in.nextLine();

	System.out.println("Oppgi navn til den inviterte: ");
	info[1] = in.nextLine();

	System.out.println("Skriv en personlig hilsen til den inviterte: ");
	info[2] = in.nextLine();

	return info;

    }

    public void start(Stage stage) {
	// Fetch information
	String[] info = readInfo();

	// Generate text objects
	Text arrangement = new Text();
	arrangement.setText(info[0]);
	arrangement.setFont(Font.font("rachana", FontWeight.BOLD,
				      FontPosture.REGULAR, 72));
	//System.out.println(javafx.scene.text.Font.getFamilies());
	//arrangement.setX(100);
	//arrangement.setY(100);
	
	Text inviterte = new Text();
	inviterte.setText("Kjære " + info[1] + ".");
	inviterte.setFont(Font.font("rachana", FontWeight.BOLD,
				    FontPosture.REGULAR, 30));
	//inviterte.setX(100);
	//inviterte.setY(200);
	
	Text hilsen = new Text();
	hilsen.setText(info[2]);
	hilsen.setFont(Font.font("rachana", FontWeight.NORMAL,
				 FontPosture.REGULAR, 30));
	//hilsen.setX(100);
	//hilsen.setY(300);

	Text signert = new Text("Hilsen Thomas");
	signert.setFont(Font.font("rachana", FontWeight.NORMAL,
				  FontPosture.REGULAR, 30));

	// Pynt
	Rectangle r = new Rectangle();
	r.setX(10);
	r.setY(10);
	r.setWidth(580);
	r.setHeight(380);
	r.setFill(Color.PINK);
	r.setStroke(Color.BLACK);
	
	// Stage the scene:
	GridPane grid = new GridPane();
	grid.setGridLinesVisible(false);
	grid.add(arrangement, 0, 0);
	grid.add(inviterte, 0, 1);
	grid.add(hilsen, 0, 2);
	grid.add(signert, 0, 3);
	grid.setLayoutX(30);
	grid.setLayoutY(30);

	Pane pane = new Pane();
	pane.setPrefSize(600, 400);
	pane.getChildren().addAll(r, grid);
	
	Scene scene = new Scene(pane);
	stage.setScene(scene);
	stage.setTitle("Innbydelse");
	stage.show();
    }
    
    public static void main(String[] args) {
	Application.launch(args);
	
    }
}
