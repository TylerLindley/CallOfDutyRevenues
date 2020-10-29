import java.sql.SQLException;
import java.time.LocalDate;

public class GameTester {
    public static void main(String[] args) {
        /**
         * Testing
         */
        try {
            Game newGame = new Game("Testing", "Testing", LocalDate.of(2000, 01, 01), 250000.0,5);
            System.out.println("The gameID is: " + newGame.getGameID());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}