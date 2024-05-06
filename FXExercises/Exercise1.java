package hw1Smallman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Exercise1 extends Application { //14.5
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		double size = 200.0;
		double r = size / 2;
		//String[] string = "Learning JavaFX ".split("");//string from textbook
		String[] string = "WELCOME TO JAVA ".split(""); //string in sample run

		Pane pane = new Pane();

		//loop to add text in circle pattern
		for (int i = 0; i < string.length; i++) {
			double angle = (2 * i * Math.PI) / string.length;
		    double x = r + r * Math.cos(angle);
		    double y = r + r * Math.sin(angle);
		    Text text = new Text(x, y, string[i]);
		    text.setFont(Font.font("Times New Roman", r / 2));
		    text.setRotate(90 + Math.toDegrees(angle));
		    //text.layoutXProperty().bind(pane.widthProperty().divide(2));
		    //text.layoutYProperty().bind(pane.heightProperty().divide(2));
		    pane.getChildren().add(text);
		}

		StackPane pane2 = new StackPane(); //for centering of pane
		pane2.getChildren().add(pane);
		pane2.setPadding(new Insets(45));
		pane2.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane2);
		primaryStage.setTitle("Exercise 14.5");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
