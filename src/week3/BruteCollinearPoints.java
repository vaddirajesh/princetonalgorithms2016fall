package week3;

/**
 * Created by rajvaddi on 9/26/16.
 */
public class BruteCollinearPoints {

    private int numberOfSegments = 0;
    LineSegment[] lineSegments ;

    public BruteCollinearPoints(Point[] points) {
        lineSegments = new LineSegment[1];
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {

            }
        }
    }

    public int numberOfSegments() {
        return this.numberOfSegments;
    }

    public LineSegment[] segments() {
        return this.lineSegments;
    }

    private void resize(int newSize) {
        LineSegment[] oldLineSegment = lineSegments;
        LineSegment[] newLineSegments = (LineSegment[]) new Object[newSize];

        for (int i = 0, j = 0; i < oldLineSegment.length; i++) {
                            newLineSegments[j] = oldLineSegment[i];
                j++;

        }
        lineSegments = newLineSegments;
    }
}
