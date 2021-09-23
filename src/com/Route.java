package com;

public class Route {
    private char start;
    private char end;
    private int distance;

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "start=" + start +
                ", end=" + end +
                ", distance=" + distance +
                '}';
    }
}
//1
//A
//B
//20
//1
//A
//C
//45
//1
//A
//D
//25
//1
//B
//F
//90
//1
//B
//G
//35
//1
//C
//E
//10
//1
//D
//G
//30
//1
//E
//H
//35
//1
//F
//G
//30
//1
//G
//H
//40


