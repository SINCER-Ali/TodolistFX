package appli.acceuil;

import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.Entity.Liste;

import java.net.URL;
import java.util.ResourceBundle;

public class AcceuilControlleur implements Initializable{
    private TableView<Liste> tableauListe;
    String [][] colones = {
            {"Id liste","idliste"},
            {"Non","nom"}
    };
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}
