package patterns.top_k_elements.top_k_points;

import java.util.List;
import java.util.Objects;

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
