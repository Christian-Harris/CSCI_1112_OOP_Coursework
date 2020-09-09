/**
*	Author: Christian Harris
*	Date Created: 9 September 2020
*	This program
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.input.*;

public class Exercise_15_Listeners extends Application{
	@Override
	public void start(Stage primaryStage){
		//Pane pane = new Pane();
		Ball myBall = new Ball();
		
		myBall.setOnKeyPressed(myBall.new KeyEventHandler());
		
		Scene scene = new Scene(myBall, 400, 400);
		
		
		
		primaryStage.setTitle("Exercise_15_Listeners");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		myBall.requestFocus();
	}
	
	class Ball extends Pane{
		
		Circle ball;
		
		private void paint(){	
			ball = new Circle(this.getWidth() / 2, this.getHeight() / 2, Math.min(this.getHeight(), this.getWidth()) / 12);
			ball.setFill(Color.WHITE);
			ball.setStroke(Color.BLACK);
			
			this.getChildren().clear();
			this.getChildren().add(ball);
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
						}break;
					case LEFT: 
						if(!((ball.getCenterX() - ball.getRadius()) < 10)){
							ball.setCenterX(ball.getCenterX() - 10);
						}
						else{
							ball.setCenterX(ball.getRadius());
						}break;
					case RIGHT: 
						if(!((ball.getCenterX() + ball.getRadius()) > getWidth() - 10)){
							ball.setCenterX(ball.getCenterX() + 10); 
						}
						else{
							ball.setCenterX(getWidth() - ball.getRadius());
						}break;
					default:
				}
				
			}
		}
	}
	
	
}
