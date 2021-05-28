
public class NameAndScore {
    private String name = "Player";
    private int score = -1;

    public NameAndScore(final int score, final String name) {
        this.score = score;
        this.name = name;
    }

    public String toString() {
        return String.format("%s: %d", this.name, this.score);
    }
}