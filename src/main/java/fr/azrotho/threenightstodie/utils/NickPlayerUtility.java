package fr.azrotho.threenightstodie.utils;

import org.bukkit.entity.Player;
import xyz.haoshoku.nick.api.NickAPI;

public class NickPlayerUtility {
    private final String SKIN_VALUE = "ewogICJ0aW1lc3RhbXAiIDogMTczMTQyMjg3ODQ0NSwKICAicHJvZmlsZUlkIiA6ICIyYzI1NjFhYTRmOGM0MDliODA1ZjI2YmMyMzM0NGQzYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJBenJvdGhvIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2VhYmU1Y2Y3NDA0NDFjNTFjMGQ5Y2QxODIyZTMzNTIxZmM1YWIyODc4ZTY0NDBlYWMwZTFmYzBmYTIxYTBlOWYiCiAgICB9CiAgfQp9";
    private final String SKIN_SIGNATURE = "BZKP251EBzc+hhPBe9+VEwmzExqCUOGQ2oV0u7Ph4474RxPiS6NkVAsX/vP7dQt3/HY5CKeJxCb3B6mE7U5KCfGvRwMfIyBPKc6rA/yDwS7rbmvtd46hdzwBEso6w2HpJJFZqBni24gBNPyepUSHnKFyWvz81Ki9NugY10lyzw1hUK6BwRLOeWKXDmn/jIyUEffhcKA0IjxwJtwIO6WUbhu3sTzrkz81Md9ICsGZq5Y+gkAPXseltWGe5iTKzhhmIVuNlgwUfX+dSUxKMHrLZvbSPxYQOYbY1Njp6NXCK8M6WTxGwk4BH25q7/RxaDYI/xfHBwp+Y4SzJZus7WVjm8ZVTC9/cDJxYLPMxSZDF/L9o/M25RIkXs9KqyAOdUc9ZB7CoN6F2UIZfIqqphI+5KccXS2Z8Vh4t9BFzirD8FtRYQmZdIYTWnoVbLOd58V//+NzLEvhyF+PMij27iHPZ8z/WFZh133P0ibT11Y3j0UYglJfopHM096ICVUpeoBYUXGQlkBlmjISdbUCMNKWVhWXacfUMFBtB9PWfeDkufgnZ9hh55Kf7Zom58qlwvlgP8VjR+zKFoXMQd17ooFgkL6sxBWH8svy3jmJPemTKriha6mIVC/chBiS397EegAKjIIrsTMGZbG6Mc3bt/tArmz3cBqGpkn4lQU3guRHAtw=";

    public void anonimizePlayer(Player player) {
        NickAPI.setNick(player, "§kAnonyme");
        NickAPI.setSkin(player, SKIN_VALUE, SKIN_SIGNATURE);
        NickAPI.refreshPlayer(player);
    }

    public void resetPlayer(Player player) {
        NickAPI.resetNick(player);
        NickAPI.resetSkin(player);
        NickAPI.refreshPlayer(player);
    }
}
