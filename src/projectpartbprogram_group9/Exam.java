package projectpartbprogram_group9;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
import javafx.scene.control.*;
import java.util.Timer;
import java.util.TimerTask;

public class Exam extends Stage {
    private final File myf = new File("./data", "questions.txt");
    private int totQues = 0;
    private int activeQ = 1;
    private Label labQuesNo, labQues, labName, labNationality, labGender, labTimer;
    private ImageView imgQues, choiceImg1, choiceImg2, choiceImg3, choiceImg4, labNationalityImage;
    private Label labA, labB, labC, labD;
    private RadioButton radChoiceA, radChoiceB, radChoiceC, radChoiceD;
    private ToggleGroup grpChoices;
    private Button btnPrev, btnNext, btnSubmit;
    private Pane mainPane;
    private Pane choicePane;
    private Scene mainScene;
    private Login loginScreen;
    private CandidateDetails detailsSelectionScreen;
    private Integer birthYear;

    private LinkedList<Questions> quesList = new LinkedList<Questions>();
    Timer timer;
    // to display double digit on the timer
    DecimalFormat dFormat = new DecimalFormat("00");
    String dSeconds, dMinutes;

    public Exam() {
        this.setTitle("Citizenship Test");

        // Displays the Name of the Candidate
        Label labNameDesc = new Label("Name: ");
        labNameDesc.setLayoutX(25);
        labNameDesc.setLayoutY(25);
        labName = new Label("");
        labName.setLayoutX(90);
        labName.setLayoutY(25);
        labName.setStyle("-fx-background-color:\r\n"
                + "        linear-gradient(#f0ff35, #a9ff00),\r\n"
                + "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\r\n"
                + "    -fx-background-radius: 6, 5;\r\n"
                + "    -fx-background-insets: 0, 1;\r\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\r\n"
                + "    -fx-text-fill: #395306;-fx-padding: 3 7 3 7;");

        // label description for nationality
        Label labN = new Label("Nationality: ");
        labN.setLayoutX(25);
        labN.setLayoutY(50);
        labNationality = new Label("");
        labNationality.setLayoutX(90);
        labNationality.setLayoutY(50);
        labNationality.setStyle("-fx-background-color:\r\n"
                + "        linear-gradient(#f0ff35, #a9ff00),\r\n"
                + "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\r\n"
                + "    -fx-background-radius: 6, 5;\r\n"
                + "    -fx-background-insets: 0, 1;\r\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\r\n"
                + "    -fx-text-fill: #395306;-fx-padding: 3 7 3 7;");

        // Display the nationality's flag
        labNationalityImage = new ImageView();
        labNationalityImage.setLayoutX(200);
        labNationalityImage.setLayoutY(50);
        labNationalityImage.setFitHeight(25);
        labNationalityImage.setFitWidth(45);

        // Displays the candidate's gender
        Label labG = new Label("Gender: ");
        labG.setLayoutX(25);
        labG.setLayoutY(75);
        labGender = new Label("");
        labGender.setLayoutX(90);
        labGender.setLayoutY(75);
        labGender.setStyle("-fx-background-color:\r\n"
                + "        linear-gradient(#f0ff35, #a9ff00),\r\n"
                + "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\r\n"
                + "    -fx-background-radius: 6, 5;\r\n"
                + "    -fx-background-insets: 0, 1;\r\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\r\n"
                + "    -fx-text-fill: #395306;-fx-padding: 3 7 3 7;");

        // displays the question numbers
        labQuesNo = new Label("");
        labQuesNo.setLayoutX(330);
        labQuesNo.setLayoutY(25);
        labQuesNo.setStyle("-fx-font-family:serif;-fx-text-fill:#0000ff;");

        // display the time tracker
        labTimer = new Label("10:00");
        labTimer.setLayoutX(625);
        labTimer.setLayoutY(25);
        labTimer.setStyle("-fx-background-color: \r\n"
                + "        #000000,\r\n"
                + "        linear-gradient(#7ebcea, #2f4b8f),\r\n"
                + "        linear-gradient(#426ab7, #263e75),\r\n"
                + "        linear-gradient(#395cab, #223768);\r\n"
                + "    -fx-background-insets: 0,1,2,3;\r\n"
                + "    -fx-background-radius: 3,2,2,2;\r\n"
                + "    -fx-padding: 12 30 12 30;\r\n"
                + "    -fx-text-fill: white;\r\n"
                + "    -fx-font-size: 12px;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 0, 0.0 , 0 , 1);");

        // displays the questions itself
        labQues = new Label("");
        labQues.setLayoutX(25);
        labQues.setLayoutY(110);
        labQues.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");

        // displays the images
        imgQues = new ImageView();
        imgQues.setLayoutX(45);
        imgQues.setLayoutY(75);
        imgQues.setFitHeight(150);
        imgQues.setFitWidth(180);

        // choices when they are images
        // positioning and styling of the choiceImgs can be done here
        choiceImg1 = new ImageView();
        choiceImg1.setLayoutX(90);
        choiceImg1.setLayoutY(125);
        choiceImg1.setFitHeight(125);
        choiceImg1.setFitWidth(180);

        choiceImg2 = new ImageView();
        choiceImg2.setLayoutX(400);
        choiceImg2.setLayoutY(125);
        choiceImg2.setFitHeight(125);
        choiceImg2.setFitWidth(180);

        choiceImg3 = new ImageView();
        choiceImg3.setLayoutX(125);
        choiceImg3.setLayoutY(300);
        choiceImg3.setFitHeight(125);
        choiceImg3.setFitWidth(180);

        choiceImg4 = new ImageView();
        choiceImg4.setLayoutX(400);
        choiceImg4.setLayoutY(300);
        choiceImg4.setFitHeight(125);
        choiceImg4.setFitWidth(180);

        // radio section
        labA = new Label("A");
        labA.setLayoutX(25);
        labA.setStyle(
                "-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceA = new RadioButton("");
        radChoiceA.setLayoutX(50);

        labB = new Label("B");
        labB.setLayoutX(25);
        labB.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceB = new RadioButton("");
        radChoiceB.setLayoutX(50);

        labC = new Label("C");
        labC.setLayoutX(25);
        labC.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceC = new RadioButton("");
        radChoiceC.setLayoutX(50);

        labD = new Label("D");
        labD.setLayoutX(25);
        labD.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceD = new RadioButton("");
        radChoiceD.setLayoutX(50);

        grpChoices = new ToggleGroup();
        radChoiceA.setToggleGroup(grpChoices);
        radChoiceA.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceB.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceC.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceD.setStyle("-fx-font-size: 14pt;-fx-font-weight:bold;");
        radChoiceB.setToggleGroup(grpChoices);
        radChoiceC.setToggleGroup(grpChoices);
        radChoiceD.setToggleGroup(grpChoices);

        choicePane = new Pane();
        choicePane.setLayoutX(25);
        choicePane.setLayoutY(75);
        choicePane.getChildren().add(imgQues);
        choicePane.getChildren().add(choiceImg1);
        choicePane.getChildren().add(choiceImg2);
        choicePane.getChildren().add(choiceImg3);
        choicePane.getChildren().add(choiceImg4);
        choicePane.getChildren().add(labA);
        choicePane.getChildren().add(radChoiceA);
        choicePane.getChildren().add(labB);
        choicePane.getChildren().add(radChoiceB);
        choicePane.getChildren().add(labC);
        choicePane.getChildren().add(radChoiceC);
        choicePane.getChildren().add(labD);
        choicePane.getChildren().add(radChoiceD);

        btnPrev = new Button("Prev");
        btnPrev.setLayoutX(25);
        btnPrev.setLayoutY(550);
        btnPrev.setStyle("-fx-padding: 12 30 12 30;\r\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\n"
                + "    -fx-background-radius: 8;\r\n"
                + "    -fx-background-color: \r\n"
                + "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\r\n"
                + "        #9d4024,\r\n"
                + "        #d86e3a,\r\n"
                + "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\r\n"
                + "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n"
                + "    -fx-font-weight: bold;\r\n"
                + "    -fx-font-size: 14px;-fx-text-fill: white;");
        btnPrev.setDisable(true);
        btnNext = new Button("Next");
        btnNext.setLayoutX(125);
        btnNext.setLayoutY(550);
        btnNext.setStyle("-fx-padding: 12 30 12 30;\r\n"
                + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\n"
                + "    -fx-background-radius: 8;\r\n"
                + "    -fx-background-color: \r\n"
                + "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\r\n"
                + "        #9d4024,\r\n"
                + "        #d86e3a,\r\n"
                + "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\r\n"
                + "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n"
                + "    -fx-font-weight: bold;\r\n"
                + "    -fx-font-size: 14px;-fx-text-fill: white;");
        btnSubmit = new Button("Submit");
        btnSubmit.setLayoutX(300);
        btnSubmit.setLayoutY(550);
        btnSubmit.setStyle(
                "-fx-padding: 12 30 12 30;\r\n"
                        + "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\r\n"
                        + "    -fx-background-radius: 8;\r\n"
                        + "    -fx-background-color: \r\n"
                        + "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\r\n"
                        + "        #9d4024,\r\n"
                        + "        #d86e3a,\r\n"
                        + "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\r\n"
                        + "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\r\n"
                        + "    -fx-font-weight: bold;\r\n"
                        + "    -fx-font-size: 14px;-fx-text-fill: white;");

        readFromFile();
        radChoiceA.setOnAction(e -> {
            quesList.get(activeQ - 1).setUserAnswer('A');
            quesList.get(activeQ - 1).setSelected(0, true);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, false);
        });
        radChoiceB.setOnAction(e -> {
            quesList.get(activeQ - 1).setUserAnswer('B');
            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, true);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, false);
        });
        radChoiceC.setOnAction(e -> {
            quesList.get(activeQ - 1).setUserAnswer('C');
            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, true);
            quesList.get(activeQ - 1).setSelected(3, false);
        });
        radChoiceD.setOnAction(e -> {
            quesList.get(activeQ - 1).setUserAnswer('D');
            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, true);
        });
        if (totQues == 1) {
            btnNext.setDisable(true);
        }
        btnNext.setOnAction(e -> {
            activeQ++;
            btnPrev.setDisable(false);
            if (activeQ == totQues) {
                btnNext.setDisable(true);
            }
            reloadQuestions();
        });
        btnPrev.setOnAction(e -> {
            activeQ--;
            btnNext.setDisable(false);
            if (activeQ == 1) {
                btnPrev.setDisable(true);
            }
            reloadQuestions();
        });
        btnSubmit.setOnAction(e -> {
            // this is where it relays into the result page
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setTitle("Please Confirm Your Submission");
            a.setHeaderText("");
            a.setContentText("Are you sure you wish to proceed to submit?");

            Optional<ButtonType> result = a.showAndWait();

            if (!result.isPresent()) {
                // if user presses the X button
                return;
            } else if (result.get() == ButtonType.OK) {
                if (timer != null)
                    timer.cancel();
                labTimer.setText("Submitted. Exam ends.");
                handleSubmit();
            } else if (result.get() == ButtonType.CANCEL) {
                return;
                // ntg should happen
            }
        });

        // add all the children
        mainPane = new Pane();
        mainPane.getChildren().add(labNameDesc);
        mainPane.getChildren().add(labG);
        mainPane.getChildren().add(labN);
        mainPane.getChildren().add(labName);
        mainPane.getChildren().add(labNationality);
        mainPane.getChildren().add(labNationalityImage);
        mainPane.getChildren().add(labGender);
        mainPane.getChildren().add(labQuesNo);
        mainPane.getChildren().add(labTimer);
        mainPane.getChildren().add(labQues);
        mainPane.getChildren().add(choicePane);
        mainPane.getChildren().add(btnNext);
        mainPane.getChildren().add(btnPrev);
        mainPane.getChildren().add(btnSubmit);

        mainScene = new Scene(mainPane, 800, 700);
        this.setScene(mainScene);
        mainPane.setBackground(new Background(
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

        this.setFullScreen(true);

        // handles when user clicks the close window button
        this.setOnCloseRequest(e -> {
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setTitle("Warning");
            a.setHeaderText("");
            a.setContentText("Exiting the application will cause you to lose all progress. Confirm exit?");

            Optional<ButtonType> result = a.showAndWait();
            if (result.get() == ButtonType.OK) {
                timer.cancel();
                this.hide();
            } else {
                e.consume();
            }
        });
        reloadQuestions();

        // the screens that should appear before the exam form appears.

        try {
            loginScreen = new Login();

            loginScreen.setOnHiding(e -> {
                labName.setText(loginScreen.getUsername());
                detailsSelectionScreen = new CandidateDetails();

                detailsSelectionScreen.setOnHiding(ev -> {

                    labNationality.setText(detailsSelectionScreen.getNationality());
                    if ((detailsSelectionScreen.getNationality() == "South Korea")) {
                        labNationalityImage
                                .setImage(new Image(new File("./data/images/southkorea.jpg").toURI().toString()));
                    } else if ((detailsSelectionScreen.getNationality() == "Rwanda")) {
                        labNationalityImage
                                .setImage(new Image(new File("./data/images/rwanda.jpg").toURI().toString()));
                    } else if ((detailsSelectionScreen.getNationality() == "Cape Verde")) {
                        labNationalityImage
                                .setImage(new Image(new File("./data/images/capeverde.jpg").toURI().toString()));
                    } else if ((detailsSelectionScreen.getNationality() == "Kyrgyzstan")) {
                        labNationalityImage
                                .setImage(new Image(new File("./data/images/kyrgyzstan.png").toURI().toString()));
                    } else if ((detailsSelectionScreen.getNationality() == "Nicaragua")) {
                        labNationalityImage
                                .setImage(new Image(new File("./data/images/nicaragua.png").toURI().toString()));
                    } else if ((detailsSelectionScreen.getNationality() == "Guatemala")) {
                        labNationalityImage
                                .setImage(new Image(new File("./data/images/guatemala.png").toURI().toString()));
                    }
                    labGender.setText(detailsSelectionScreen.getGender());
                    birthYear = detailsSelectionScreen.getBirthYear();

                    this.show();

                    // start the timer once logged in
                    timeTracker();
                });
            });
        } catch (IOException e) {
            System.out.println("IO Exception Occured\n" + e);
        }

    }

    public void reloadQuestions() {
        labQuesNo.setText("Question " + Integer.toString(activeQ) + "/" + Integer.toString(totQues));
        labQues.setText(quesList.get(activeQ - 1).getQuestions());
        radChoiceA.setText(quesList.get(activeQ - 1).getChoice(0));
        radChoiceB.setText(quesList.get(activeQ - 1).getChoice(1));
        radChoiceC.setText(quesList.get(activeQ - 1).getChoice(2));
        radChoiceD.setText(quesList.get(activeQ - 1).getChoice(3));
        imgQues.setImage(null);
        choiceImg1.setImage(null);
        choiceImg2.setImage(null);
        choiceImg3.setImage(null);
        choiceImg4.setImage(null);
        if (quesList.get(activeQ - 1).getType() == 1) {

            // position the choices appropriately
            labA.setLayoutY(75);
            radChoiceA.setLayoutY(75);

            labB.setLayoutY(75);
            radChoiceB.setLayoutY(75);

            labC.setLayoutY(175);
            radChoiceC.setLayoutY(175);

            labD.setLayoutY(175);
            radChoiceD.setLayoutY(175);

            radChoiceA.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

            radChoiceB.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

            radChoiceC.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

            radChoiceD.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        }
        if (quesList.get(activeQ - 1).getType() == 2) {
            File pFile = new File("data/images/" + quesList.get(activeQ - 1).getQuesPic());
            Image img = new Image(pFile.toURI().toString());

            imgQues.setImage(img);

            // position the choices appropriately
            labA.setLayoutY(275);
            radChoiceA.setLayoutY(275);
            radChoiceA.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
            labB.setLayoutY(275);
            radChoiceB.setLayoutY(275);
            radChoiceB.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
            labC.setLayoutY(375);
            radChoiceC.setLayoutY(375);
            radChoiceC.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
            labD.setLayoutY(375);
            radChoiceD.setLayoutY(375);
            radChoiceD.setStyle(" -fx-background-color: \r\n"
                    + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                    + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                    + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                    + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                    + "    -fx-background-insets: 0,1,4,5;\r\n"
                    + "    -fx-background-radius: 9,8,5,4;\r\n"
                    + "    -fx-padding: 15 30 15 30;\r\n"
                    + "    -fx-font-family: \"Helvetica\";\r\n"
                    + "    -fx-font-size: 12px;\r\n"
                    + "    -fx-font-weight: bold;\r\n"
                    + "    -fx-text-fill: #333333;\r\n"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        }
        if (quesList.get(activeQ - 1).getType() == 3) {
            // setting all these elements to null as only the choicesImg is needed
            imgQues.setImage(null);
            radChoiceA.setText(null);
            radChoiceB.setText(null);
            radChoiceC.setText(null);
            radChoiceD.setText(null);

            labA.setLayoutX(25);
            labC.setLayoutX(25);

            radChoiceA.setStyle("");
            radChoiceB.setStyle("");
            radChoiceC.setStyle("");
            radChoiceD.setStyle("");

            File pFile = new File("data/images/" + quesList.get(activeQ - 1).getChoice(0));
            choiceImg1.setImage(new Image(pFile.toURI().toString()));
            pFile = new File("data/images/" + quesList.get(activeQ - 1).getChoice(1));
            choiceImg2.setImage(new Image(pFile.toURI().toString()));
            pFile = new File("data/images/" + quesList.get(activeQ - 1).getChoice(2));
            choiceImg3.setImage(new Image(pFile.toURI().toString()));
            pFile = new File("data/images/" + quesList.get(activeQ - 1).getChoice(3));
            choiceImg4.setImage(new Image(pFile.toURI().toString()));

            // position the choices appropriately
            labA.setLayoutY(75);
            radChoiceA.setLayoutY(75);
            choiceImg1.setLayoutY(75);
            choiceImg1.setLayoutX(100);

            labB.setLayoutX(325);
            labB.setLayoutY(75);
            radChoiceB.setLayoutX(350);
            radChoiceB.setLayoutY(75);
            choiceImg2.setLayoutY(75);

            labC.setLayoutY(300);
            radChoiceC.setLayoutY(300);
            choiceImg3.setLayoutX(100);

            labD.setLayoutX(325);
            labD.setLayoutY(300);
            radChoiceD.setLayoutX(350);
            radChoiceD.setLayoutY(300);

        }
        radChoiceA.setSelected(quesList.get(activeQ - 1).getSelected(0));
        radChoiceB.setSelected(quesList.get(activeQ - 1).getSelected(1));
        radChoiceC.setSelected(quesList.get(activeQ - 1).getSelected(2));
        radChoiceD.setSelected(quesList.get(activeQ - 1).getSelected(3));

    }
    // all essential methods below

    public void readFromFile() {
        Scanner sfile;
        int type;
        char answer;
        String theQues;
        String choices[] = new String[4];
        String choicesImg[] = new String[4];
        String quesPic;
        Questions ques;
        try {
            sfile = new Scanner(myf);
            String aLine = sfile.nextLine();
            Scanner sline = new Scanner(aLine);
            totQues = Integer.parseInt(sline.next());
            for (int k = 1; k <= totQues; k++) {
                aLine = sfile.nextLine();
                sline = new Scanner(aLine);
                sline.useDelimiter(":");
                type = Integer.parseInt(sline.next());
                answer = sline.next().charAt(0);
                theQues = sline.next();

                switch (type) {
                    case 2:
                        /*
                         * this is for when the picture appears before the user selects an answer, not
                         * when images are choices
                         */

                        quesPic = sline.next();
                        choices[0] = sline.next();
                        choices[1] = sline.next();
                        choices[2] = sline.next();
                        choices[3] = sline.next();
                        ques = new Questions(type, answer, theQues, choices, quesPic);
                        sline.close();
                        quesList.add(ques);
                        break;
                    case 3:
                        // this is for when the pictures are the choices
                        quesPic = "";
                        choicesImg[0] = sline.next();
                        choicesImg[1] = sline.next();
                        choicesImg[2] = sline.next();
                        choicesImg[3] = sline.next();
                        sline.close();
                        ques = new Questions(type, answer, theQues, choicesImg, quesPic);
                        quesList.add(ques);
                        break;
                    default:
                        // default behaviour. no pictures whatsover.
                        quesPic = "";
                        choices[0] = sline.next();
                        choices[1] = sline.next();
                        choices[2] = sline.next();
                        choices[3] = sline.next();
                        sline.close();
                        ques = new Questions(type, answer, theQues, choices, quesPic);
                        quesList.add(ques);
                        break;
                }
            }
            sfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File to read " + myf + " not found!");
        }
    }

    // countdown timer
    public void timeTracker() {
        timer = new Timer();
        String musicFile = "./data/ding-36029.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);

        TimerTask task = new TimerTask() {
            int second = 0;
            int minute = 10;

            @Override
            public void run() {
                Platform.runLater(() -> {
                    second--;
                    if (second == -1) {
                        second = 59;
                        minute--;
                    }
                    if ((minute == 3 && second == 0)) {
                        // play sound
                        player.play();
                    }
                    if ((minute == 0 && second == 0)) {
                        timer.cancel();
                        // display alert box
                        Alert a = new Alert(AlertType.INFORMATION);
                        a.setTitle("TIME'S UP!");
                        a.setHeaderText("");
                        a.setContentText("Time is up! All of your answered answers are now automatically saved");
                        a.show();
                        handleSubmit();
                    }

                    dMinutes = dFormat.format(minute);
                    dSeconds = dFormat.format(second);
                    labTimer.setText("Time Left: " + dMinutes + ":" + dSeconds);
                });

                // System.out.println(dMinutes + ":" + dSeconds);
            };

        };

        timer.scheduleAtFixedRate(task, 0, 1000); // 0 means we execute this timer immediately once the method is called
    }

    // triggers once the submit the exam button is pressed
    void handleSubmit() {

        String currentUser = labName.getText();
        String currentNationality = labNationality.getText();
        String currentGender = labGender.getText();

        saveToFile(currentUser, currentNationality, currentGender);

        // hide the Exam screen.
        this.hide();

    }

    // store percentage and candidates' answers for each question
    public void saveToFile(String curU, String curN, String curG) {

        // convert the user's name to appropriate file naming convention
        // converts the users' first letter of each of their names to capitals.
        // if zi wei, it will become Zi Wei

        curU = curU.toLowerCase();
        curU = curU.trim();

        String[] u = curU.split("\\s");
        String cap = "";

        for (String i : u) {
            String first = i.substring(0, 1);
            String afterfirst = i.substring(1);
            cap += first.toUpperCase() + afterfirst + " ";
        }

        curU = cap;
        curU = curU.trim();
        String username = curU;
        curU = curU.replaceAll("\\s+", "_");
        // end of file naming convention code

        File fileToSave = new File("./data/results.txt");
        try {
            int totalQuestions = 30;
            int totalCorrect = 0;
            PrintWriter pw = new PrintWriter(new FileWriter(fileToSave, true));
            pw.println();
            // candidate_name, candidate_nationality, candidate_gender, candidate_birthYear,
            // q1_CorrectORWrong,
            // q2_CorrectORWrong, ..., candidate_result_percentage, candidate_pass_fail
            pw.print(username + ",");
            pw.print(curN + ",");
            pw.print(curG + ",");
            pw.print(birthYear + ",");

            for (int i = 0; i < quesList.size(); i++) {
                // int questionNumber = i + 1; this is so that the Question starts at 1, not 0.

                // this compares the answers between the user and the official answers
                if (quesList.get(i).getAnswer() == quesList.get(i).getUserAnswer()) {
                    // System.out.println("User got Question " + questionNumber + " Correct.");
                    pw.print("(" + quesList.get(i).getUserAnswer() + ")" + " " + "Correct" + ",");
                    totalCorrect++;
                } else if ((quesList.get(i).getAnswer() != quesList.get(i).getUserAnswer())
                        && quesList.get(i).getUserAnswer() != 0) {
                    // System.out.println("User got Question " + questionNumber + " Wrong.");
                    pw.print("(" + quesList.get(i).getUserAnswer() + ")" + " " + "Wrong" + ",");
                } else if (quesList.get(i).getUserAnswer() == 0) {
                    pw.print("(Not Answered) " + "Wrong" + ",");
                }
            }

            int getPercentage = (int) ((double) totalCorrect / totalQuestions * 100);

            pw.print(getPercentage + ",");

            if (getPercentage >= 70) {
                pw.print("Pass,");
            } else {
                pw.print("Fail,");
            }

            pw.close();

        } catch (Exception e) {
            System.out.println("A general error occured. Here is the error message\n" + e);
        }
    }

}
