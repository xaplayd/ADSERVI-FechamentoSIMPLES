package application.gui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.Execution;

public class MagicController {

	Execution executar = new Execution();

	@FXML
	private TextField tfVagas;

	@FXML
	private Button btnVagas;

	@FXML
	private TextField tfLotacao;

	@FXML
	private Button btnLotacao;

	@FXML
	private TextField tfOcorrencias;

	@FXML
	private Button btnOcorrencias;

	@FXML
	private TextField tfCoberturas;

	@FXML
	private Button btnCoberturas;

	@FXML
	private TextField tfSalvarEm;

	@FXML
	private Button btnSalvarEm;

	@FXML
	private Button btnExecutar;

	@FXML
	private Button btnInstrucoes;

	@FXML
	public void btnVagasOnAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Escolha o arquivo das VAGAS");
		fc.setInitialDirectory(new File("c:\\"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
		File selectedFile = fc.showOpenDialog(new Stage());

		if (selectedFile != null) {
			tfVagas.setText(selectedFile.getAbsolutePath());
		}
	}

	@FXML
	public void btnLotacaoOnAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Escolha o arquivo dos COLABORADORES VINCULADOS");
		fc.setInitialDirectory(new File("c:\\"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
		File selectedFile = fc.showOpenDialog(new Stage());

		if (selectedFile != null) {
			tfLotacao.setText(selectedFile.getAbsolutePath());
		}
	}

	@FXML
	public void btnOcorrenciasOnAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Escolha o arquivo das OCORRENCIAS");
		fc.setInitialDirectory(new File("c:\\"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
		File selectedFile = fc.showOpenDialog(new Stage());

		if (selectedFile != null) {
			tfOcorrencias.setText(selectedFile.getAbsolutePath());
		}
	}

	@FXML
	public void btnCoberturasOnAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Escolha o arquivo das COBERTURAS");
		fc.setInitialDirectory(new File("c:\\"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
		File selectedFile = fc.showOpenDialog(new Stage());

		if (selectedFile != null) {
			tfCoberturas.setText(selectedFile.getAbsolutePath());
		}
	}

	@FXML
	public void btnSalvarEmOnAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Salvar em");
		fc.setInitialDirectory(new File("c:\\"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
		File selectedFile = fc.showSaveDialog(new Stage());

		if (selectedFile != null) {
			tfSalvarEm.setText(selectedFile.getAbsolutePath());
		}

	}

	@FXML
	public void btnExecutarOnAction(ActionEvent event) {
		
		executar.consolidar(tfVagas.getText(), tfLotacao.getText(), tfOcorrencias.getText(), tfCoberturas.getText(), tfSalvarEm.getText());

		/*

		if (tfVagas.getText() == "" && tfLotacao.getText() == "" && tfOcorrencias.getText() == ""
				&& tfCoberturas.getText() == "") {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("ERRO");
			alerta.setContentText("Favor identificar todos arquivos para execução da rotina.");
			alerta.setHeaderText("Arquivos de entrada não selecionados!");
			alerta.showAndWait();
		} else if (tfSalvarEm.getText() == "") {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setTitle("ERRO");
			alerta.setContentText("Favor identificar arquivo de saída para execução da rotina.");
			alerta.setHeaderText("Não especificado arquivo de saida!");
			alerta.showAndWait();

		} else {
			executar.consolidar(tfVagas.getText(), tfLotacao.getText(), tfOcorrencias.getText(), tfCoberturas.getText(), tfSalvarEm.getText());
		}*/

	}

	@FXML
	public void btnIntrucoesOnAction(ActionEvent event) {
		try {
			Stage intrucoes = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/gui/instrucoes.fxml"));
			intrucoes.setTitle("Instruções");
			intrucoes.getIcons().add(new Image("/application/imgs/logo2.png"));
			intrucoes.setScene(new Scene(root));
			intrucoes.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
