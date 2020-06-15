import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class TegnSirkel extends Application {

    public void start(Stage stage) {

	// Kropp
	
	Circle c1 = new Circle(100);
	Circle c2 = new Circle(80);
	Circle c3 = new Circle(60);
	
	c1.setCenterX(100);
	c1.setCenterY(400);
	c1.setFill(Color.WHITE);
	c1.setStroke(Color.BLACK);

	c2.setCenterX(100);
	c2.setCenterY(240);
	c2.setFill(Color.WHITE);
	c2.setStroke(Color.BLACK);

	c3.setCenterX(100);
	c3.setCenterY(120);
	c3.setFill(Color.WHITE);
	c3.setStroke(Color.BLACK);

	// Fjes

	Circle oyeVenstre = new Circle(80, 100, 10);
	Circle oyeHoyre = new Circle(120, 100, 10);
	Circle nese = new Circle(100, 120, 15);
	nese.setFill(Color.ORANGE);
	
	// Sene
	
	Pane pane = new Pane();
	pane.getChildren().addAll(c1, c2, c3, oyeVenstre, oyeHoyre, nese);
	Scene scene = new Scene(pane);
	stage.setScene(scene);
	stage.setScene(scene);
	stage.setTitle("Snomenn!");
	stage.show();

    }

    public static void main(String[] args) {
	Application.launch(args);
    }
}
