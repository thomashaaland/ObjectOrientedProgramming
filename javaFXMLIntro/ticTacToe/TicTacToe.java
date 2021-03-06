// -*-Java-*-

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    @Override
    public void start(Stage teater) throws Exception {
	Pane kulisser = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));

	Scene scene = new Scene(kulisser);

	teater.setTitle("Tripp-trapp-tresko");
	teater.setScene(scene);
	teater.show();
    }

    public static void main(String[] args) {
	launch(args);
    }
}
