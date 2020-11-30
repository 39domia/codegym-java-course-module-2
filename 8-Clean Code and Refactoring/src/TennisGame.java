public class TennisGame {
    public static final int WIN_POINT = 4;
    public int tempScore = 0;
    String score = "";

    public String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            score(player1Score);
        } else if (player1Score >= WIN_POINT || player2Score >= WIN_POINT) {
            tieBreak(player1Name, player2Name, player1Score, player2Score);
        } else {
            knockout(player1Score, player2Score);
        }
        return score;
    }

    private void knockout(int player1Score, int player2Score) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0 -> score += "Love";
                case 1 -> score += "Fifteen";
                case 2 -> score += "Thirty";
                case 3 -> score += "Forty";
            }
        }
    }

    private void tieBreak(String player1Name, String player2Name, int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = "Advantage" + player1Name;
        else if (minusResult == -1) score = "Advantage" + player2Name;
        else if (minusResult >= 2) score = "Win for"+ player1Name;
        else score = "Win for" + player2Name;
    }

    private void score(int player1Score) {
        switch (player1Score) {
            case 0 -> score = "Love-All";
            case 1 -> score = "Fifteen-All";
            case 2 -> score = "Thirty-All";
            case 3 -> score = "Forty-All";
            default -> score = "Deuce";
        }
    }
}

