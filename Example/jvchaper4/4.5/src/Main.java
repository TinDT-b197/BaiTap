public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(10);
        System.out.println(c);
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());

        Rectangle r = new Rectangle();
        r.setLength(5);
        r.setWidth(10);
        System.out.println(r.getArea());
        System.out.println(r.getPerimeter());
        System.out.println(r);

        Square s = new Square();
        s.setSide(10);
        System.out.println(s.getSide());
        System.out.println(s);
    }
}