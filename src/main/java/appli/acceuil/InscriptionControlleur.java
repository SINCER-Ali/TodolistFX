package appli.acceuil;

import appli.StartApplication;
import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.repository.UtilisateurRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InscriptionControlleur {

    @FXML
    private TextField email;

    @FXML
    private Button inscription;

    @FXML
    private PasswordField mdp;

    @FXML
    private PasswordField mdp_c;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button retour;

    @FXML
    void onClickInscription(ActionEvent event) throws SQLException {
        Database database = new Database();
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        if (this.nom.getText().isEmpty()||this.prenom.getText().isEmpty()||this.email.getText().isEmpty()||this.mdp.getText().isEmpty()||this.mdp_c.getText().isEmpty()) {
            StartApplication.changeScene("inscriptionView");
        }
        if (this.mdp.getText().equals(mdp_c.getText())) {
            ResultSet resultat = utilisateurRepository.inscription(this.email.getText());
            System.out.println(mdp_c);
            if (resultat.next()) {
                System.out.println("2");
                StartApplication.changeScene("acceuil/inscriptionView");
            }else {
                PreparedStatement requetePrepareInsert = database.getConnection().prepareStatement("INSERT INTO Utilisateur(nom,prenom,email,mot_de_passe) VALUES(?,?,?,?)");
                requetePrepareInsert.setString(1, this.nom.getText());
                requetePrepareInsert.setString(2, this.prenom.getText());
                requetePrepareInsert.setString(3, this.email.getText());
                requetePrepareInsert.setString(4, this.mdp_c.getText());
                requetePrepareInsert.executeUpdate();
                StartApplication.changeScene("acceuil/loginView");

            }

        }else {

            StartApplication.changeScene("acceuil/inscriptionView");
        }
    }

    @FXML
    void onClickRetour(ActionEvent event) {

    }

}
