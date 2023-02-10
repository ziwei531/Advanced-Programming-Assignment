package projectpartbprogram_group9;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Optional;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Stage {
    private static String uname, pwd;
    private TextField username;
    private PasswordField password;
    private RandomAccessFile rafFile = new RandomAccessFile("data/candidate.dat", "rw");
    private static final int REC_SIZE = 64;
    private static final int NAME_SIZE = 20;
    private static int stuPos = 0;
    private static String stuName;
    private static String stuPass;
    private static final int PASS_SIZE = 10;

    public Login() throws IOException {
        this.setTitle("Please Enter Your Credentials");
        Label labHeading = new Label("Hello User! Please enter your credentials below. ");
        Label labName = new Label("Please enter your name: ");
        Label labResponseU = new Label();

        Label labPassword = new Label("Please enter your password given by the adminstrator: ");
        Label labResponseP = new Label();

        username = new TextField();
        password = new PasswordField();
        Button submitButton = new Button("Login");

        // CSS
        submitButton.setStyle(
                "-fx-pref-width: 155px;-fx-font-size:15px;-fx-border-radius: 3px;-fx-background-color: #090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n"
                        + "        linear-gradient(#20262b, #191d22),\r\n"
                        + "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0)) ;-fx-padding: 10 20 10 20;-fx-text-fill: linear-gradient(white, #d0d0d0);"
                        + " -fx-background-radius: 5,4,3,5;\r\n"
                        + "    -fx-background-insets: 0,1,2,0;\r\n"
                        + "    -fx-text-fill: white;\r\n"
                        + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n"
                        + "    -fx-font-family: \"Arial\";");

        username.setStyle("-fx-background-color: \r\n"
                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                + "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
                + "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
                + "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\r\n"
                + "    -fx-background-insets: 0,1,4,5,6;\r\n"
                + "    -fx-background-radius: 9,8,5,4,3;\r\n"
                + "    -fx-padding: 15 30 15 30;\r\n"
                + "    -fx-font-family: \"Helvetica\";\r\n"
                + "    -fx-font-size: 18px;\r\n"
                + "    -fx-font-weight: bold;\r\n"
                + "    -fx-text-fill: white;\r\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        password.setStyle("-fx-background-color: \r\n"
                + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\r\n"
                + "        linear-gradient(#020b02, #3a3a3a),\r\n"
                + "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\r\n"
                + "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\r\n"
                + "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\r\n"
                + "    -fx-background-insets: 0,1,4,5,6;\r\n"
                + "    -fx-background-radius: 9,8,5,4,3;\r\n"
                + "    -fx-padding: 15 30 15 30;\r\n"
                + "    -fx-font-family: \"Helvetica\";\r\n"
                + "    -fx-font-size: 18px;\r\n"
                + "    -fx-font-weight: bold;\r\n"
                + "    -fx-text-fill: white;\r\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        labResponseP.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\r\n"
                + "    -fx-background-radius: 30;\r\n"
                + "    -fx-background-insets: 0;\r\n"
                + "    -fx-text-fill: white;");

        username.setPrefWidth(250);
        username.setMaxWidth(250);
        password.setPrefWidth(250);
        password.setMaxWidth(250);

        labHeading.setStyle(
                "-fx-font: 20px Impact;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);-fx-stroke: black;-fx-stroke-width: 1;");
        labName.setStyle("-fx-background-color: \r\n"
                + "        rgba(0,0,0,0.08),\r\n"
                + "        linear-gradient(#5a61af, #51536d),\r\n"
                + "        linear-gradient(#e4fbff 0%,#cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\r\n"
                + "    -fx-background-insets: 0 0 -1 0,0,1;\r\n"
                + "    -fx-background-radius: 5,5,4;\r\n"
                + "    -fx-padding: 3 30 3 30;\r\n"
                + "    -fx-text-fill: #242d35;\r\n"
                + "    -fx-font-size: 14px;");
        labPassword.setStyle("-fx-background-color: \r\n"
                + "        rgba(0,0,0,0.08),\r\n"
                + "        linear-gradient(#5a61af, #51536d),\r\n"
                + "        linear-gradient(#e4fbff 0%,#cee6fb 10%, #a5d3fb 50%, #88c6fb 51%, #d5faff 100%);\r\n"
                + "    -fx-background-insets: 0 0 -1 0,0,1;\r\n"
                + "    -fx-background-radius: 5,5,4;\r\n"
                + "    -fx-padding: 3 30 3 30;\r\n"
                + "    -fx-text-fill: #242d35;\r\n"
                + "    -fx-font-size: 14px;");

        submitButton.setOnAction(e -> {
            // if no errors at all
            boolean verify = false;
            try {
                if (verifyLogin(username.getText(), password.getText())) {
                    System.out.println("Verification successful !");
                    this.hide();
                }

            } catch (IOException ex) {

                System.out.println(ex);
            }

            if (!verify) {
                if (!username.getText().isEmpty() && !password.getText().isEmpty()
                        && (username.getText().equals(uname))
                        && (password.getText().equals(pwd))) {
                    labResponseU.setText("");
                    labResponseP.setText("");
                } else if (!username.getText().equals(uname) && !password.getText().equals(pwd) && verify) {
                    labResponseU.setText("Username does not exist. Please try again");
                    labResponseU.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\r\n"
                            + "    -fx-background-radius: 30;\r\n"
                            + "    -fx-background-insets: 0;\r\n"
                            + "    -fx-text-fill: white;");
                    labResponseP.setText("You've entered the wrong password. Please try again");
                    labResponseU.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\r\n"
                            + "    -fx-background-radius: 30;\r\n"
                            + "    -fx-background-insets: 0;\r\n"
                            + "    -fx-text-fill: white;");
                } else {
                    if (username.getText().isEmpty()) {
                        labResponseU.setText("Please enter your username");
                        labResponseU.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\r\n"
                                + "    -fx-background-radius: 30;\r\n"
                                + "    -fx-background-insets: 0;\r\n"
                                + "    -fx-text-fill: white;");
                    } else if (!username.getText().equals(uname)) {
                        labResponseU.setText("Username does not exist. Please try again");
                        labResponseU.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\r\n"
                                + "    -fx-background-radius: 30;\r\n"
                                + "    -fx-background-insets: 0;\r\n"
                                + "    -fx-text-fill: white;");
                    } else if (username.getText().equals(uname)) {
                        labResponseU.setText("This username is exist within the database");
                        labResponseU.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\r\n"
                                + "    -fx-background-radius: 30;\r\n"
                                + "    -fx-background-insets: 0;\r\n"
                                + "    -fx-text-fill: white;");
                        verify = true;
                    }
                    if (password.getText().isEmpty()) {
                        labResponseP.setText("Please enter a password");
                    } else if (!password.getText().equals(pwd) && verify) {
                        labResponseP.setText("You've entered the wrong password. Please try again");
                    } else if (password.getText().equals(pwd) && verify) {
                        labResponseP.setText("");
                    }
                }
            }
        });

        VBox myVBox = new VBox(labHeading, labName, username, labResponseU, labPassword, password, labResponseP,
                submitButton);
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
            } else {
                e.consume();
            }

        });
        this.show();

        // this method below executes the writing and reading of the .dat file
        // candidateFile();
    }

    public boolean verifyLogin(String n, String p) throws IOException {
        boolean verify = false;
        long numRecords = rafFile.length() / REC_SIZE;
        rafFile.seek(0);
        for (int i = 1; i <= numRecords; i++) {
            stuPos = rafFile.readInt();
            uname = readString(rafFile, NAME_SIZE);
            uname = uname.trim();
            pwd = readString(rafFile, PASS_SIZE);
            pwd = pwd.trim();
            rafFile.seek(REC_SIZE * i);
            if (uname.equals(n) && pwd.equals(p)) {
                verify = true;
                break;
            }
        }

        return verify;
    }

    public static String readString(RandomAccessFile file, int fixedSize) throws IOException {
        String value = "";
        for (int i = 0; i < fixedSize; i++)
            value += file.readChar();
        return value;
    }

    public static void displayRecords(RandomAccessFile file) throws IOException {
        long numRecords = file.length() / REC_SIZE;
        file.seek(0);
        for (int i = 0; i < numRecords; i++) {
            stuPos = file.readInt();
            stuName = readString(file, NAME_SIZE);
            System.out.println(stuPass);
            stuPass = readString(file, PASS_SIZE);
            System.out.println("POS : " + stuPos + " NAME : " + stuName + " PASSWORD : " + stuPass);
        }
    }

    public static void writeString(RandomAccessFile file, String text, int fixedSize) throws IOException {
        int size = text.length();
        if (size <= fixedSize) {
            file.writeChars(text);
            for (int i = size; i < fixedSize; i++)
                file.writeChar(' ');
        } else {
            file.writeChars(text.substring(0, fixedSize));
        }
    }

    public static void saveRecord(RandomAccessFile file) throws IOException, FileNotFoundException {
        System.out.println("Successfully added !");
        int filePosition = (stuPos - 1) * REC_SIZE;
        file.seek(filePosition);
        file.writeInt(stuPos);
        writeString(file, stuName, NAME_SIZE);
        writeString(file, stuPass, PASS_SIZE);
    }

    public void candidateFile() throws IOException {
        String reply = "N";
        Scanner input = new Scanner(System.in);
        long numberOfRecords = rafFile.length() / REC_SIZE;
        if (numberOfRecords != 0) {
            stuPos = (int) (numberOfRecords);
        }
        do {
            stuPos++;
            System.out.println("Student Position : " + stuPos);
            System.out.print("Enter Name >> ");
            stuName = input.nextLine();
            System.out.print("Enter Password >> ");
            stuPass = input.nextLine();
            // input.nextLine();
            saveRecord(rafFile);
            System.out.print("Enter More (Y/N) ? ");
            reply = (input.nextLine()).toUpperCase();
        } while (reply.equals("Y"));
        displayRecords(rafFile);
        // rafFile.close();
    }

    public String getUsername() {
        return username.getText();
    }

}