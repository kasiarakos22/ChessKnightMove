package com.kasiarakos.model;

import org.junit.Test;


/**
 * Created by kasiarakos on 24/10/2017.
 */
public class PositionTest {

    @Test
    public void shouldReturnSpotOneTwo() {
        //when position is {0,0}
        Position position = new Position(0,0);

        //given coordinates 2, 1
        Position resultPosition = position.getNeighbour(2,1);

        //then position should be 2,1
        assert resultPosition.equals(new Position(2,1));
    }
}
