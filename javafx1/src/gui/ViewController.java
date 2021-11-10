package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
	
	private String alertTitle = "Alert";
	private String alertHeader = "Default";
	private String alertContent = "I am working";
	
	
	@FXML
	private Button quitButton;
	
	@FXML
	private Button button;
	
	@FXML
	public void onButtonAction() {
		Alerts.showAlert(alertTitle, alertHeader, alertContent, AlertType.INFORMATION);
	}
	
	@FXML
	public void onQuitAction() {
		System.exit(0);
	}
}