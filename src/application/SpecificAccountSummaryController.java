package application;

import java.io.IOException;

import banking.BankAccount;
import banking.InvalidAccountException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SpecificAccountSummaryController {

	Parent root;
	Stage stage;
	Scene scene;
	
	@FXML
	TextField accNumTF;
	
	@FXML
	public ListView<String> lv;
	
	public void confirm(ActionEvent event) {
		lv.getItems().clear();
		String accNum = accNumTF.getText();
		try {
			ObservableList<BankAccount> list = FXCollections.observableArrayList(Main.bank.findAccount(accNum));
			for(int i=0; i<list.size(); i++) {
				lv.getItems().addAll(list.get(i).toString());
			}
			accNumTF.clear();
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			//lv.getItems().addAll("Sorry account "+ accNum + " not found");
			lv.getItems().addAll(e.getMessage());
		}

	}
	
	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
