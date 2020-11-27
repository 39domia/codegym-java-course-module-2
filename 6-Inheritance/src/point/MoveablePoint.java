package point;

public class MoveablePoint extends Point{
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }
    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        return new float[]{getXSpeed(), getYSpeed()};
    }

    @Override
    public String toString() {
        return " MoveablePoint{" +
                super.toString()+
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public MoveablePoint move(){
        setX(getX() + getXSpeed());
        setY(getY() + getYSpeed());
        return this;
    }

}
