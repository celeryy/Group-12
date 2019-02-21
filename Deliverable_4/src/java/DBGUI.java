package ser322;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DBGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
	Group g = new Group();

	Scene s = new Scene(g, 600, 300);

	s.setFill(Color.BROWN);

	primaryStage.setTitle("Hello World!");
	primaryStage.setScene(s);
	primaryStage.show();
    }
    public static void main(String args[]) {
	launch(args);
    }
}
