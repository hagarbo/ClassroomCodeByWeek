package edu.hagarbo.brunosboxing;

public class RegularRound implements Round {

    String roundScore = "";
    private byte blueBoxerScore = 0;
    private byte redBoxerScore = 0;

    RegularRound(String roundScore) {
        this.roundScore = roundScore;
    }

    @Override
    public byte getRedBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public byte getBlueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public void boxerRoundScore() {
        this.redBoxerScore = 10;
        this.blueBoxerScore = 9;
    }

    @Override
    public String toString() {
        return "RegularRound [roundScore=" + roundScore + "]";
    }

}
