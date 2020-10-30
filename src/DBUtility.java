import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    //the user name and password should reflect YOUR system
    private static String user = "admin";
    private static String password = "Jesus2013!";

    /**
     * This method will write a new game into the DB and return
     * the gameID
     * @param newGame
     * @return gameID (primary key from the DB)
     */
    public static int insertNewGame(Game newGame) throws SQLException {
        //1.define connection, prepared statement
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        int gameID = -1;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection("jdbc:mysql://callofdutyrevenues.czusevfuz65x.us-east-2.rds.amazonaws.com/CallOfDutyRevenues",
                    user, password);
            //2. Create a sql command
            String sql = "INSERT INTO games (title, publisher, releaseDate, grossRevenue, rating) VALUES" + "(?,?,?,?,?)";

            //3. Create a prepared statement
            ps = conn.prepareStatement(sql, new String[] {"gameID"});

            //4. bind the values
            ps.setString(1, newGame.getTitle());
            ps.setString(2, newGame.getPublisher());
            ps.setDate(3, Date.valueOf(newGame.getReleaseDate()));
            ps.setDouble(4, newGame.getGrossRevenue());
            ps.setInt(5, newGame.getRating());


            //5. execute the insert
            ps.executeUpdate();

            //6. get the gameID returned
            rs = ps.getGeneratedKeys();

            while(rs.next())
            {
                gameID = rs.getInt(1);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
            return gameID;
        }
    }

    /**
     * This method will return ALL games in the database
     */
    public static ArrayList<Game>
    getAllGamesFromDB() throws SQLException {
        ArrayList<Game> games = new ArrayList<>();

        //1.define connection, prepared statement
        Connection conn = null;

        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection("jdbc:mysql://callofdutyrevenues.czusevfuz65x.us-east-2.rds.amazonaws.com/CallOfDutyRevenues",
                    user, password);
            //2. Create a sql statement
            statement = conn.createStatement();

            //3.  execute the SQL statement and capture results in the resultSet
            resultSet = statement.executeQuery("SELECT * FROM games");

            //4. loop over the result set and create game objects
            while(resultSet.next())
            {
                Game newGame = new Game(
                            resultSet.getInt("gameID"),
                            resultSet.getString("title"),
                            resultSet.getString("publisher"),
                             resultSet.getDate("releaseDate").toLocalDate(),
                            resultSet.getDouble("grossRevenue"),
                            resultSet.getInt("rating")
                );
                games.add(newGame);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return games;
        }

    }
}