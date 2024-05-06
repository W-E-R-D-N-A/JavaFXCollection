package hw1Smallman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise2 extends Application { //14.11
	public static void main(String[] args) {
        launch(args);
    }
	@Override
    public void start(Stage primaryStage) {
		//Circle for face
		Circle circle = new Circle();
		circle.setCenterX(125);
		circle.setCenterY(125);
		circle.setRadius(100);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
		//Arc for mouth
		Arc arc = new Arc();
		arc.setCenterX(140);
		arc.setCenterY(125);
		arc.setRadiusX(100);
		arc.setRadiusY(50);
		arc.setStartAngle(245);
		arc.setLength(40);
		arc.setType(ArcType.OPEN);
		arc.setStroke(Color.BLACK);
		arc.setFill(Color.WHITE);
		
		//Polygon for nose
		Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{
                125.0, 100.0,
                105.0, 145.0,
                145.0, 145.0
        });
		triangle.setStroke(Color.BLACK);
		triangle.setFill(Color.RED);
		
		//Ellipse for Left Eye
		Ellipse left_eye = new Ellipse();
		left_eye.setCenterX(80.0);
		left_eye.setCenterY(85.0);
		left_eye.setRadiusX(30.0);
		left_eye.setRadiusY(20.0);
		left_eye.setStroke(Color.BLACK);
		left_eye.setFill(Color.YELLOW);
		
		//Ellipse for Right Eye
		Ellipse right_eye = new Ellipse();
		right_eye.setCenterX(170.0);
		right_eye.setCenterY(85.0);
		right_eye.setRadiusX(30.0);
		right_eye.setRadiusY(20.0);
		right_eye.setStroke(Color.BLACK);
		right_eye.setFill(Color.YELLOW);
		
		//Circle for Left Pupil
		Circle left_pupil = new Circle();
		left_pupil.setCenterX(80);
		left_pupil.setCenterY(85);
		left_pupil.setRadius(10);
		left_pupil.setStroke(Color.BLACK);
		left_pupil.setFill(Color.BLACK);
		
		//Circle for Right Pupil
		Circle right_pupil = new Circle();
		right_pupil.setCenterX(170);
		right_pupil.setCenterY(85);
		right_pupil.setRadius(10);
		right_pupil.setStroke(Color.BLACK);
		right_pupil.setFill(Color.BLACK);
		
		Pane pane = new Pane();
		pane.getChildren().add(circle);
		pane.getChildren().add(arc);
		pane.getChildren().add(triangle);
		pane.getChildren().add(left_eye);
		pane.getChildren().add(right_eye);
		pane.getChildren().add(left_pupil);
		pane.getChildren().add(right_pupil);
		
		Scene scene = new Scene(pane,250,250);
		primaryStage.setTitle("Exercise 14.11");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
