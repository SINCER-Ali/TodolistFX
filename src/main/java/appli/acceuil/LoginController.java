package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Entity.Utilisateur;
import model.repository.UtilisateurRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private PasswordField Mdp;

    @FXML
    private Button connexion;

    @FXML
    private TextField email;

    @FXML
    private Label erreur;

    @FXML
    private Button inscription;

    @FXML
    private Button motdepasseoublie;

    @FXML
    void OnClickConnexion(ActionEvent event) throws SQLException {

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        ResultSet data = utilisateurRepository.connection(this.email.getText(), this.Mdp.getText());
        if (data.next()) {
            Utilisateur userControlleur = new Utilisateur(data.getInt(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5));

            StartApplication.changeScene("acceuil/AccueilView");
        }else {
            StartApplication.changeScene("acceuil/loginView");
        }

    }

    @FXML
    void OnClickInscription(ActionEvent event) {
        StartApplication.changeScene("acceuil/inscriptionView");
    }

    @FXML
    void OnClickMdp(ActionEvent event) {
        StartApplication.changeScene("accueil/loginView");
    }

}


