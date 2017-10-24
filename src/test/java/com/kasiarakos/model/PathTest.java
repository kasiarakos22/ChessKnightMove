package com.kasiarakos.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kasiarakos on 24/10/2017.
 */

public class PathTest {

    @Test
    public void shouldReturnValidLastPosition(){
        //when Path is [{0,0}, {2,1}]
        Path path = new Path(Arrays.asList(new Position(0,0), new Position(2,1)));

        //currentPosition should be {2,1}
        Position currentPosition = path.getLastPosition();
        assert currentPosition.equals(new Position(2,1));
    }

    @Test
    public void shouldReturnTheValidListOfPositions(){

        //when current position is {2,1}
        Position startPosition = new Position(0,0);
        Position currentPosition = new Position(2,1);

        //given the path is [{0,0}, {2,1}]
        Path path = new Path(Arrays.asList(startPosition, currentPosition));

        //should return size 2
        assert path.getVisitedPositions().size() == 2;
    }

    @Test
    public void shouldReturnTwoPositions() {
        //when Path is [{0,0}]
        Path path = new Path(Arrays.asList(new Position(0,0)));

        //Given the Board is 8x8
        Board board = new Board(8);

        //getVisitedPositions should return two and contains Path [{0,0} , {2,1}]
        List<Path> resultPaths = path.getMoves(board);
        Path expectedPath = new Path(Arrays.asList(new Position(0,0), new Position(2,1)));

        assert resultPaths.size() == 2;
        assert resultPaths.contains(expectedPath);
    }


}
