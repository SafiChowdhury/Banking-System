package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AccountsController {
	@FXML
	private Label accLabel;
	@FXML
	private RadioButton current ;
	@FXML
	private RadioButton  savings;
	@FXML
	private RadioButton student;
	@FXML
	private ToggleGroup acc;
	@FXML
	private TextField Cname;
	@FXML
	private TextField Cnid;
	@FXML
	private TextField Cinstitute;
	@FXML
	private TextField CstdId;
	@FXML
	private TextField CTrlNum;
	@FXML
	private TextField CiBalance;
	@FXML
	private TextField CmaxWith;
	@FXML
	private ListView <String> listV;
	@FXML
	private Label msgLabel;
	
	private Parent root;
	private Scene scene;
	private Stage stage;
	
	public void type(ActionEvent event) {
		if(current.isSelected()) {
			accLabel.setText(current.getText());
			CmaxWith.setEditable(false);
			Cinstitute.setEditable(false);
			CstdId.setEditable(false);	
			CTrlNum.setEditable(true);
		}
		else if (savings.isSelected()) {
			accLabel.setText(savings.getText());
			CTrlNum.setEditable(false);
			Cinstitute.setEditable(false);
			CstdId.setEditable(false);
			CmaxWith.setEditable(true);
		}
		else if (student.isSelected()) {
			accLabel.setText(student.getText());
			CTrlNum.setEditable(false);
			CmaxWith.setEditable(false);
			Cinstitute.setEditable(true);
			CstdId.setEditable(true);
		}
	}
	
	public void createAcc(ActionEvent event) {
		if(current.isSelected()) {
			String name = Cname.getText();
			String nid = Cnid.getText();
			try {
				String trlNum = CTrlNum.getText();
				double balance = Double.parseDouble(CiBalance.getText());
				String accNum = "Your current account number is "+Main.bank.addAccount(name, nid, balance, trlNum);
				Main.bank.saveData();
				listV.getItems().addAll(accNum);
			} catch(NumberFormatException e) {
				msgLabel.setText("Initial balace cannot be string(Alphabets). Try again with number");
			}		
		}
		else if (savings.isSelected()) {
			String name = Cname.getText();
			String nid = Cnid.getText();		
			try {
				double balance = Double.parseDouble(CiBalance.getText());
			double maxWith = Double.parseDouble(CmaxWith.getText());
			String accNum = "Your savings account number is "+Main.bank.addAccount(name, nid, balance, maxWith);
			accLabel.setText(savings.getText());
			Main.bank.saveData();
			listV.getItems().addAll(accNum);
			} catch(NumberFormatException e) {
				msgLabel.setText("Initial balace or withdraw limit cannot be string(Alphabets). Try again with number");
			}
			
			
		}
		else if (student.isSelected()) {
			String name = Cname.getText();
			String nid = Cnid.getText();
			String institute = Cinstitute.getText();
			String stdID = CstdId.getText();	
			try {
				double balance = Double.parseDouble(CiBalance.getText());
			String accNum = "Your student account number is "+Main.bank.addAccount(name, nid, balance, institute, stdID);
			Main.bank.saveData();
			listV.getItems().addAll(accNum);
			} catch(NumberFormatException e) {
				msgLabel.setText("Initial balace cannot be string(Alphabets). Try again with number");
			}
		}
		Cname.clear();
		Cnid.clear();
		Cinstitute.clear();
		CstdId.clear();
		CTrlNum.clear();
		CiBalance.clear();
		CmaxWith.clear();
	}
		
	public void toBack(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
