package com.kasiarakos.model;

/**
 * Created by kasiarakos on 24/10/2017.
 */
public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getNeighbour(int x, int y) {
        return new Position(this.getX() + x, this.getY() + y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position spot = (Position) o;

        if (x != spot.x) return false;
        return y == spot.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}