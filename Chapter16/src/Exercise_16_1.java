/**
*	Author: Christian Harris
*	Date Created: 9 September 2020
*	This program demonstrates the use of various buttons and GUI elements.
*	There is a string of text which can be recolored using radio buttons and moves using regular buttons.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class Exercise_16_1 extends Application{
	@Override
	public void start(Stage primaryStage){
		BorderPane pane = new BorderPane();
		
		HBox colorButtons = new HBox(24);
		
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		
		colorButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		colorButtons.setAlignment(Pos.CENTER);
		
		ToggleGroup colorGroup = new ToggleGroup();
		rbRed.setToggleGroup(colorGroup);
		rbYellow.setToggleGroup(colorGroup);
		rbBlack.setToggleGroup(colorGroup);
		rbOrange.setToggleGroup(colorGroup);
		rbGreen.setToggleGroup(colorGroup);
		
		rbBlack.setSelected(true);
		
		
		Text message = new Text(50, 50, "Programming is fun");
		Pane textPane = new Pane();
		textPane.getChildren().add(message);
		
		HBox movementButtons = new HBox(12);
		
		Button buttonLeft = new Button("<=");
		Button buttonRight = new Button("=>");
		
		movementButtons.getChildren().addAll(buttonLeft, buttonRight);
		movementButtons.setAlignment(Pos.CENTER);
		
		pane.setTop(colorButtons);
		pane.setCenter(textPane);
		pane.setBottom(movementButtons);
		
		rbRed.setOnAction(e -> {
			if(rbRed.isSelected()){
				message.setStyle("-fx-fill: red");
			}
		});
		
		rbYellow.setOnAction(e -> {
			if(rbYellow.isSelected()){
				message.setStyle("-fx-fill: yellow");
			}
		});
		
		rbBlack.setOnAction(e -> {
			if(rbBlack.isSelected()){
				message.setStyle("-fx-fill: black");
			}
		});
		
		rbOrange.setOnAction(e -> {
			if(rbOrange.isSelected()){
				message.setStyle("-fx-fill: orange");
			}
		});
		
		rbGreen.setOnAction(e -> {
			if(rbGreen.isSelected()){
				message.setStyle("-fx-fill: green");
			}
		});
		
		buttonLeft.setOnAction(e -> {
			message.setX(message.getX() - 10);
		});
		
		buttonRight.setOnAction(e ->{
			message.setX(message.getX() + 10);
		});
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise_16_1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}