package jdbchfdst03;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBChfdst03Main {
    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String UPDATE_PRIJS = "update planten set verkoopprijs = verkoopprijs * 1.1";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                /*
                De Connection method createStatement geeft je een Statement object.
                Je moet een Statement na gebruik sluiten.
                Statement erft van AutoCloseable.
                Je maakt het Statement daarom ook tussen de ronde haakjes van de try opdracht.
                De compiler maakt dan zelf code die dit Statement sluit in een finally blok.
                */
                Statement statement = connection.createStatement()) {
            /*
            Geef aan de method executeUpdate een SQL statement mee.
            De method voert dit SQL statement uit en geeft het aantal aangepaste records terug.
            */
            System.out.println(statement.executeUpdate(UPDATE_PRIJS));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
