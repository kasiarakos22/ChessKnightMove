package com.kasiarakos.app;

import com.kasiarakos.model.Board;
import com.kasiarakos.model.Path;
import com.kasiarakos.model.Position;
import com.kasiarakos.service.PathFinder;

import java.util.*;

/**
 * Created by kasiarakos on 24/10/2017.
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Give me start position x and y: (should be between 0-8)");
        int startX = in.nextInt();
        int startY = in.nextInt();

        System.out.println("Give me end position x and y: (should be between 0-8)");
        int endX = in.nextInt();
        int endY = in.nextInt();

        Position start = new Position(startX ,startY);
        Position end = new Position(endX,endY);
        Board board = new Board(8);

        List<Path> validPaths = new PathFinder().findValidPathsInSteps(board, 3, start, end);

        if(validPaths.isEmpty()){
            System.out.println("No solution has been found");
        }else{
            System.out.println(validPaths.get(0));
        }
    }

}
