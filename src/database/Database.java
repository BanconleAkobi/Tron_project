package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    // Informations de connexion à la base de données
    private static final String URL = "jdbc:postgresql://localhost:5432/nom_de_la_base"; // Remplace "nom_de_la_base" par le nom de ta base
    private static final String USER = "nom_utilisateur"; // Ton nom d'utilisateur PostgreSQL
    private static final String PASSWORD = "mot_de_passe"; // Ton mot de passe PostgreSQL

    // Instance unique de la connexion
    private static Connection connection = null;

    /**
     * Méthode pour obtenir une connexion à la base de données.
     * 
     * @return Connection Objet Connection pour interagir avec la base de données.
     * @throws SQLException Si une erreur survient lors de la connexion.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Charger le driver JDBC pour PostgreSQL
                Class.forName("org.postgresql.Driver");
                // Établir la connexion
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion réussie à la base de données !");
            } catch (ClassNotFoundException e) {
                System.err.println("Le driver PostgreSQL est introuvable !");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Échec de la connexion à la base de données !");
                e.printStackTrace();
                throw e; // Relancer l'exception pour être traitée ailleurs
            }
        }
        return connection;
    }

    /**
     * Méthode pour fermer la connexion à la base de données.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion à la base de données fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion !");
                e.printStackTrace();
            }
        }
    }
}
