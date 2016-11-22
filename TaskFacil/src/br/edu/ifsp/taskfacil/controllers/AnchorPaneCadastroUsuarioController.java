package br.edu.ifsp.taskfacil.controllers;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.edu.ifsp.taskfacil.dao.UsuarioDAO;
import br.edu.ifsp.taskfacil.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AnchorPaneCadastroUsuarioController implements Initializable {

	@FXML
	private TextField txtFieldNome;
	@FXML
	private TextField txtFieldEmail;
	@FXML
	private PasswordField pswFieldSenha;
	@FXML
	private Button btnCadastrar;
	@FXML
	private Button btnCancelar;

	private Usuario usuario = new Usuario();

	private UsuarioDAO dao = new UsuarioDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void cadastrarUsuario() throws NoSuchAlgorithmException {
		this.usuario.setNome(txtFieldNome.getText());
		this.usuario.setEmail(txtFieldEmail.getText());
		this.usuario.setSenha(this.usuario.md5(pswFieldSenha.getText()));

		boolean validaEmail = this.usuario.getEmail().matches("\\w+(\\.)?\\w+@\\w+\\.\\w{2,3}(\\.\\w{2,3})?");
		if (this.dao.existeEmail(this.usuario.getEmail()).isEmpty()) {
			if (validaEmail) {
				dao.inserir(usuario);
			} else
				JOptionPane.showMessageDialog(null, "Favor informar um email válido! Ex: joana@live.com");
		} else
			JOptionPane.showMessageDialog(null, "Email já cadastrado!");
	}

}
