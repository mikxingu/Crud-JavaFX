package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
	
	@FXML
	private TextField txtFirstNumber;
	
	@FXML
	private TextField txtSecondNumber;
	
	@FXML
	private Label resultLabel;
	
	
	@FXML
	private Button sumButton;
	
	@FXML
	private Button quitButton;
	
	@FXML
	public void onSumButtomAction() {
		
		try {
			Locale.setDefault(Locale.US);
			
			double value1 = Double.parseDouble(txtFirstNumber.getText());
			double value2 = Double.parseDouble(txtSecondNumber.getText());
			
			double sum = value1 + value2;
			
			resultLabel.setText(String.format("%.2f", sum));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
	
	}
	
	@FXML
	public void onQuitAction() {
		System.exit(0);
	}
}