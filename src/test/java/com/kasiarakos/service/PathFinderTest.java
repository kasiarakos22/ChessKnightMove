package com.kasiarakos.service;

import com.kasiarakos.model.Board;
import com.kasiarakos.model.Path;
import com.kasiarakos.model.Position;
import org.junit.Test;

import java.util.List;

/**
 * Created by kasiarakos on 24/10/2017.
 */
public class PathFinderTest {

    @Test
    public void shouldReturnTwoPaths(){

        //when board is 8x8
        Board board = new Board(8);

        //given the start is {0,0}
        //the end {3,3}
        //and the number of moves 3
        Position start = new Position(0,0);
        Position end  = new Position(3,3);
        int numOfSteps = 3;

        //then it should return 2 paths
        PathFinder service = new PathFinder();
        List<Path> paths = service.findValidPathsInSteps(board,numOfSteps,start,end);
        assert paths.size() == 2;
    }
}
