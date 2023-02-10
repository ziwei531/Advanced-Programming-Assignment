package projectpartbprogram_group9;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import javafx.application.Application;
import javafx.application.Platform;

public class ResultForm implements ActionListener {
    JButton btnExit;
    JFrame frame1;
    JPanel subpanel, mainpanel;
    JTable table1;
    DefaultTableModel model;
    JScrollPane jsp1;
    private Analysis analysisScreen;

    String filePath = "./data/results.txt";
    File file = new File(filePath);

    public ResultForm() {
        subpanel = new JPanel();
        mainpanel = new JPanel();
        frame1 = new JFrame();
        frame1.setTitle("Overall RESULTS");
        frame1.setSize(1000, 690);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainpanel.setLayout(null);
        subpanel.setLayout(null);
        model = createModel();
        table1 = new JTable(model);

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table1.getColumnModel().getColumn(0).setPreferredWidth(200);
        table1.getColumnModel().getColumn(1).setPreferredWidth(200);
        table1.getColumnModel().getColumn(2).setPreferredWidth(200);
        table1.getColumnModel().getColumn(3).setPreferredWidth(200);
        table1.getColumnModel().getColumn(4).setPreferredWidth(200);
        table1.getColumnModel().getColumn(5).setPreferredWidth(200);
        table1.getColumnModel().getColumn(6).setPreferredWidth(200);
        table1.getColumnModel().getColumn(7).setPreferredWidth(200);
        table1.getColumnModel().getColumn(8).setPreferredWidth(200);
        table1.getColumnModel().getColumn(9).setPreferredWidth(200);
        table1.getColumnModel().getColumn(10).setPreferredWidth(200);
        table1.getColumnModel().getColumn(11).setPreferredWidth(200);
        table1.getColumnModel().getColumn(12).setPreferredWidth(200);
        table1.getColumnModel().getColumn(13).setPreferredWidth(200);
        table1.getColumnModel().getColumn(14).setPreferredWidth(200);
        table1.getColumnModel().getColumn(15).setPreferredWidth(200);
        table1.getColumnModel().getColumn(16).setPreferredWidth(200);
        table1.getColumnModel().getColumn(17).setPreferredWidth(200);
        table1.getColumnModel().getColumn(18).setPreferredWidth(200);
        table1.getColumnModel().getColumn(19).setPreferredWidth(200);
        table1.getColumnModel().getColumn(20).setPreferredWidth(200);
        table1.getColumnModel().getColumn(21).setPreferredWidth(200);
        table1.getColumnModel().getColumn(22).setPreferredWidth(200);
        table1.getColumnModel().getColumn(23).setPreferredWidth(200);
        table1.getColumnModel().getColumn(24).setPreferredWidth(200);
        table1.getColumnModel().getColumn(25).setPreferredWidth(200);
        table1.getColumnModel().getColumn(26).setPreferredWidth(200);
        table1.getColumnModel().getColumn(27).setPreferredWidth(200);
        table1.getColumnModel().getColumn(28).setPreferredWidth(200);
        table1.getColumnModel().getColumn(29).setPreferredWidth(200);
        table1.getColumnModel().getColumn(30).setPreferredWidth(200);
        table1.getColumnModel().getColumn(31).setPreferredWidth(200);
        table1.getColumnModel().getColumn(32).setPreferredWidth(200);
        table1.getColumnModel().getColumn(33).setPreferredWidth(200);
        table1.getColumnModel().getColumn(34).setPreferredWidth(200);
        table1.getColumnModel().getColumn(35).setPreferredWidth(200);

        jsp1 = new JScrollPane(table1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp1.setBounds(5, 5, 960, 575);
        subpanel.add(jsp1);
        subpanel.setBounds(5, 5, 970, 585);
        mainpanel.add(subpanel);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(875, 600, 90, 25);
        btnExit.addActionListener(this);
        mainpanel.add(btnExit);

        frame1.add(mainpanel);
        frame1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    private DefaultTableModel createModel() {
        DefaultTableModel model = null;

        try {
            BufferedReader txtReader = new BufferedReader(new FileReader(file));
            String columnHeader = txtReader.readLine();
            model = new DefaultTableModel(columnHeader.split("/"), 0);
            String rowLine;
            while ((rowLine = txtReader.readLine()) != null) {
                model.addRow(rowLine.split(","));
            }
        } catch (IOException ex) {
            System.out.println("file not found");
        }

        return model;
    }

}