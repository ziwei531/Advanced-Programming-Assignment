package projectpartbprogram_group9;

import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class CandidateDetails extends Stage {

    // private Pane paneCandidate;
    // private Scene candidateScene;
    private TextField birthyear;
    private Label labelResponseBY, labelResponseN, labelResponseG; // error response to birth year, nationality, gender
    public Stage stage;

    public CandidateDetails() {
        this.setTitle("Please Identify Yourself");

        // Dropdown list for gender
        Label labGender = new Label("Please select your gender:");
        labGender.setStyle(
                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
        ComboBox<String> gender = new ComboBox<String>();
        // Setting the prompt text of the combo box
        // gender.setPromptText("Select Gender");
        gender.setPrefWidth(300);
        gender.getItems().addAll("Male", "Female");
        gender.setStyle("-fx-background-color: \r\n"
                + "        linear-gradient(#ffd65b, #e68400),\r\n"
                + "        linear-gradient(#ffef84, #f2ba44),\r\n"
                + "        linear-gradient(#ffea6a, #efaa22),\r\n"
                + "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
                + "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
                + "    -fx-background-radius: 30;\r\n"
                + "    -fx-background-insets: 0,1,2,3,0;\r\n"
                + "    -fx-text-fill: #654b00;\r\n"
                + "    -fx-font-weight: bold;\r\n"
                + "    -fx-font-size: 14px;\r\n"
                + "    -fx-padding: 10 20 10 20;");
        gender.setOnAction(e -> {
            getG(gender.getSelectionModel().getSelectedItem());
        });

        // Dropdown list for gender
        Label labNationality = new Label("Please select your nationality:");
        labNationality.setStyle(
                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
        ComboBox<String> nationality = new ComboBox<String>();
        // Setting the prompt text of the combo box
        // nationality.setPromptText("Select Nationality");
        nationality.setPrefWidth(300);
        nationality.getItems().addAll("South Korea", "Rwanda", "Cape Verde", "Kyrgyzstan", "Nicaragua", "Guatemala");
        nationality.setStyle("-fx-background-color: \r\n"
                + "        linear-gradient(#ffd65b, #e68400),\r\n"
                + "        linear-gradient(#ffef84, #f2ba44),\r\n"
                + "        linear-gradient(#ffea6a, #efaa22),\r\n"
                + "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
                + "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
                + "    -fx-background-radius: 30;\r\n"
                + "    -fx-background-insets: 0,1,2,3,0;\r\n"
                + "    -fx-text-fill: #654b00;\r\n"
                + "    -fx-font-weight: bold;\r\n"
                + "    -fx-font-size: 14px;\r\n"
                + "    -fx-padding: 10 20 10 20;");
        nationality.setOnAction(e -> {
            getN(nationality.getSelectionModel().getSelectedItem());
        });

        // Label birth year
        Label labYear = new Label("Please enter your birth year:");
        labYear.setStyle(
                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
        birthyear = new TextField();
        birthyear.setPrefWidth(250);
        birthyear.setMaxWidth(250);
        birthyear.setStyle("-fx-background-color: \r\n"
                + "        linear-gradient(#ffd65b, #e68400),\r\n"
                + "        linear-gradient(#ffef84, #f2ba44),\r\n"
                + "        linear-gradient(#ffea6a, #efaa22),\r\n"
                + "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
                + "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
                + "    -fx-background-radius: 30;\r\n"
                + "    -fx-background-insets: 0,1,2,3,0;\r\n"
                + "    -fx-text-fill: #654b00;\r\n"
                + "    -fx-font-weight: bold;\r\n"
                + "    -fx-font-size: 14px;\r\n"
                + "    -fx-padding: 15 20 15 20;");
        labelResponseBY = new Label("");
        labelResponseG = new Label("");
        labelResponseN = new Label("");

        // set them to red as errors should be red.
        labelResponseBY.setStyle("-fx-text-fill: Red; -fx-font: 15px Impact;-fx-alignment: center;");
        labelResponseG.setStyle("-fx-text-fill: Red;-fx-alignment: center;-fx-font: 15px Impact;");
        labelResponseN.setStyle("-fx-text-fill: Red;-fx-font: 15px Impact;-fx-alignment: center;");

        Button buttonSubmit = new Button("Submit");
        buttonSubmit.setStyle(
                "-fx-pref-width: 155px;-fx-font-size:15px;-fx-border-radius: 3px;-fx-background-color: #090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n"
                        + "        linear-gradient(#20262b, #191d22),\r\n"
                        + "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0)) ;-fx-padding: 10 20 10 20;-fx-text-fill: linear-gradient(white, #d0d0d0);"
                        + " -fx-background-radius: 5,4,3,5;\r\n"
                        + "    -fx-background-insets: 0,1,2,0;\r\n"
                        + "    -fx-text-fill: white;\r\n"
                        + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n"
                        + "    -fx-font-family: \"Arial\";");
        buttonSubmit.setOnAction(e -> {
            try {
                if (!birthyear.getText().isEmpty() && (!gender.getSelectionModel().isEmpty())
                        && (!nationality.getSelectionModel().isEmpty())
                        && (Integer.parseInt(birthyear.getText()) >= 1932
                                && Integer.parseInt(birthyear.getText()) <= 2003)) {
                    labelResponseBY.setText("");
                    labelResponseN.setText("");
                    labelResponseG.setText("");
                    this.hide();
                } else {
                    if (birthyear.getText().isEmpty()) {
                        labelResponseBY.setText("Please do not leave the birth year selection empty");
                    } else if (Integer.parseInt(birthyear.getText()) <= 1932
                            || Integer.parseInt(birthyear.getText()) >= 2005) {
                        // for the purpose of this assignment, we assume candidates can't be 90 years
                        // old and beyond, must be 18 and beyond.
                        labelResponseBY.setText("Please enter an appropriate birth year");
                    } else {
                        labelResponseBY.setText("");
                    }

                    if (gender.getSelectionModel().isEmpty()) {
                        labelResponseG.setText("Please select a gender");
                    } else {
                        labelResponseG.setText("");
                    }

                    if (nationality.getSelectionModel().isEmpty()) {
                        labelResponseN.setText("Please select a nationality");
                    } else {
                        labelResponseN.setText("");
                    }

                }
            } catch (NumberFormatException err) {
                labelResponseBY.setText("Please enter a numeric input");
            }

        });

        VBox myVBox = new VBox(labGender, gender, labelResponseG, labNationality, nationality, labelResponseN, labYear,
                birthyear, labelResponseBY, buttonSubmit);
        myVBox.setAlignment(Pos.CENTER);
        this.setScene(new Scene(myVBox, 500, 500));
        myVBox.setSpacing(20);
        myVBox.setBackground(new Background(
                new BackgroundImage(
                        new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_06_1920x1080.png"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)),
                new BackgroundImage(
                        new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_05_1920x1080.png"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)),
                new BackgroundImage(
                        new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_04_1920x1080.png"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)),
                new BackgroundImage(
                        new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_03_1920x1080.png"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)),
                new BackgroundImage(
                        new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_02_1920x1080.png"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)),
                new BackgroundImage(
                        new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_01_1920x1080.png"),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));

        this.setOnCloseRequest(e -> {
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setTitle("Warning");
            a.setHeaderText("");
            a.setContentText("Exiting the application will cause you to lose all progress. Confirm exit?");

            Optional<ButtonType> result = a.showAndWait();
            if (result.get() == ButtonType.OK) {
                Platform.exit();
                return;
            } else {
                e.consume();
            }

        });

        this.show();
    }

    String nationality;
    String gender;

    public void getN(String N) {
        nationality = N;
    }

    public void getG(String G) {
        gender = G;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGender() {
        return gender;
    }

    public Integer getBirthYear() {
        if (birthyear.getText().equals("")) {
            return 0;
        } else {
            return Integer.parseInt(birthyear.getText());
        }

    }

}
