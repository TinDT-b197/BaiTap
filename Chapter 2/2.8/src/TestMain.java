public class TestMain{
    public static void main(String[] args){
        MyCircle c1 = new MyCircle();
        c1.setRadius(10);
        c1.setCenterXY(5,6);
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getCircumference());

    }
}