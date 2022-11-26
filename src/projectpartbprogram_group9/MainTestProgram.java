/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectpartbprogram_group9;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

/**
 *
 */
public class MainTestProgram extends Application {
    private final File myf = new File("./data", "questions.txt");
    private int totQues = 0;
    private int activeQ = 1;
    private Label labQuesNo, labQues, labName, labNationality, labGender, labTimer;
    private ImageView imgQues, choiceImg1, choiceImg2, choiceImg3, choiceImg4;
    private Label labA, labB, labC, labD;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private ToggleGroup grpChoices;
    private Button btnPrev, btnNext, btnSubmit;
    private Pane mainPane;
    private Pane paneC;
    private Scene mainScene;
    private Login loginScreen;

    private LinkedList<Questions> quesList = new LinkedList<Questions>();
    Timer timer;
    // to display double digit on the timer
    DecimalFormat dFormat = new DecimalFormat("00");
    String dSeconds, dMinutes;

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Citizenship Test");

        // displays at the top left corner
        Label labNameDesc = new Label("Name: ");
        labNameDesc.setLayoutX(25);
        labNameDesc.setLayoutY(25);
        labName = new Label("");
        labName.setLayoutX(75);
        labName.setLayoutY(25);
        labName.setStyle("-fx-pref-width: 100px;-fx-border-color:red;");

        // label description for nationality
        Label labN = new Label("Nationality: ");
        labN.setLayoutX(200);
        labN.setLayoutY(25);
        labNationality = new Label("");
        labNationality.setLayoutX(280);
        labNationality.setLayoutY(25);
        labNationality.setStyle("-fx-pref-width: 100px;-fx-border-color:red;");

        Label labG = new Label("Gender: ");
        labG.setLayoutX(400);
        labG.setLayoutY(25);
        labGender = new Label("");
        labGender.setLayoutX(460);
        labGender.setLayoutY(25);
        labGender.setStyle("-fx-pref-width: 100px;-fx-border-color:red;");

        // displays the question numbers
        labQuesNo = new Label("");
        labQuesNo.setLayoutX(25);
        labQuesNo.setLayoutY(75);
        labQuesNo.setStyle("-fx-font-family:serif;-fx-text-fill:#0000ff;");

        // display the time tracker
        labTimer = new Label("05:00");
        labTimer.setLayoutX(125);
        labTimer.setLayoutY(75);
        labTimer.setStyle("-fx-font-family:serif;-fx-font-size:18px;-fx-text-fill:#e62c38;");

        // displays the questions itself
        labQues = new Label("");
        labQues.setLayoutX(25);
        labQues.setLayoutY(100);
        labQues.setStyle("-fx-font-size: 12pt;-fx-font-weight:bold;");

        // displays the images
        imgQues = new ImageView();
        imgQues.setLayoutX(25);
        imgQues.setLayoutY(75);
        imgQues.setFitHeight(150);
        imgQues.setFitWidth(150);

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
        radChoice1 = new RadioButton("");
        radChoice1.setLayoutX(50);

        labB = new Label("B");
        labB.setLayoutX(25);
        radChoice2 = new RadioButton("");
        radChoice2.setLayoutX(50);

        labC = new Label("C");
        labC.setLayoutX(25);
        radChoice3 = new RadioButton("");
        radChoice3.setLayoutX(50);

        labD = new Label("D");
        labD.setLayoutX(25);
        radChoice4 = new RadioButton("");
        radChoice4.setLayoutX(50);

        grpChoices = new ToggleGroup();
        radChoice1.setToggleGroup(grpChoices);
        radChoice2.setToggleGroup(grpChoices);
        radChoice3.setToggleGroup(grpChoices);
        radChoice4.setToggleGroup(grpChoices);

        paneC = new Pane();
        paneC.setLayoutX(25);
        paneC.setLayoutY(75);
        paneC.getChildren().add(imgQues);
        paneC.getChildren().add(choiceImg1);
        paneC.getChildren().add(choiceImg2);
        paneC.getChildren().add(choiceImg3);
        paneC.getChildren().add(choiceImg4);
        paneC.getChildren().add(labA);
        paneC.getChildren().add(radChoice1);
        paneC.getChildren().add(labB);
        paneC.getChildren().add(radChoice2);
        paneC.getChildren().add(labC);
        paneC.getChildren().add(radChoice3);
        paneC.getChildren().add(labD);
        paneC.getChildren().add(radChoice4);

        btnPrev = new Button("Prev");
        btnPrev.setLayoutX(25);
        btnPrev.setLayoutY(550);
        btnPrev.setStyle("-fx-pref-width: 75px;");
        btnPrev.setDisable(true);
        btnNext = new Button("Next");
        btnNext.setLayoutX(125);
        btnNext.setLayoutY(550);
        btnNext.setStyle("-fx-pref-width: 75px;");
        btnSubmit = new Button("End");
        btnSubmit.setLayoutX(300);
        btnSubmit.setLayoutY(550);
        btnSubmit.setStyle(
                "-fx-pref-width: 100px;-fx-font-size:24px;-fx-border-radius: 3px;-fx-background-color: #9D9D9C;-fx-padding: 10px 15px;-fx-text-fill: white;");

        readFromFile();
        radChoice1.setOnAction(e -> {
            quesList.get(activeQ - 1).setUserAnswer('A');
            quesList.get(activeQ - 1).setSelected(0, true);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, false);
        });
        radChoice2.setOnAction(e -> {
            quesList.get(activeQ - 1).setUserAnswer('B');
            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, true);
            quesList.get(activeQ - 1).setSelected(2, false);
            quesList.get(activeQ - 1).setSelected(3, false);
        });
        radChoice3.setOnAction(e -> {
            quesList.get(activeQ - 1).setUserAnswer('C');
            quesList.get(activeQ - 1).setSelected(0, false);
            quesList.get(activeQ - 1).setSelected(1, false);
            quesList.get(activeQ - 1).setSelected(2, true);
            quesList.get(activeQ - 1).setSelected(3, false);
        });
        radChoice4.setOnAction(e -> {
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
            reloadQues();
        });
        btnPrev.setOnAction(e -> {
            activeQ--;
            btnNext.setDisable(false);
            if (activeQ == 1) {
                btnPrev.setDisable(true);
            }
            reloadQues();
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
        mainPane.getChildren().add(labGender);
        mainPane.getChildren().add(labQuesNo);
        mainPane.getChildren().add(labTimer);
        mainPane.getChildren().add(labQues);
        mainPane.getChildren().add(paneC);
        mainPane.getChildren().add(btnNext);
        mainPane.getChildren().add(btnPrev);
        mainPane.getChildren().add(btnSubmit);

        mainScene = new Scene(mainPane, 800, 700);
        stage.setScene(mainScene);

        // handles when user clicks the close window button
        stage.setOnCloseRequest(e -> {
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setTitle("Warning");
            a.setHeaderText("");
            a.setContentText("Exiting the application will cause you to lose all progress. Confirm exit?");

            a.showAndWait().filter(r -> r != ButtonType.OK).ifPresent(r -> e.consume());
        });
        reloadQues();

        loginScreen = new Login();

        loginScreen.setOnHiding(e -> {
            labName.setText(loginScreen.getName());
            labNationality.setText(loginScreen.getNationality());
            labGender.setText(loginScreen.getGender());
            stage.show();
            // start the timer once logged in
            timeTracker();
        });
    }

    public void reloadQues() {
        labQuesNo.setText("Question " + Integer.toString(activeQ) + "/" + Integer.toString(totQues));
        labQues.setText(quesList.get(activeQ - 1).getQuestions());
        radChoice1.setText(quesList.get(activeQ - 1).getChoice(0));
        radChoice2.setText(quesList.get(activeQ - 1).getChoice(1));
        radChoice3.setText(quesList.get(activeQ - 1).getChoice(2));
        radChoice4.setText(quesList.get(activeQ - 1).getChoice(3));
        imgQues.setImage(null);
        choiceImg1.setImage(null);
        choiceImg2.setImage(null);
        choiceImg3.setImage(null);
        choiceImg4.setImage(null);
        if (quesList.get(activeQ - 1).getType() == 1) {

            // position the choices appropriately
            labA.setLayoutY(75);
            radChoice1.setLayoutY(75);

            labB.setLayoutY(75);
            radChoice2.setLayoutY(75);

            labC.setLayoutY(175);
            radChoice3.setLayoutY(175);

            labD.setLayoutY(175);
            radChoice4.setLayoutY(175);
        }
        if (quesList.get(activeQ - 1).getType() == 2) {
            File pFile = new File("data/images/" + quesList.get(activeQ - 1).getQuesPic());
            Image img = new Image(pFile.toURI().toString());

            imgQues.setImage(img);

            // position the choices appropriately
            labA.setLayoutY(275);
            radChoice1.setLayoutY(275);
            labB.setLayoutY(325);
            radChoice2.setLayoutY(325);
            labC.setLayoutY(375);
            radChoice3.setLayoutY(375);
            labD.setLayoutY(425);
            radChoice4.setLayoutY(425);
        }
        if (quesList.get(activeQ - 1).getType() == 3) {
            // setting all these elements to null as only the choicesImg is needed
            imgQues.setImage(null);
            radChoice1.setText(null);
            radChoice2.setText(null);
            radChoice3.setText(null);
            radChoice4.setText(null);

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
            radChoice1.setLayoutY(75);
            choiceImg1.setLayoutY(75);

            labB.setLayoutX(325);
            labB.setLayoutY(75);
            radChoice2.setLayoutX(350);
            radChoice2.setLayoutY(75);
            choiceImg2.setLayoutY(75);

            labC.setLayoutY(300);
            radChoice3.setLayoutY(300);
            choiceImg3.setLayoutX(90);

            labD.setLayoutX(325);
            labD.setLayoutY(300);
            radChoice4.setLayoutX(350);
            radChoice4.setLayoutY(300);

        }
        radChoice1.setSelected(quesList.get(activeQ - 1).getSelected(0));
        radChoice2.setSelected(quesList.get(activeQ - 1).getSelected(1));
        radChoice3.setSelected(quesList.get(activeQ - 1).getSelected(2));
        radChoice4.setSelected(quesList.get(activeQ - 1).getSelected(3));

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
        // put your code here -> Analysis.Analysis();

    }

    // store percentage and candidates' answers for each question
    public void saveToFile(String curU, String curN, String curG) {

        // the file will be named similarly to the candidate's details
        // example: Whoong_Zi_Wei_Malaysia.txt

        // convert the user's name to appropriate file naming convention
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
            int totalQuestions = 20;
            int totalCorrect = 0;
            PrintWriter pw = new PrintWriter(new FileWriter(fileToSave, true));
            pw.println();
            // candidate_name, candidate_nationality, candidate_gender, q1_CorrectORWrong,
            // q2_q1_CorrectORWrong, ...
            pw.print(username + ",");
            pw.print(curN + ",");
            pw.print(curG + ",");

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

            // double getPercentage = Math.round((totalCorrect / totalQuestions) * 100);
            int getPercentage = (int) ((double) totalCorrect / totalQuestions * 100);
            System.out.println(getPercentage);
            pw.print(getPercentage + ",");

            if (getPercentage >= 70) {
                pw.print("Pass");
            } else {
                pw.print("Fail");
            }
            pw.close();

        } catch (Exception e) {
            System.out.println("An error has occurred. Here is the error statement\n" + e);
        }
    }

}
