public class Circle {
    private double radius;

    public Circle(){
        radius = 1.0;
    }
    public Circle(double r){
        radius = r;
    }
    public double getRadius(){
        return radius;
    }
    public double getarea(){
        return Math.PI * radius * radius;
    }
    public void setRadius(double r){

        radius = r ;
    }
    public double getCircumference(){
        return 2 * Math.PI * radius;
    }
    public String toString(){
        return "Circle = "+ radius;
    }
}
