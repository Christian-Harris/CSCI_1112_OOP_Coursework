/**
*	Author: Christian Harris
*	Date Created: 9 September 2020
*	This program 
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.animation.*;
import javafx.event.*;

public class Exercise_16_21 extends Application{
	private static final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
	Timeline timeline;
	int startTime = 0;
	@Override
	public void start(Stage primaryStage){
		Media media = new Media(MEDIA_URL);
		MediaPlayer player = new MediaPlayer(media);
		//MediaView mediaView = new MediaView(player);
		
		TextField textField = new TextField();
		textField.setStyle("-fx-alignment: center; -fx-font-size: 24");
		textField.setPrefSize(200, 200);
		
		Pane pane = new Pane();
		pane.getChildren().add(textField);
		
		textField.setOnAction(e -> {
			if(!textField.getText().matches("[0-9]+")){
				textField.setText("Not a number.");
			}
			else{
				textField.setDisable(true);
				startTime = Integer.valueOf(textField.getText());
				timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent e){
						if(startTime <= 1){
							timeline.stop();
							player.play();
						}
						textField.setText(Integer.toString(--startTime));
					}
				}));
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.play();
			}
		});
		
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Exercise_16_21");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//player.play();
		
	}
}