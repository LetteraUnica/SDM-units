public class TennisGame1 implements TennisGame {

    private final String namePlayer1;
    private final String namePlayer2;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public TennisGame1(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public void addPoint(String playerName) {
        if (playerName.equals(namePlayer1))
            scorePlayer1 += 1;
        else if (playerName.equals(namePlayer2))
            scorePlayer2 += 1;
        else {
            throw new IllegalArgumentException("The given player is not in the game");
        }
    }

    public String getScore() {
        String scoreString;

        if (isEven()) {
            scoreString = getEvenScore();

        } else if (isAdvantage()) {
            scoreString = getAdvantageScore();

        } else {
            scoreString = getScoreFromLoveToForty();
        }
        return scoreString;
    }

    private boolean isEven() {
        return scorePlayer1 == scorePlayer2;
    }

    private boolean isAdvantage() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private String getScoreFromLoveToForty() {
        String scoreString;
        scoreString = numberToTennisScore(scorePlayer1) +
                "-" +
                numberToTennisScore(scorePlayer2);
        return scoreString;
    }

    private String numberToTennisScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return null;
    }

    private String getAdvantageScore() {
        int scoreDifference = scorePlayer1 - scorePlayer2;
        if (scoreDifference == 1) return "Advantage " + namePlayer1;
        if (scoreDifference == -1) return "Advantage " + namePlayer2;
        if (scoreDifference >= 2) return "Win for " + namePlayer1;
        return "Win for " + namePlayer2;
    }

    private String getEvenScore() {
        switch (scorePlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
