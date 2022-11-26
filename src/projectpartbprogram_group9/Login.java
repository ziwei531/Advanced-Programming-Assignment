package projectpartbprogram_group9;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//remove nationality and gender
//add in password and username
public class Login extends Stage {
    private TextField txtName, nationality, gender;

    public Login() {
        this.setTitle("Citizenship Test");
        Label labHeading = new Label("Hello new user. Please enter your details below: ");
        Label labName = new Label("Please enter your name: ");
        Label labNationality = new Label("Please enter your nationality");
        Label labGender = new Label("Please enter your gender");
        txtName = new TextField();
        nationality = new TextField();
        gender = new TextField();
        Button btnDone = new Button("Submit");
        btnDone.setStyle(
                "-fx-pref-width: 125px;-fx-font-size:18px;-fx-border-radius: 3px;-fx-background-color: #9D9D9C;-fx-padding: 10px 15px;-fx-text-fill: white;");
        ;
        btnDone.setOnAction(e -> {
            CandidateDetails.setCandidateName(labName.getText());
            this.hide();
        });

        VBox myVBox = new VBox(labHeading, labName, txtName, labNationality, nationality, labGender, gender, btnDone);
        myVBox.setAlignment(Pos.CENTER);
        this.setScene(new Scene(myVBox, 500, 500));
        this.show();
    }

    public String getName() {
        return txtName.getText();
    }

    public String getNationality() {
        return nationality.getText(); 
    };

    public String getGender() {
        return gender.getText();
    }

}   
