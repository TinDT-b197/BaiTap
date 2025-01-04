public class MyCircle {
    private MyPoint center;
    private int radius = 1;
    public MyCircle(){
        this.center = new MyPoint();
    }
    public MyCircle(int x, int y){
        this.center = new MyPoint(x, y);
    }
    public MyCircle(MyPoint center, int radius){
        this.center = center;
        this.radius = radius;
    }
    public int getRadius(){
        return this.radius;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public MyPoint getCenter(){
        return this.center;
    }
    public void setCenter(MyPoint center){
        this.center = center;
    }
    public int getCenterX(){
        return this.center.getX();
    }
    public void setCenterX(int x){
        this.center.setX(x);
    }
    public int getCenterY(){
        return this.center.getY();
    }
    public void setCenterY(int y){
        this.center.setY(y);
    }
    int[] result = new int[2];
    public int[] getCenterXY(int x, int y){
        return new int[]{this.center.getX() + x, this.center.getY() + y};
    }
    public void setCenterXY(int x, int y){
        this.center.setX(x);
        this.center.setY(y);
    }
    public String toString(){
        return "MyCircle[radius = "+ radius +", center=("+ this.center.getX() + ", " + this.center.getY() + ")]";
    }
    public double getArea(){
        return Math.PI * Math.pow(this.center.getX(), 2) + Math.pow(this.center.getY(), 2);
    }
    public double getCircumference(){
        return 2 * Math.PI * this.radius;
    }
    public double distance(MyCircle another){
        return this.center.distance(another.center);
    }
}
