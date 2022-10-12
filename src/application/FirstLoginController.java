package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FirstLoginController {
	Stage stage;
	Scene scene;
	Parent root;
	
	@FXML
	TextField empTF;
	
	@FXML
	TextField cusTF;
	
	public void ToEmployeeMenu(ActionEvent event) throws IOException {
		String empID = empTF.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("temp.fxml"));
		Parent root2 = loader.load();
		TempController tCtrl = loader.getController();
		tCtrl.display();
		Stage stage = new Stage();
		Scene scene2 = new Scene(root2);
		stage.setScene(scene2);
		stage.show();
		
		
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void ToCustomerMenu(ActionEvent event) throws IOException {
		String nid = cusTF.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerMenu.fxml"));
		root = loader.load();
		CustomerMenuController cmc = new CustomerMenuController();
		cmc.storeNID(nid);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Exit() {
		System.exit(0);
	}
}
