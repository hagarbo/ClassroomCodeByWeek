package edu.hagarbo.brunosboxing;

public class PointsDeducted implements Round {

    private String roundScore = "";
    private byte blueBoxerScore = 0;
    private byte redBoxerScore = 0;

    PointsDeducted(String roundScore) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'boxerRoundScore'");
    }

    @Override
    public String toString() {
        return "PointsDeducted [roundScore=" + roundScore + "]";
    }

    private Byte parseComaBlue(String score) {
        return Byte.parseByte(score);
    }

    private Byte parseComaRed(String score) {
        return Byte.parseByte(score);
    }
}
