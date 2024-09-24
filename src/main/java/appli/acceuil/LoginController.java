package appli.acceuil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.Objects;

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
    void OnClickConnexion(ActionEvent event) {
        if (Objects.equals(this.email.getText(), "") || Objects.equals(this.Mdp.getText(), "")) {
            System.out.println("test");
            this.erreur.setText("Erreur");
        }else{
            System.out.println("test2");
            StartApplication.changeScene("acceuil/page-acceuil");

        }
    }

    @FXML
    void OnClickInscription(ActionEvent event) {
        StartApplication.changeScene("accueil/inscriptionView");
    }

    @FXML
    void OnClickMdp(ActionEvent event) {
        StartApplication.changeScene("accueil/loginView");
    }

}


