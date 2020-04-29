import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Hallo extends Application {
    @Override
    public void start(Stage teater) {
	Text hilsen = new Text("Hallo, alle sammen!");
	hilsen.setY(40);
	hilsen.setFont(new Font(40));

	Pane kulisser = new Pane();
	kulisser.getChildren().add(hilsen);

	Scene scene = new Scene(kulisser);

	teater.setTitle("Velkommen til java FX");
	teater.setScene(scene);
	teater.show();
    }

    public static void main(String[] args) {
	launch(args);
    }
}
