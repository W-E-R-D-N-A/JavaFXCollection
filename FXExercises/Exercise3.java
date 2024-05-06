package FXExercises;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.shape.Polyline;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise3 extends Application { //14.18
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		//function polyline f(x) = x^2
		Polyline polyline = new Polyline();
		ObservableList<Double> list = polyline.getPoints();
		double scaleFactor = 0.0125;
		for (int x = -100; x <= 100; x++) { //modifications to textbook's function were made
			list.add(-(x + 200.0)+400); //+400 to get properly positioned curve
			list.add(-(scaleFactor * x * x)+180); //^2 and +180 to get correct and properly positioned
		}
		
		//y axis
		Polyline yaxis = new Polyline();
		yaxis.getPoints().addAll(new Double[] {
				200.0, 250.0,
				200.0, 5.0
		});
		Polyline yaxis_head = new Polyline();
		yaxis_head.getPoints().addAll(new Double[] {
				195.0, 10.0,
				200.0, 5.0,
				205.0, 10.0
		});
		Text y_label = new Text(210.0, 10.0, "Y");
		//x axis
		Polyline xaxis = new Polyline();
		xaxis.getPoints().addAll(new Double[] {
				5.0, 180.0,
				395.0, 180.0
		});
		Polyline xaxis_head = new Polyline();
		xaxis_head.getPoints().addAll(new Double[] {
				385.0, 175.0,
				395.0, 180.0,
				385.0, 185.0
		});
		Text x_label = new Text(390.0, 160.0, "X");
		
		Pane pane = new Pane();
		pane.getChildren().add(polyline);
		pane.getChildren().add(yaxis);
		pane.getChildren().add(xaxis);
		pane.getChildren().add(yaxis_head);
		pane.getChildren().add(xaxis_head);
		pane.getChildren().add(y_label);
		pane.getChildren().add(x_label);
		
		Scene scene = new Scene(pane,400,300);
		primaryStage.setTitle("Exercise 14.18");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
