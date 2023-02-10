package projectpartbprogram_group9;

import java.io.*;
import java.util.Scanner;
import javax.swing.event.SwingPropertyChangeSupport;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Analysis extends Stage {

        private Label labMax2, labMin2, labMean2, labMed2, labP2, labF2;
        private Button btnLeave;
        private Pane p1;
        private Scene mainScene;
        private ResultForm resultScreen;
        private File myf = new File("./data/results.txt");

        public Analysis() {
                System.out.println("Executed Analysis");
                this.setTitle("Analysis Page");
                Label labMax = new Label("MAXIMUM: ");
                labMax.setStyle(
                                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
                labMax.setLayoutX(90);
                labMax.setLayoutY(80);
                labMax2 = new Label();
                labMax2.setStyle("-fx-background-color: \r\n"
                                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                                + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                                + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                                + "    -fx-background-insets: 0,1,4,5;\r\n"
                                + "    -fx-background-radius: 9,8,5,4;\r\n"
                                + "    -fx-padding: 15 30 15 30;\r\n"
                                + "    -fx-font-family: \"Helvetica\";\r\n"
                                + "    -fx-font-size: 18px;\r\n"
                                + "    -fx-font-weight: bold;\r\n"
                                + "    -fx-text-fill: #333333;\r\n"
                                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
                labMax2.setLayoutX(90);
                labMax2.setLayoutY(120);
                Label labMin = new Label("MINIMUM: ");
                labMin.setStyle(
                                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
                labMin.setLayoutX(280);
                labMin.setLayoutY(80);
                labMin2 = new Label();
                labMin2.setLayoutX(280);
                labMin2.setLayoutY(120);
                labMin2.setStyle("-fx-background-color: \r\n"
                                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                                + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                                + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                                + "    -fx-background-insets: 0,1,4,5;\r\n"
                                + "    -fx-background-radius: 9,8,5,4;\r\n"
                                + "    -fx-padding: 15 30 15 30;\r\n"
                                + "    -fx-font-family: \"Helvetica\";\r\n"
                                + "    -fx-font-size: 18px;\r\n"
                                + "    -fx-font-weight: bold;\r\n"
                                + "    -fx-text-fill: #333333;\r\n"
                                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
                Label labMean = new Label("AVERAGE: ");
                labMean.setStyle(
                                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
                labMean.setLayoutX(90);
                labMean.setLayoutY(180);
                labMean2 = new Label();
                labMean2.setLayoutX(90);
                labMean2.setLayoutY(220);
                labMean2.setStyle("-fx-background-color: \r\n"
                                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                                + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                                + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                                + "    -fx-background-insets: 0,1,4,5;\r\n"
                                + "    -fx-background-radius: 9,8,5,4;\r\n"
                                + "    -fx-padding: 15 30 15 30;\r\n"
                                + "    -fx-font-family: \"Helvetica\";\r\n"
                                + "    -fx-font-size: 18px;\r\n"
                                + "    -fx-font-weight: bold;\r\n"
                                + "    -fx-text-fill: #333333;\r\n"
                                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
                Label labMed = new Label("MEDIAN: ");
                labMed.setStyle(
                                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
                labMed.setLayoutX(280);
                labMed.setLayoutY(180);
                labMed2 = new Label();
                labMed2.setLayoutX(280);
                labMed2.setLayoutY(220);
                labMed2.setStyle("-fx-background-color: \r\n"
                                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                                + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                                + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                                + "    -fx-background-insets: 0,1,4,5;\r\n"
                                + "    -fx-background-radius: 9,8,5,4;\r\n"
                                + "    -fx-padding: 15 30 15 30;\r\n"
                                + "    -fx-font-family: \"Helvetica\";\r\n"
                                + "    -fx-font-size: 18px;\r\n"
                                + "    -fx-font-weight: bold;\r\n"
                                + "    -fx-text-fill: #333333;\r\n"
                                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
                Label labP = new Label("NUMBER OF PASSED" + "\n" + "       CANDIDATES: ");
                labP.setStyle(
                                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
                labP.setLayoutX(50);
                labP.setLayoutY(280);
                labP2 = new Label();
                labP2.setLayoutX(90);
                labP2.setLayoutY(330);
                labP2.setStyle("-fx-background-color: \r\n"
                                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                                + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                                + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                                + "    -fx-background-insets: 0,1,4,5;\r\n"
                                + "    -fx-background-radius: 9,8,5,4;\r\n"
                                + "    -fx-padding: 15 30 15 30;\r\n"
                                + "    -fx-font-family: \"Helvetica\";\r\n"
                                + "    -fx-font-size: 18px;\r\n"
                                + "    -fx-font-weight: bold;\r\n"
                                + "    -fx-text-fill: #333333;\r\n"
                                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
                Label labF = new Label("NUMBER OF FAILED" + "\n" + "       CANDIDATES: ");
                labF.setStyle(
                                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
                labF.setLayoutX(240);
                labF.setLayoutY(280);
                labF2 = new Label();
                labF2.setLayoutX(280);
                labF2.setLayoutY(330);
                labF2.setStyle("-fx-background-color: \r\n"
                                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                                + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\r\n"
                                + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\r\n"
                                + "    -fx-background-insets: 0,1,4,5;\r\n"
                                + "    -fx-background-radius: 9,8,5,4;\r\n"
                                + "    -fx-padding: 15 30 15 30;\r\n"
                                + "    -fx-font-family: \"Helvetica\";\r\n"
                                + "    -fx-font-size: 18px;\r\n"
                                + "    -fx-font-weight: bold;\r\n"
                                + "    -fx-text-fill: #333333;\r\n"
                                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

                btnLeave = new Button("SHOW RESULTS");
                btnLeave.setLayoutX(290);
                btnLeave.setLayoutY(450);
                btnLeave.setStyle("-fx-background-color: \r\n"
                                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                                + "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
                                + "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
                                + "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\r\n"
                                + "    -fx-background-insets: 0,1,4,5,6;\r\n"
                                + "    -fx-background-radius: 9,8,5,4,3;\r\n"
                                + "    -fx-padding: 10 25 10 25;\r\n"
                                + "    -fx-font-family: \"Helvetica\";\r\n"
                                + "    -fx-font-size: 18px;\r\n"
                                + "    -fx-font-weight: bold;\r\n"
                                + "    -fx-text-fill: white;\r\n"
                                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
                btnLeave.setOnAction(e -> {
                        this.hide();
                        resultScreen = new ResultForm();
                });

                Label labResultLabel = new Label("STATISTICAL ANALYSIS RESULTS");
                labResultLabel.setLayoutX(140);
                labResultLabel.setLayoutY(25);
                labResultLabel.setStyle(
                                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");

                p1 = new Pane();
                p1.getChildren().add(labMax);
                p1.getChildren().add(labMin);
                p1.getChildren().add(labMean);
                p1.getChildren().add(labP);
                p1.getChildren().add(labMed);
                p1.getChildren().add(labF);
                p1.getChildren().add(labMax2);
                p1.getChildren().add(labMin2);
                p1.getChildren().add(labMean2);
                p1.getChildren().add(labP2);
                p1.getChildren().add(labMed2);
                p1.getChildren().add(labF2);
                p1.getChildren().add(btnLeave);
                p1.getChildren().add(labResultLabel);

                mainScene = new Scene(p1, 500, 550);
                this.setScene(mainScene);
                this.show();
                readFromFile();

                p1.setBackground(new Background(
                                new BackgroundImage(
                                                new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_06_1920x1080.png"),
                                                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true,
                                                                false, true)),
                                new BackgroundImage(
                                                new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_05_1920x1080.png"),
                                                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true,
                                                                false, true)),
                                new BackgroundImage(
                                                new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_04_1920x1080.png"),
                                                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true,
                                                                false, true)),
                                new BackgroundImage(
                                                new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_03_1920x1080.png"),
                                                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true,
                                                                false, true)),
                                new BackgroundImage(
                                                new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_02_1920x1080.png"),
                                                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true,
                                                                false, true)),
                                new BackgroundImage(
                                                new Image("https://edencoding.com/wp-content/uploads/2021/03/layer_01_1920x1080.png"),
                                                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                                                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true,
                                                                false, true))));
        }

        public void readFromFile() {
                Scanner sfile;
                String name, country, gender, birthyear, answer1, answer2, answer3, answer4, answer5, answer6, answer7,
                                answer8,
                                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17,
                                answer18,
                                answer19, answer20, answer21, answer22, answer23, answer24, answer25, answer26,
                                answer27, answer28,
                                answer29, answer30, result;
                ArrayList<Double> score = new ArrayList<>();
                try {
                        sfile = new Scanner(myf);
                        sfile.nextLine();
                        while (sfile.hasNextLine()) {
                                String aLine = sfile.nextLine();
                                Scanner sline = new Scanner(aLine);
                                sline.useDelimiter(",");

                                while (sline.hasNext()) {
                                        name = sline.next();
                                        country = sline.next();
                                        gender = sline.next();
                                        birthyear = sline.next();
                                        answer1 = sline.next();
                                        answer2 = sline.next();
                                        answer3 = sline.next();
                                        answer4 = sline.next();
                                        answer5 = sline.next();
                                        answer6 = sline.next();
                                        answer7 = sline.next();
                                        answer8 = sline.next();
                                        answer9 = sline.next();
                                        answer10 = sline.next();
                                        answer11 = sline.next();
                                        answer12 = sline.next();
                                        answer13 = sline.next();
                                        answer14 = sline.next();
                                        answer15 = sline.next();
                                        answer16 = sline.next();
                                        answer17 = sline.next();
                                        answer18 = sline.next();
                                        answer19 = sline.next();
                                        answer20 = sline.next();
                                        answer21 = sline.next();
                                        answer22 = sline.next();
                                        answer23 = sline.next();
                                        answer24 = sline.next();
                                        answer25 = sline.next();
                                        answer26 = sline.next();
                                        answer27 = sline.next();
                                        answer28 = sline.next();
                                        answer29 = sline.next();
                                        answer30 = sline.next();
                                        double s = Double.parseDouble(sline.next());
                                        score.add(s);
                                        result = sline.next();

                                }
                                sline.close();
                        }
                        sfile.close();
                } catch (FileNotFoundException e) {
                }
                Collections.sort(score);
                ArrayList<Double> results = calculation(score);
                System.out.println("All of the data: " + score);
                System.out.println(results);

                labMax2.setText(labMax2.getText() + results.get(1));
                labMin2.setText(labMin2.getText() + results.get(0));
                labMean2.setText(labMean2.getText() + results.get(2));
                labMed2.setText(labMed2.getText() + results.get(3));
                labP2.setText(labP2.getText() + results.get(4));
                labF2.setText(labF2.getText() + results.get(5));
        }

        public static ArrayList<Double> calculation(ArrayList<Double> score) {
                ArrayList<Double> res = new ArrayList<>();
                res.add(score.get(0));
                res.add(score.get(score.size() - 1));
                double total = 0;
                for (int i = 0; i < score.size(); i++) {
                        total += score.get(i);
                }
                double mean = total / score.size();
                mean = mean * 100;
                mean = Math.round(mean);
                mean = mean / 100;
                res.add(mean);
                res.add(getMedian(score));
                double s = 0;
                for (int i = 0; i < score.size(); i++) {
                        if (score.get(i) >= 40) {
                                s++;
                        }
                }
                res.add(s);
                double t = 0;
                for (int i = 0; i < score.size(); i++) {
                        if (score.get(i) < 40) {
                                t++;
                        }
                }
                res.add(t);
                return res;
        }

        public static double getMedian(ArrayList<Double> score) {
                return (score.size() % 2 == 1) ? score.get((score.size() + 1) / 2 - 1)
                                : ((score.get(score.size() / 2 - 1) + score.get(score.size() / 2)) / 2);
        }

}
