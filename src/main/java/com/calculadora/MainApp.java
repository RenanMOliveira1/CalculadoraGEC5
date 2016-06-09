package com.calculadora;

import java.io.IOException;

import com.calculadora.config.ConfigProperties;
import com.calculadora.controller.CalculadoraController;
import com.calculadora.controller.EscolherIdiomaController;
import com.calculadora.controller.OpcoesController;
import com.calculadora.controller.RootLayoutController;
import com.calculadora.controller.SobreController;
import com.calculadora.util.Idioma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static final String CAMINHO_ICONE_APLICACAO = "/images/logo.png";

	private ConfigProperties label;
	private Idioma idioma;
	
	private Stage escolherIdiomaStage;
	private Stage rootStage;
	private Stage opcoesStage;
	private Stage sobreStage;

	private AnchorPane escolherIdiomaLayout;
	private AnchorPane sobreLayout;
	private AnchorPane opcoesLayout;
	private BorderPane rootLayout;
	
	private RootLayoutController rootLayoutController;
	private CalculadoraController calculadoraController;
	private EscolherIdiomaController escolherIdiomaController;
	private OpcoesController opcoesController;
	private SobreController sobreController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.escolherIdiomaStage = primaryStage;
		this.escolherIdiomaStage.setTitle("Escolher Idioma");

		initEscolherIdioma();
	}

	public Object getLayout(FXMLLoader loader, String pathFXML) {

		try {
			loader.setLocation(MainApp.class.getResource(pathFXML));
			return loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Stage getStage(Parent pageLayout, String nomeAplicacao, String icone) {
		
		Stage tempStage = new Stage();
		tempStage.initModality(Modality.WINDOW_MODAL);
		tempStage.setResizable(false);
		tempStage.setTitle(nomeAplicacao);
		tempStage.getIcons().add(new Image(icone));
		tempStage.setScene(new Scene(pageLayout));
		
		return tempStage;
	}

	public void initEscolherIdioma() {

		FXMLLoader loader = new FXMLLoader();
		escolherIdiomaLayout = (AnchorPane) getLayout(loader, "/views/EscolherIdioma.fxml");

		escolherIdiomaStage.setScene(new Scene(escolherIdiomaLayout));
		escolherIdiomaStage.getIcons().add(new Image(CAMINHO_ICONE_APLICACAO));
		escolherIdiomaStage.show();

		escolherIdiomaController = loader.getController();
		escolherIdiomaController.show(escolherIdiomaStage, this);
	}
	
	public void initRoot() {
		
		FXMLLoader loader = new FXMLLoader();
		rootLayout = (BorderPane) getLayout(loader, "/views/RootLayout.fxml");
		
		rootStage = getStage(rootLayout, label.getString("root.titulo"), CAMINHO_ICONE_APLICACAO);
		rootStage.show();
		
		rootLayoutController = loader.getController();
		rootLayoutController.setMainApp(this);
		rootLayoutController.setRootStage(rootStage);
		
		FXMLLoader loaderCalculadora = new FXMLLoader();
		AnchorPane calculadoraLayout = (AnchorPane) getLayout(loaderCalculadora, "/views/Calculadora.fxml");
		
		rootLayout.setBottom(calculadoraLayout);
		
		calculadoraController = loaderCalculadora.getController();
		calculadoraController.show(idioma, calculadoraLayout);
	}
	
	public void initOpcoes() {
		
		FXMLLoader loader = new FXMLLoader();
		opcoesLayout = (AnchorPane) getLayout(loader, "/views/Opcoes.fxml");
		
		opcoesStage = getStage(opcoesLayout, "Op��es", CAMINHO_ICONE_APLICACAO);
		opcoesStage.show();
		
		opcoesController = loader.getController();
		opcoesController.show(this, opcoesStage);
	}
	
	public void initSobre() {
		
		FXMLLoader loader = new FXMLLoader();
		sobreLayout = (AnchorPane) getLayout(loader, "/views/Sobre.fxml");
		
		sobreStage = getStage(sobreLayout, "Sobre o Calculadora GEC5", CAMINHO_ICONE_APLICACAO);
		sobreStage.show();
		
		sobreController = loader.getController();
		sobreController.show(rootStage, sobreStage);
	}
	
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
		label = ConfigProperties.getInstance(idioma);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
