package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeMenuController {
	Stage stage;
	Scene scene;
	Parent root;
	
	public void ToAddAccount(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Accounts.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToDeposit(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Deposite.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToWithdraw(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Withdraw.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToTransfar(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Transfer.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToSpecificAccountSummary(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SpecificAccountSummary.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToSpecificAccountTransaction(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SpecificAccounTransactions.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToAccountsOfSpecificType(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("AccountsOfSpecificType.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToDisplayAll(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Displayall.fxml"));
		root = loader.load();
		DisplayAllController dac = loader.getController();
		dac.display();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToHome(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("FirstLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ToBack(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("FirstLogin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void Exit() {
		System.exit(0);
	}
}
