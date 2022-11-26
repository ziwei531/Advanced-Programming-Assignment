
package projectpartbprogram_group9;

public class Analysis extends Application {

    private Label labMax2, labMin2, labMean2,labMed2, labP2, labF2;
    private Button btnResults, btnHome, btnLeave;
    private Pane p1;
    private Scene mainScene;
    private File myf = new File("./data/results.txt");

    public void start(Stage mainStage) {
        mainStage.setTitle("ANALYSIS FORM");
        
        Label labMax = new Label("MAXIMUM: ");
        labMax.setLayoutX(90);
        labMax.setLayoutY(80);
        labMax2 = new Label();
        labMax2.setLayoutX(90);
        labMax2.setLayoutY(120);
        Label labMin = new Label("MINIMUM: ");
        labMin.setLayoutX(280);
        labMin.setLayoutY(80);
        labMin2 = new Label();
        labMin2.setLayoutX(280);
        labMin2.setLayoutY(120);
        Label labMean = new Label("AVERAGE: ");
        labMean.setLayoutX(90);
        labMean.setLayoutY(180);
        labMean2 = new Label();
        labMean2.setLayoutX(90);
        labMean2.setLayoutY(220);
        Label labMed = new Label("MEDIAN: ");
        labMed.setLayoutX(280);
        labMed.setLayoutY(180);
        labMed2 = new Label();
        labMed2.setLayoutX(280);
        labMed2.setLayoutY(220);
        Label labP = new Label("NUMBER OF PASSED CANDIDATES: ");
        labP.setLayoutX(10);
        labP.setLayoutY(280);
        labP2 = new Label();
        labP2.setLayoutX(90);
        labP2.setLayoutY(320);
        Label labF = new Label("NUMBER OF FAILED CANDIDATES: ");
        labF.setLayoutX(260);
        labF.setLayoutY(280);
        labF2 = new Label();
        labF2.setLayoutX(280);
        labF2.setLayoutY(320);
        

        btnResults = new Button("SHOW RESULTS");
        btnResults.setLayoutX(180);
        btnResults.setLayoutY(400);

        btnHome = new Button("HOME");
        btnHome.setLayoutX(50);
        btnHome.setLayoutY(480);
        
        btnLeave = new Button("LEAVE PAGE");
        btnLeave.setLayoutX(350);
        btnLeave.setLayoutY(480);

        Label labResultLabel = new Label("STATISTICAL ANALYSIS RESULTS");
        labResultLabel.setLayoutX(140);
        labResultLabel.setLayoutY(25);
        
        btnResults.setOnAction(e -> {
            readFromFile();
        });

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
        p1.getChildren().add(btnResults);
        p1.getChildren().add(btnHome);
        p1.getChildren().add(btnLeave);
        p1.getChildren().add(labResultLabel);
        mainScene = new Scene(p1, 500, 550);
        mainStage.setScene(mainScene);
        mainStage.show();
    }
    
    public void readFromFile() {
        Scanner sfile;
        String name, country,gender, answer1,answer2,answer3,answer4,answer5,result;
        ArrayList<Double> score = new ArrayList<>();
        try {
            sfile = new Scanner(myf);
            while (sfile.hasNextLine()) {
                String aLine = sfile.nextLine();
                Scanner sline = new Scanner(aLine);
                sline.useDelimiter(",");
                while (sline.hasNext()) {
                    
                    name = sline.next();
                    country = sline.next();
                    gender = sline.next();
                    answer1 = sline.next();
                    answer2 = sline.next();
                    answer3 = sline.next();
                    answer4 = sline.next();
                    answer5 = sline.next();
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
        System.out.println(score);
        System.out.println(results);

        labMax2.setText(labMax2.getText() + results.get(1));
        labMin2.setText(labMin2.getText() + results.get(0));
        labMean2.setText(labMean2.getText() + results.get(2));
        labMed2.setText(labMed2.getText() + results.get(3));
        labP2.setText(labP2.getText() + results.get(4));
        labF2.setText(labF2.getText() + results.get(5));
    }
    
    public static ArrayList<Double> calculation(ArrayList<Double> score){
        ArrayList<Double> res = new ArrayList<>();
        res.add(score.get(0));
        res.add(score.get(score.size() - 1));
        double total = 0;
        for(int i = 0; i < score.size(); i++) total += score.get(i);
        double mean = total/score.size();
        res.add(mean);
        res.add(getMedian(res));
        double s=0;
        for(int i = 0; i < score.size();i++){
            if(score.get(i)>=60){
                s++;
            }
        }
        res.add(s);
        double t=0;
        for(int i = 0; i < score.size();i++){
            if(score.get(i)<60){
                t++;
            }
        }
        res.add(t);
        return res;
    }
    
    public static double getMedian(ArrayList<Double> score){
        return (score.size()%2 == 1)? score.get(score.size()/2) :( (score.get(score.size()/2 - 1)+score.get(score.size()/2)) /2);
    }

}
