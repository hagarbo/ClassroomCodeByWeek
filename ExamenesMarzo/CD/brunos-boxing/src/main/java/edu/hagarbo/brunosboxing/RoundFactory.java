package edu.hagarbo.brunosboxing;

public class RoundFactory {

    private static final String NORMAL_ROUND_REGEXP = "(9 - 10)|(10 - 9)";
    private static final String KNOCKOUT_ROUND_REGEXP = "(8 - 10)|(10 - 8)";
    private static final String POINTS_DEDUCTED_REGEXP = "(8 ,1 - 10)|(10 - 8 ,1)";

    public static Round getRound(String roundScore) {
        if (isNormalRound(roundScore))
            return new RegularRound(roundScore);
        if (isKnockoutRound(roundScore))
            return new KnockdownRound(roundScore);
        if (isPointsDeducted(roundScore))
            return new PointsDeducted(roundScore);
        return null;
    }

    private static boolean isNormalRound(String roundScore) {
        return roundScore.matches(NORMAL_ROUND_REGEXP);
    }

    private static boolean isKnockoutRound(String roundScore) {
        return roundScore.matches(KNOCKOUT_ROUND_REGEXP);
    }

    private static boolean isPointsDeducted(String roundScore) {
        return roundScore.matches(POINTS_DEDUCTED_REGEXP);
    }

}
