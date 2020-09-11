/**
*	Author: Christian Harris
*	Date Created: 9 September 2020
*	This program animates a rectangle moving along a pentagonal path. The opacity of the rectangle changes as it moves. A right click will pause the animation
*	while a left click will resume the animation.
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.collections.ObservableList;
import javafx.scene.input.*;

public class Exercise_15_Animation extends Application{
	public void start(Stage primaryStage){
		Polygon polygon = new Polygon();
		ObservableList<Double> list = polygon.getPoints();
		for (int i = 0; i < 5; i++) {
			list.add(200 + 50 * Math.cos(2 * i * Math.PI / 5)); 
			list.add(200 - 50 * Math.sin(2 * i * Math.PI / 5));
		}
		
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.GREEN);
		rectangle.setStroke(Color.BLACK);
		
		Pane pane = new Pane();
		
		pane.getChildren().add(polygon);
		pane.getChildren().add(rectangle);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(polygon);
		pt.setNode(rectangle);
		pt.setCycleCount(Timeline.INDEFINITE);
		
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(4000));
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setNode(rectangle);
		
		ParallelTransition parallel = new ParallelTransition();
		parallel.getChildren().addAll(pt, ft);
		parallel.setCycleCount(Timeline.INDEFINITE);
		parallel.play();
		
		pane.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)){
				parallel.play();
			}
			else if(e.getButton().equals(MouseButton.SECONDARY)){
				parallel.pause();
			}
			else{}
		});
		
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("PathTransitionDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}