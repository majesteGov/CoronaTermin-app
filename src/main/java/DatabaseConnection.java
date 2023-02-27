import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    // Utilisation d'une variable dataSource pour stocker l'instance du pool de connexions
    private static final MysqlDataSource dataSource = new MysqlDataSource();

    static {
        // Chargement des informations de connexion à partir d'un fichier de propriétés
        Properties props = new Properties();
        try (InputStream in = DatabaseConnection.class.getResourceAsStream("my.cnf")) {
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }

        // Configuration de l'objet dataSource avec les informations de connexion
        dataSource.setURL(props.getProperty("db.url"));
        dataSource.setUser(props.getProperty("db.user"));
        dataSource.setPassword(props.getProperty("db.password"));
    }

    /**
     * Obtient une connexion à la base de données à partir du pool de connexions.
     *
     * @return une connexion à la base de données
     * @throws RuntimeException si la connexion ne peut pas être obtenue
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get database connection", e);
        }
    }
}
