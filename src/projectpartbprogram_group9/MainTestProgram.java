/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectpartbprogram_group9;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 */
public class MainTestProgram extends Application {
    private Exam examScreen;
    private Analysis analysisScreen;

    @Override
    public void start(Stage primaryStage) throws Exception {
        examScreen = new Exam();

        examScreen.setOnHiding(e -> {
            analysisScreen = new Analysis();
        });
    }

    public static void main(String args[]) {
        Application.launch(args);
    }
}
