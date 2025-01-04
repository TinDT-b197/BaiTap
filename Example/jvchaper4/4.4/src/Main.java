public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(10);
        point.setY(10);
        System.out.println(point);
        point.setXY(20,30);
        System.out.println(point);
        MovablePoint movablePoint = new MovablePoint();
        movablePoint.setXY(4,6);
        movablePoint.setSpeed(10, 20);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}