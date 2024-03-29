import java.sql.SQLException;
import java.time.LocalDate;

public class GameTester {
    public static void main(String[] args) {
        try {
            Game newGame = new Game("Call of Duty Modern Warfare", "Infinity Ward", LocalDate.of(2000, 01, 01), 2147000000,5);
            System.out.println("The with gameID " + newGame.getGameID() + " is: " + newGame.getTitle() + " and has grossed: $" + newGame.getGrossRevenue() + " revenue." );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}