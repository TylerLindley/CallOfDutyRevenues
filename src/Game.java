import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class Game {
    private int gameID;
    private String title, publisher;
    private LocalDate releaseDate;
    private double grossRevenue;
    private int rating;


    /**
     * This constructor should be used for an existing patient already defined in the DB
     * @param title
     * @param publisher
     * @param grossRevenue
     * @param releaseDate
     */
    public Game(String title, String publisher, LocalDate releaseDate, double grossRevenue, int rating) throws SQLException {
        setTitle(title);
        setPublisher(publisher);
        setGrossRevenue(grossRevenue);
        setReleaseDate(releaseDate);
        setRating(rating);
        gameID = DBUtility.insertNewGame(this);
    }

    /**
     * This constructor will automatically add a valid Patient to the
     * database
     * @param title
     * @param publisher
     * @param releaseDate
     * @param rating
     * @throws SQLException
     */
    public Game(int gameID, String title, String publisher, LocalDate releaseDate, double grossRevenue, int rating) {
        setGameID(gameID);
        setTitle(title);
        setPublisher(publisher);
        setReleaseDate(releaseDate);
        setRating(rating);
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.matches("[A-Z][a-zA-Z]*[-]?[A-z]*?"))
            this.title = title;
        else
            throw new IllegalArgumentException("First name must start with a capital and have more than 1 letter");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher.matches("[A-Z][a-zA-Z]*[-]?[A-z]*?"))
            this.publisher = publisher;
        else
            throw new IllegalArgumentException("Last name must start with a capital and have more than 1 letter");

    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        if (releaseDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("releaseDate cannot be in the future");
        if (Period.between(LocalDate.now(), releaseDate).getYears()>250)
            throw new IllegalArgumentException("releaseDate for a new patient cannot be over 250 years ago");
        this.releaseDate = releaseDate;
    }
    public double getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(double grossRevenue) {
        this.grossRevenue = grossRevenue;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String toString()
    {
        return String.format("Patient #: %d-%s %s",
                gameID, title, publisher);
    }
}
