public class TestConstructor {
    public static void main(String[] args) {
        Point p1 = new Point(3.0, 4.0);
        Point p2 = new Point(0.0, 0.0);
        System.out.println(p1.getDistence(p2));
    }

}

class Point{
    double x, y, z;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    // 在一个构造器中调用另一个构造器
    Point(double x, double y, double z){
        this(x,y); // 此时this指代上一个构造器，且需位于方法第一行
        this.z = z;
    }

    public Double getDistence(Point p){
        return Math.sqrt((x-p.x) * (x-p.x) + (y-p.y)*(y-p.y));
    }
}
