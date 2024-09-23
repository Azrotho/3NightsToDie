package fr.azrotho.threenightstodie.objects;

import java.util.UUID;

public class NightPlayer {
    private UUID uuid;
    private long tickInManoir;
    private int death;

    public NightPlayer(UUID uuid) {
        this.uuid = uuid;
        this.tickInManoir = 0;
        this.death = 0;
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
}
