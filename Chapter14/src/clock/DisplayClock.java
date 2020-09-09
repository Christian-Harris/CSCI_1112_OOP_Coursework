package clock;
/*
*	Edited By: Christian Harris
*	Date: 9 September 2020
*	This program edits the DisplayClock.java file to generate the image of a clock.
*	Only the hour and minute hands will display. The hour is betwen 0 and 11
*	while the minute is either 0 or 30.
*/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.lang.Math;

public class DisplayClock extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
	// Generate random values for the hour, minute, and seconds.
	int randomHour = (int)(Math.random() * 12);
	int randomMinute = ((int)(Math.random() * 2)) * 30;
	int randomSecond = (int)(Math.random() * 60);
    // Create a clock and a label
    ClockPane clock = new ClockPane(randomHour, randomMinute, randomSecond, true, false, true);
    String timeString = clock.getHour() + ":" + clock.getMinute() 
      + ":" + clock.getSecond();
    Label lblCurrentTime = new Label(timeString);

    // Place clock and label in border pane
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(lblCurrentTime);
    BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("DisplayClock"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
}