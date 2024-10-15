package fr.azrotho.threenightstodie.objects;

public class NightGame {

    private boolean voteEnabled;
    private boolean targetPlayerEnabled;


    public NightGame() {
        this.voteEnabled = false;
        this.targetPlayerEnabled = true;
    }

    public boolean isVoteEnabled() {
        return voteEnabled;
    }

    public void setVoteEnabled(boolean voteEnabled) {
        this.voteEnabled = voteEnabled;
    }

    public boolean isTargetPlayerEnabled() {
        return targetPlayerEnabled;
    }

    public void setTargetPlayerEnabled(boolean targetPlayerEnabled) {
        this.targetPlayerEnabled = targetPlayerEnabled;
    }

    
}
