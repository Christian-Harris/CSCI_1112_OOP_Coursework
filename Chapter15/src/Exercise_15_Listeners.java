/**
*	Author: Christian Harris
*	Date Created: 9 September 2020
*	This program displays a ball which can be moved using either the arrow keys or the displayed buttons.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class Exercise_15_Listeners extends Application{
	@Override
	public void start(Stage primaryStage){
		BorderPane pane = new BorderPane();
		
		Ball myBall = new Ball();
		myBall.setOnKeyPressed(myBall.new KeyEventHandler());
		
		
		
		
		Button buttonUp = new Button("UP");
		buttonUp.setMinSize(50, 25);
		buttonUp.setOnAction(myBall.new ButtonHandler());
		buttonUp.setFocusTraversable(false);
		
		Button buttonDown = new Button("DOWN");
		buttonDown.setMinSize(50, 25);
		buttonDown.setOnAction(myBall.new ButtonHandler());
		buttonDown.setFocusTraversable(false);
		
		Button buttonLeft = new Button("LEFT");
		buttonLeft.setMinSize(50, 25);
		buttonLeft.setOnAction(myBall.new ButtonHandler());
		buttonLeft.setFocusTraversable(false);
		
		Button buttonRight = new Button("RIGHT");
		buttonRight.setMinSize(50, 25);
		buttonRight.setOnAction(myBall.new ButtonHandler());
		buttonRight.setFocusTraversable(false);
		
		HBox buttons = new HBox();
		buttons.getChildren().addAll(buttonUp, buttonDown, buttonLeft, buttonRight);
		buttons.setAlignment(Pos.CENTER);
		
		
		pane.setBottom(buttons);
		pane.setCenter(myBall);
		
		Scene scene = new Scene(pane, 400, 400);
				
		primaryStage.setTitle("Exercise_15_Listeners");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//myBall.requestFocus();
	}
	
	class Ball extends Pane{
		
		Circle ball;
		
		public Ball(){
			ball = new Circle(200, 200, Math.min(this.getHeight(), this.getWidth()) / 12);
		}
		
		private void paint(){
			ball = new Circle(ball.getCenterX(), ball.getCenterY(), Math.min(this.getHeight(), this.getWidth()) / 12);
			ball.setFill(Color.WHITE);
			ball.setStroke(Color.BLACK);
			this.getChildren().clear();
			this.getChildren().add(ball);
			this.requestFocus();
		}
		
		@Override
		public void setWidth(double width) {
			super.setWidth(width);
			paint();
		}
	
		@Override
		public void setHeight(double height) {
			super.setHeight(height);
			paint();
		}
		
		class KeyEventHandler implements EventHandler<KeyEvent>{
			@Override
			public void handle(KeyEvent e){
				switch(e.getCode()){
					case UP:
						if(!((ball.getCenterY() - ball.getRadius()) < 10))
						{
							ball.setCenterY(ball.getCenterY() - 10);
						}
						else{
							ball.setCenterY(ball.getRadius());
						}
						break;
					case DOWN: 
						
						if(!((ball.getCenterY() + ball.getRadius()) > getHeight() - 10)){
							ball.setCenterY(ball.getCenterY() + 10); 
						}
						else{
							ball.setCenterY(getHeight() - ball.getRadius());
						}
						break;
					case LEFT: 
						
						if(!((ball.getCenterX() - ball.getRadius()) < 10)){
							ball.setCenterX(ball.getCenterX() - 10);
						}
						else{
							ball.setCenterX(ball.getRadius());
						}
						break;
					case RIGHT: 
						
						if(!((ball.getCenterX() + ball.getRadius()) > getWidth() - 10)){
							ball.setCenterX(ball.getCenterX() + 10); 
						}
						else{
							ball.setCenterX(getWidth() - ball.getRadius());
						}
						break;
					default:
				}
				
			}
		}
		
		class ButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){
			if(((Button)e.getSource()).getText().equals("UP")){
				if(!((ball.getCenterY() - ball.getRadius()) < 10))
				{
					ball.setCenterY(ball.getCenterY() - 10);
				}
				else{
					ball.setCenterY(ball.getRadius());
				}
			}
			else if(((Button)e.getSource()).getText().equals("DOWN")){
				if(!((ball.getCenterY() + ball.getRadius()) > getHeight() - 10)){
					ball.setCenterY(ball.getCenterY() + 10); 
				}
				else{
					ball.setCenterY(getHeight() - ball.getRadius());
				}
			}
			else if(((Button)e.getSource()).getText().equals("LEFT")){
				if(!((ball.getCenterX() - ball.getRadius()) < 10)){
					ball.setCenterX(ball.getCenterX() - 10);
				}
				else{
					ball.setCenterX(ball.getRadius());
				}
			}
			else{
				if(!((ball.getCenterX() + ball.getRadius()) > getWidth() - 10)){
					ball.setCenterX(ball.getCenterX() + 10); 
				}
				else{
					ball.setCenterX(getWidth() - ball.getRadius());
				}
			}
		}
	}
	}
	
	
	
	
}
