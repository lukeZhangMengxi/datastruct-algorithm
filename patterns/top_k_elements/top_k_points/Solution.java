package patterns.top_k_elements.top_k_points;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

class Point {
    int x;
    int y;
  
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
  
    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }

    @Override
    public boolean equals(Object other) {
        return this.x == ((Point)other).x && this.y == ((Point)other).y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}

interface Solution {
    
    List<Point> findClosestPoints(Point[] points, int k);

}

class PriorityQ implements Solution {

    @Override
    public List<Point> findClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> q = new PriorityQueue<>(
            k+1,
            (a, b) -> b.distFromOrigin() - a.distFromOrigin()
        );

        for (Point p: points) {
            q.add(p);
            if (q.size() > k) q.poll();
        }

        return new ArrayList<>(q);
    }

}
