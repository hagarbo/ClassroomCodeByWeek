package edu.hagarbo.brunosboxing;

import java.util.ArrayList;

public class ScoreCard {
    private static final String[] HEADERS = { "Round 1", "Round 2", "Round 3", "Round 4", "Round 5",
            "Round 6", "Round 7", "Round 8", "Round 9", "Round 10" };
    private String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard;
    public ArrayList<Round> rounds = new ArrayList<>();

    public ScoreCard(String color) {
        this.color = color;
    }

    public void setRCorner(String boxerName) {
        this.redCorner = boxerName;
    }

    public void setBCorner(String boxerName) {
        this.blueCorner = boxerName;
    }

    public byte getNumRounds() {
        return (byte) this.rounds.size();
    }

    @Override
    public String toString() {
        String output = "\t\t\t\t" + this.color.toUpperCase() + "\t\t\t\t\n";
        output += "\t\t" + this.redCorner + "\t" + this.blueCorner + "\n";
        output += "\t\t\t\t" + this.getNumRounds() + " rounds" + "\t\t\t\t\n";
        output += "Round Score" + "\t" + "Total Score" + "\t" + "Round" + "\t" + "Total Score" + "\t" + "Round Score";
        return output;
    }

    public void loadJudgeScoreCard(String... judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;
        for (String round : judgeScoreCard) {
            this.rounds.add(RoundFactory.getRound(round));
        }
    }

    public int getRedBoxerFinalScore() {
        return 0;
    }

    public int getBlueBoxerFinalScore() {
        return 0;
    }

    private String viewRounds() {
        return "UNIMPLEMENTED";
    }
}
