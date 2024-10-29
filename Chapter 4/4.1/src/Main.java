public class Main {
    public static void main(String[] args){
        Cylinder c1 = new Cylinder(2, 10, "black");
        System.out.println("Cylinder:"
                + " radius=" + c1.getRadius()
                + " height=" + c1.getHeight()
                + " area=" + c1.getArea()
                + " volume=" + c1.getVolume());
        System.out.println(c1);

    }
}