package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.util.RandomUtils;

public class Game {
    private String id;
    private String userId;
    private int map;
    private boolean finished;
    private int points;
    private int coins;

    public Game() {}

    public Game(String userId) {
        this.id = RandomUtils.getId();
        this.userId = userId;
        this.map = 0;
        this.finished = false;
        this.points = 0;
        this.coins = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", map=" + map +
                ", finished=" + finished +
                ", points=" + points +
                ", coins=" + coins +
                '}';
    }
}
