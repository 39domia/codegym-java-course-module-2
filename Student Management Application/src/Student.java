import java.io.Serializable;
import java.util.ArrayList;

class Student implements Comparable<Student>, Serializable  {
    private static final long serialVersionUID = 1L;
    private static int autoId;
    private int id;
    private String name;
    private ArrayList<ArrayList<Double>> points = new ArrayList<>();
    private ArrayList<Double> pointFactor1 = new ArrayList<>();
    private ArrayList<Double> pointFactor2 = new ArrayList<>();
    private ArrayList<Double> pointFactor3 = new ArrayList<>();

    private double averagePoint;

    private void initPointFactor1() {
        points.add(pointFactor1);
        double point1 = 0;
        double point2 = 0;
        pointFactor1.add(point1);
        pointFactor1.add(point2);
    }

    private void initPointFactor2() {
        points.add(pointFactor2);
        double point1 = 0;
        pointFactor2.add(point1);
    }

    public static void setAutoId(int autoId) {
        Student.autoId = autoId;
    }

    private void initPointFactor3() {
        points.add(pointFactor3);
        double point1 = 0;
        pointFactor3.add(point1);
    }

    public ArrayList<ArrayList<Double>> getPoints() {
        return points;
    }

    public ArrayList<Double> getPointFactor1() {
        return pointFactor1;
    }

    public ArrayList<Double> getPointFactor2() {
        return pointFactor2;
    }

    public ArrayList<Double> getPointFactor3() {
        return pointFactor3;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint() {
        double totalPointFactor1 = 0;
        double totalPointFactor2 = 0;
        double totalPointFactor3 = 0;
        for (Double aDouble : pointFactor1) {
            totalPointFactor1 += aDouble;
        }
        for (Double aDouble : pointFactor2) {
            totalPointFactor2 += aDouble * 2;
        }
        for (Double aDouble : pointFactor3) {
            totalPointFactor3 += aDouble * 3;
        }
        double totalNumberOfPoints = pointFactor1.size() + (pointFactor2.size() * 2) + (pointFactor3.size() * 3);
        averagePoint = (totalPointFactor1 + totalPointFactor2 + totalPointFactor3) / totalNumberOfPoints;
    }

    public Student(String name) {
        this.id = ++autoId;
        this.name = name;
        initPointFactor1();
        initPointFactor2();
        initPointFactor3();
    }

    public static int getAutoId() {
        return autoId;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", points=" + points +
                ", pointFactor1=" + pointFactor1 +
                ", pointFactor2=" + pointFactor2 +
                ", pointFactor3=" + pointFactor3 +
                ", averagePoint=" + averagePoint +
                "}\n";
    }

    @Override
    public int compareTo(Student o) {
        if (o.getAveragePoint() > this.getAveragePoint()) {
            return 1;
        } else if (o.getAveragePoint() == this.getAveragePoint()) {
            return 0;
        } else {
            return -1;
        }
    }
}

