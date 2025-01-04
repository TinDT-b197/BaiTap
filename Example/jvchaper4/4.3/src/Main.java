public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D.setX(10);
        point2D.setY(10);
        System.out.println(point2D);
        point2D.setXY(20,20);
        System.out.println(point2D);

        Point3D point3D = new Point3D();
        point3D.setXYZ(5,5,5);
        System.out.println(point3D);
    }
}