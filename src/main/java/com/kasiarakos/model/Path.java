package com.kasiarakos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasiarakos on 24/10/2017.
 */
public class Path implements Comparable<Path> {

    private List<Position> visitedPositions;

    public Path(List<Position> visited_positions) {
        this.visitedPositions = visited_positions;
    }

    public List<Position> getVisitedPositions() {
        return visitedPositions;
    }

    public Position getLastPosition(){
        return this.getVisitedPositions().get(visitedPositions.size()-1);
    }

    public ArrayList<Path> getMoves( Board board) {
        ArrayList<Path> possibleMoves = new ArrayList<>();
        int[][] offsets = {
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1}
        };

        for (int[] offset : offsets) {
            Position currentPosition = this.getLastPosition();
            Position neighbour = currentPosition.getNeighbour(offset[0], offset[1]);
            if(isValid(currentPosition, neighbour, board )
                    && !isVisited( neighbour)) {

                ArrayList<Position> newVisited = new ArrayList(visitedPositions);
                newVisited.add(neighbour);
                possibleMoves.add(new Path(newVisited));
            }
        }

        return possibleMoves;
    }

    private boolean isValid(Position from, Position to,  Board board) {
        int size = board.getSize();
        if(to.getX() < 0 || to.getX() > size || from.getX() < 0 || from.getX() > size || to.getY() < 0 || to.getY() > size || from.getY() <0 || from.getY() > size)
            return false;
        return true;
    }

    private boolean isVisited(Position position) {
        return (this.getVisitedPositions().contains(position));
    }

    @Override
    public String toString() {
        return "Path{" +
                "visitedPositions=" + visitedPositions +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Path)) return false;

        Path path = (Path) o;

        return getVisitedPositions() != null ? getVisitedPositions().equals(path.getVisitedPositions()) : path.getVisitedPositions() == null;
    }

    @Override
    public int hashCode() {
        return getVisitedPositions() != null ? getVisitedPositions().hashCode() : 0;
    }

    @Override
    public int compareTo(Path path) {
        if(this.getVisitedPositions().size() > path.getVisitedPositions().size()){
            return 1;
        }else {
            return -1;
        }
    }
}
