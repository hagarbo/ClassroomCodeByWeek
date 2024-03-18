package edu.hagarbo.brunosboxing;

public class KnockdownRound implements Round {

    private String roundScore = "";
    private byte blueBoxerScore = 0;
    private byte redBoxerScore = 0;

    KnockdownRound(String roundScore) {
        this.roundScore = roundScore;
    }

    @Override
    public byte getRedBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public byte getBlueBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public void boxerRoundScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'boxerRoundScore'");
    }

    @Override
    public String toString() {
        return "KnockdownRound [roundScore=" + roundScore + "]";
    }

}
