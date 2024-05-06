package hw1Smallman;

import java.text.DecimalFormat;
import java.lang.Math;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.StackPane;
//import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
 
public class slotMachine extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private double amountWon = 0.0; //amount won last spin
    private double totalWon = 0.0; //total amount won
    private double amountSpent = 0.0; //amount spent on game
    
    @Override
    public void start(Stage primaryStage) {
    	//Set window title
        primaryStage.setTitle("52 Card Matchi-Slot");
        //Set Layout panes
        VBox root = new VBox(10);
        GridPane form = new GridPane();
        GridPane slots = new GridPane();
        DecimalFormat df = new DecimalFormat("#0.00"); 
        
        root.setAlignment(Pos.CENTER);
        form.setAlignment(Pos.CENTER);
        slots.setAlignment(Pos.CENTER);
        
        //Set 12 distinct Card images
        Image image01 = new Image("file:src/images/13.png");
        Image image02 = new Image("file:src/images/12.png");
        Image image03 = new Image("file:src/images/27.png");
        Image image04 = new Image("file:src/images/10.png");
        Image image05 = new Image("file:src/images/19.png");
        Image image06 = new Image("file:src/images/11.png");
        Image image07 = new Image("file:src/images/25.png");
        Image image08 = new Image("file:src/images/24.png");
        Image image09 = new Image("file:src/images/17.png");
        Image image10 = new Image("file:src/images/20.png");
        Image image11 = new Image("file:src/images/39.png");
        Image image12 = new Image("file:src/images/40.png");
        
        //Array of our 12 cards to choose from
        Image[] imgArr = {image01,image02,image03, image04,image05,image06,
        		image07,image08,image09,image10,image11,image12};
        
        ImageView imageView1 = new ImageView(image01);
        slots.add(imageView1,0,0);
        ImageView imageView2 = new ImageView(image01);
        slots.add(imageView2,1,0);
        ImageView imageView3 = new ImageView(image01);
        slots.add(imageView3,2,0);
        ImageView imageView4 = new ImageView(image01);
        slots.add(imageView4,3,0);
        
        //Set various elements into root layout pane
        root.getChildren().add(slots);
        Label amountInserted = new Label("Amount Inserted: $");
        form.add(amountInserted,0,1);
        TextField textField = new TextField();
        form.add(textField,1,1);
        root.getChildren().add(form);
        
        Label wonSpin = new Label("Amount Won This Spin: $ " + df.format(amountWon));
        root.getChildren().add(wonSpin);
        Label wonTotal = new Label("Total Amount Won: $ " + df.format(totalWon));
        root.getChildren().add(wonTotal);
        Button btn = new Button();
        btn.setText("Spin");
        Label spentTotal = new Label("So Far You Spent $ " + df.format(amountSpent));
        root.getChildren().add(spentTotal);
        
        root.getChildren().add(btn);
        //this label's content changes with button press
        Label playMessage = new Label("Insert an amount to play.");
        root.getChildren().add(playMessage);
        //slots.setPadding(new Insets(10));
        //root.setSpacing(10);
        
        //Set button handler
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
            	if (textField.getText() == "") { //Error Handling
						playMessage.setText("Error. Try a different amount.");
						//playMessage.setStyle("-fx-font-size: 5pt; -fx-font-weight: bold; -fx-background-color : Red");
				}
            	else {
            		double spent = Double.parseDouble(textField.getText());	
            		amountSpent += spent;
                	//double spent = Double.parseDouble(textField.getText());
                	//amountSpent += spent;
                	Image nxtImage1 = imgArr[getRandNum()];
                	Image nxtImage2 = imgArr[getRandNum()];
                	Image nxtImage3 = imgArr[getRandNum()];
                	Image nxtImage4 = imgArr[getRandNum()];
                	imageView1.setImage(nxtImage1);
                	imageView2.setImage(nxtImage2);
                	imageView3.setImage(nxtImage3);
                	imageView4.setImage(nxtImage4);
                	//Image[] nxtArr = {nxtImage1,nxtImage2,nxtImage3,nxtImage4};
                	
                	amountWon = 0.0; //No Luck. Play again!
                	playMessage.setText("No Luck. Play again!");
                	if((nxtImage1 == nxtImage2) || (nxtImage3 == nxtImage4)
                			|| (nxtImage2 == nxtImage3) || (nxtImage1 == nxtImage4)) {
                		amountWon = spent * 2.0; //Sweet! DOUBLE WIN x 2!!
                		playMessage.setText("Sweet! DOUBLE WIN x 2!!");
                	}
                	if((nxtImage1 == nxtImage2 && nxtImage2 == nxtImage3) || (nxtImage1 == nxtImage2 && nxtImage2 == nxtImage4)
                			|| (nxtImage1 == nxtImage3 && nxtImage3 == nxtImage4) || (nxtImage2 == nxtImage3 && nxtImage3 == nxtImage4)) {
                		amountWon = spent * 3.0; //Sweet! Triple WIN x 3!!!
                		playMessage.setText("Sweet! Triple WIN x 3!!!");
                	}
                	if(nxtImage1 == nxtImage2 && nxtImage2 == nxtImage3 && nxtImage3 == nxtImage4) {
                		amountWon = spent * 4.0; //Jackpot! Quadruple WIN x 4!!!!
                		playMessage.setText("Jackpot! Quadruple WIN x 4!!!!");
                	}
                	totalWon += amountWon;
                	
                	//Update Label Values
                	wonSpin.setText("Amount Won This Spin: $ " + df.format(amountWon));
                	wonTotal.setText("Total Amount Won: $ " + df.format(totalWon));
                	spentTotal.setText("So Far You Spent $ " + df.format(amountSpent));
                    //System.out.println(amountSpent);
                }
            }
        });
        
        //Set root layout in scene in stage, then display
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
    //Function to randomly generate number from 0-11 (for index of card array)
    public int getRandNum() {
        return (int) (Math.random() * 12);
    }
}
