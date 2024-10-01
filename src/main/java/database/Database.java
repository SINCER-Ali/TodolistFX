package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String serveur = "localhost";

    private String nomDeLaBase = "intro_javafx";

    private String utilisateur = "root";

    private String MotDePasse = "";


    public String getUrl() {
        return "jdbc:mysql://"+serveur+"/"+nomDeLaBase+"?serverTimezone=UTC";
    }
    public Connection getConnection() {
        try {
            Connection cnx = DriverManager.getConnection(this.getUrl(), this.utilisateur, this.MotDePasse);
            System.out.print("État de la connexion :");
            System.out.print(cnx.isClosed() ? "fermée" : "ouverte \r\n");
            return cnx;
        } catch (SQLException e) {
            System.out.print("Erreur lors de la tentative de connexion à la base de données");
            e.printStackTrace();
            return null;
        }
    }
}



