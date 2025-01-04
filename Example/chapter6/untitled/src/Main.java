public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(5);
        circle.setColor("red");
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle);
        System.out.println(circle.IsFilled());

        Circle c1 = (Circle)circle;                   // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.IsFilled());
        System.out.println(c1.getRadius());
    }
}