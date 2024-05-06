package hw1Smallman;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.shape.Polyline;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise4 extends Application { //14.19
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		//function polyline f(x) = sin(x)
		Polyline sinline = new Polyline();
		ObservableList<Double> list = sinline.getPoints();
		//double scaleFactor = 50;
		for (int x = -170; x <= 170; x++) {
			list.add(x + 200.0);
			list.add(100 -50 * Math.sin((x/100.0)*2*Math.PI));
		}
		sinline.setStroke(Color.RED);
		//function polyline f(x) = cos(x)
		Polyline cosline = new Polyline();
		ObservableList<Double> list2 = cosline.getPoints();
		//double scaleFactor2 = 50;
		for (int x = -170; x <= 170; x++) {
			list2.add(x + 200.0);
			list2.add(100 -50 * Math.cos((x/100.0)*2*Math.PI));
		}
		cosline.setStroke(Color.BLUE);
		
		//y axis
		Polyline yaxis = new Polyline();
		yaxis.getPoints().addAll(new Double[] {
				200.0, 200.0,
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
				5.0, 100.0,
				395.0, 100.0
		});
		Polyline xaxis_head = new Polyline();
		xaxis_head.getPoints().addAll(new Double[] {
				385.0, 95.0,
				395.0, 100.0,
				385.0, 105.0
		});
		Text x_label = new Text(390.0, 80.0, "X");
		Text neg_twoPi = new Text(90,110.0,"-2\u03c0");
		Text neg_Pi = new Text(145,110.0,"-\u03c0");
		Text pi = new Text(247,110.0,"\u03c0");
		Text twoPi = new Text(295,110.0,"2\u03c0");
		
		Pane pane = new Pane();
		pane.getChildren().add(sinline);
		pane.getChildren().add(cosline);
		pane.getChildren().add(yaxis);
		pane.getChildren().add(xaxis);
		pane.getChildren().add(yaxis_head);
		pane.getChildren().add(xaxis_head);
		pane.getChildren().add(y_label);
		pane.getChildren().add(x_label);
		pane.getChildren().add(neg_twoPi);
		pane.getChildren().add(neg_Pi);
		pane.getChildren().add(pi);
		pane.getChildren().add(twoPi);
		
		
		Scene scene = new Scene(pane,400,200);
		primaryStage.setTitle("Exercise 14.19");
		primaryStage.setScene(scene);
		primaryStage.show();}
}
