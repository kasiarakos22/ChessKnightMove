package com.kasiarakos.service;

import com.kasiarakos.model.Board;
import com.kasiarakos.model.Path;
import com.kasiarakos.model.Position;

import java.util.*;

/**
 * Created by kasiarakos on 24/10/2017.
 */
public class PathFinder {

    public List<Path> findValidPathsInSteps(Board board ,int numOfSteps , Position start, Position end) {

        Queue<Path> q = new ArrayDeque<>();

        ArrayList<Path> validPaths = new ArrayList<>();
        int level = 0;

        Path starting_path = new Path(Arrays.asList(start));
        q.add(starting_path);

        while (!q.isEmpty() && level <= numOfSteps+1) {
            Path currentPath = q.remove();
            ArrayList<Path> paths = currentPath.getMoves( board);
            if (!paths.isEmpty()) {
                for (Path path : paths) {
                    if (path.getLastPosition().equals(end)) {
                        validPaths.add(path);
                    } else {
                        q.add(path);
                    }
                    level = path.getVisitedPositions().size();
                }
            }
        }

        return validPaths;
    }
}
