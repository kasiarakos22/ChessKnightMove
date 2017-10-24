package com.kasiarakos.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test
    public void shouldSortTheList(){

        //when a list contains multiple paths
        List<Path> list = new ArrayList<>();
        list.add(new Path(Arrays.asList(new Position(0,0),new Position(2,1),new Position(3,3))));
        list.add(new Path(Arrays.asList(new Position(0,0),new Position(3,3))));
        list.add(new Path(Arrays.asList(new Position(0,0))));
        list.add(new Path(Arrays.asList(new Position(0,0),new Position(2,1),new Position(3,3), new Position(4,5))));

        //should sort the list
        Collections.sort(list);
        assert list.get(0).getVisitedPositions().size() == 1;
    }


}
