import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database {

  // todo remove this temporary main method
  public static void main(String argv[]) throws SQLException{
//    final String URL = "jdbc:postgresql://127.0.0.1:5433/delivery";
    final String URL = "jdbc:postgresql://127.0.0.1:5433/delivery_test";
    final String USER = "user";
    final String PASSWORD = "pass";

    Database database = new Database(URL, USER, PASSWORD);
    database.dropall();
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
  private String url;
  private String user;
  private String password;

  public Database(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public void lock() throws SQLException {
    String query = "SELECT * from migrations WHERE version = 'lock' FOR UPDATE;";
    try (
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query)
    ) {
      LOGGER.info("Locked for migration - {}", query);
    }
  }

  public void executeMigration(String query) throws IOException, SQLException {
    try (
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement()
    ) {
      LOGGER.info("Executing migration - {}", query);
      statement.executeUpdate(query);
    }
  }

  public List<String> versions() throws SQLException {
    List<String> versions = new ArrayList<>();
    String query = "SELECT version FROM migrations;";
    LOGGER.info("Getting list of already executed migrations - {}", query);
    try (
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query)
    ) {
      while (rs.next()) {
        versions.add(rs.getString("version"));
      }
    }
    return versions;
  }

  public void registerUpdate(String version) throws SQLException {
    try (
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement()
    ) {
      String query = String.format("INSERT INTO migrations (version) VALUES ('%s');", version);
      LOGGER.info("Registering migration - {}", query);
      statement.executeUpdate(query);
    }
  }

  // todo remove this temporary main method
  public void dropall() throws SQLException {
    List<String> queries = Arrays.asList(
        "DROP table schedule_deliveries",
        "DROP table schedules",
        "DROP table requests",
        "DROP table tour_deliveries",
        "DROP table tours",
        "DROP table trip_assign",   //comment out this
        "DROP table vans_locations",
        "DROP table speed_profiles_vans",
        "DROP table speed_profiles",
        "DROP table shifts",
        "DROP table drivers",
        "DROP table payments",
        "DROP table users_keys",
        "DROP table depots_users",
        "DROP table orders",
        "DROP table vans",
        "DROP table depots",
        "DROP table users",
        "DROP table roles",
        "DROP table businesses",
        "DELETE from migrations WHERE NOT version = 'lock'");

    try (
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement()
    ) {
      for (String query : queries) {
        try {
          statement.executeUpdate(query);
          LOGGER.info("{} - OK", query);
        } catch (SQLException e) {
          LOGGER.info("{} - FAILED", query);
        }
      }
    }
  }
}
