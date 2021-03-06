package com.calculadora.controller;

import java.math.BigInteger;

import com.calculadora.MainApp;
import com.calculadora.config.ConfigProperties;
import com.calculadora.service.OperacoesBasicasService;
import com.calculadora.service.OperacoesBasicasServiceImpl;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PrimosController implements Runnable {
	private MainApp mainApp;
	private ConfigProperties label;
	private Stage primosStage;
	private OperacoesBasicasService operacoesBasicasService;
	
	@FXML
	private Button btnCalcular;
	
	@FXML
	private TextField textFieldInputPrimo;
	
	@FXML
	private TextField textFieldIsPrimo;
	
	@FXML
	private TextField textFieldExplicacao;
	
	@Override
	public void run() {
		btnCalcular.setDisable(true);
		textFieldInputPrimo.requestFocus();
		setListerners(textFieldInputPrimo);
		
		Platform.runLater(new Runnable() {
			public void run() {
				primosStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					public void handle(WindowEvent we) {
						handleVoltar();
					}
				});
			}
		});
	}
	
	public void show(MainApp _mainApp, Stage primosStage, ConfigProperties label) {
		this.mainApp = _mainApp;
		this.primosStage = primosStage;
		this.label = label;
		this.operacoesBasicasService = new OperacoesBasicasServiceImpl();
		
		run();
		mainApp.addThread(new Thread(this));
	}
	
	private void setListerners(TextField label) {
		Platform.runLater(new Runnable() {
			public void run() {
				label.textProperty().addListener((observable, oldValue, newValue) -> {
				    if (textFieldInputPrimo.getText().length() == 0) {
				    	btnCalcular.setDisable(true);
				    	textFieldIsPrimo.setText("");
				    	textFieldExplicacao.setText("");
				    } else {
				    	btnCalcular.setDisable(false);
				    }
				});
			}
		});
	}
	
	@FXML
	private void handleCalcular() {
		BigInteger numPrimo = new BigInteger(textFieldInputPrimo.getText());
		if (operacoesBasicasService.isPrimo(numPrimo)) {
			showIsPrimo();
		} else {
			showNotIsPrimo(numPrimo);
		}
	}
	
	private void showIsPrimo() {
		textFieldIsPrimo.setText(label.getString("root.tab.arquivo.primo.isPrimoFristPt") + 
				textFieldInputPrimo.getText() + 
				label.getString("root.tab.arquivo.primo.isPrimoSecondPt"));
	}
	
	private void showNotIsPrimo(BigInteger numPrimo) {
		textFieldIsPrimo.setText(label.getString("root.tab.arquivo.primo.isPrimoFristPt") + 
							textFieldInputPrimo.getText() + 
							label.getString("root.tab.arquivo.primo.notPrimoSecondPt"));

		if (numPrimo.compareTo(new BigInteger("1")) == 0) {
			textFieldExplicacao.setText(label.getString("root.tab.arquivo.primo.isPrimoFristPt") + 
									textFieldInputPrimo.getText() + 
									label.getString("root.tab.arquivo.primo.notPrimeExplicOneSecond"));
			return;
		} else if (numPrimo.remainder(new BigInteger("2")).compareTo(new BigInteger("0")) == 0) 
			textFieldExplicacao.setText(label.getString("root.tab.arquivo.primo.isPrimoFristPt") + 
									textFieldInputPrimo.getText() + 
									label.getString("root.tab.arquivo.primo.notPrimeExplicPar"));
	}
	
	@FXML
	private void handleVoltar() {
		mainApp.exibirRoot();
		primosStage.close();
		mainApp.clean(primosStage, this);
	}
	
	@FXML
	private void handleAjuda() {
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setPrimosStage(Stage primosStage) {
		this.primosStage = primosStage;
	}
}
