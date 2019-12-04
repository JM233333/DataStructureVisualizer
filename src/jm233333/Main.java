package jm233333;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import jm233333.ui.SceneVisualizer;

/**
 * The {@code Main} class includes the entrance and the main process of the application.
 */
public class Main extends Application {
    /**
     * Initialization of the application.
     * @param primaryStage the stage of the application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // initialize scene
        Group root = new Group();
        Scene scene = new SceneVisualizer(root, 480, 320);
        // initialize stage
        primaryStage.setTitle("Hello GG");
        primaryStage.setScene(scene);
        primaryStage.show();
        //
        scene.widthProperty().addListener((ov, t, t1) -> {
            System.out.println("Window Size Change:" + t.toString() + "," + t1.toString());
            System.out.println(".");
        });
    }
    /**
     * The main function of the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
