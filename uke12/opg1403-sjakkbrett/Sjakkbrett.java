import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Sjakkbrett extends Application {
    @Override
    public void start(Stage stage) {

	int size = 80;
	int cols = 8;
	int rows = 8;
	
	// Make gridpane
	GridPane grid = new GridPane();
	grid.setGridLinesVisible(true);
	for (int i = 0; i < cols; i++) {
	    for (int j = 0; j < rows; j++) {
		// Make rectangles
		Rectangle r = new Rectangle();
		r.setWidth(size); r.setHeight(size);
		if (((i + j) % 2) == 0) r.setFill(Color.WHITE);
		else r.setFill(Color.BLACK);

		grid.add(r, i, j);
				
	    }
	}

	Pane pane = new Pane();
	pane.setPrefSize(size * cols, size * rows);
	pane.getChildren().add(grid);

	Scene scene = new Scene(pane);

	stage.setTitle("Sjakkbrett");
	stage.setScene(scene);
	stage.show();
	
    }
    
    public static void main(String[] args) {
	Application.launch();
    }
}
