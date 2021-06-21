package enums;

public enum Players {
    PLAYER1("player1"),
    PLAYER2("player2");

    public final String label;

    private Players(String label) {
        this.label = label;
    }
}
