package fr.azrotho.threenightstodie.objects;

import java.util.UUID;

public class NightPlayer {
    private UUID uuid;
    private long tickInManoir;
    private int death;
    private int vote;
    private boolean isMayor;
    private boolean isEliminated;
    private boolean hasVoted;
    private boolean isTarget;
    private boolean hasChangedColor;
    private boolean hasTargeted;

    public NightPlayer(UUID uuid) {
        this.uuid = uuid;
        this.tickInManoir = 0;
        this.death = 0;
        this.vote = 0;
        this.isMayor = false;
        this.isEliminated = false;
        this.hasVoted = false;
        this.isTarget = false;
        this.hasChangedColor = false;
        this.hasTargeted = false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public long tickInManoir() {
        return tickInManoir;
    }

    public void setTickInManoir(long tickInManoir) {
        this.tickInManoir = tickInManoir;
    }

    public int death() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int vote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public boolean isMayor() {
        return isMayor;
    }

    public void setMayor(boolean mayor) {
        isMayor = mayor;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public boolean isTarget() {
        return isTarget;
    }

    public void setTarget(boolean target) {
        isTarget = target;
    }

    public boolean hasChangedColor() {
        return hasChangedColor;
    }

    public void setHasChangedColor(boolean hasChangedColor) {
        this.hasChangedColor = hasChangedColor;
    }

    public boolean hasTargeted() {
        return hasTargeted;
    }

    public void setHasTargeted(boolean hasTargeted) {
        this.hasTargeted = hasTargeted;
    }
}
