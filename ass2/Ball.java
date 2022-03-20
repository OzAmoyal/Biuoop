import biuoop.DrawSurface;

public class Ball {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity vel;
    private Point startBound;
    private Point endBound;
    public Ball(Point center, int r, java.awt.Color color) {
    this.center = center;
    this.radius = r;
    this.color = color;
    }
    public Ball(int x, int y, int r, java.awt.Color color) {
    this.center = new Point(x, y);
    this.radius = r;
    this.color = color;
    }
    public Ball(double x, double y, int r, java.awt.Color color) {
    this.center = new Point(x, y);
    this.radius = r;
    this.color = color;
    }
    // accessors
    public int getX() {
        return (int) Math.round(this.center.getX());
    }
    public int getY() {
        return (int) Math.round(this.center.getY());
    }
    public int getSize() {
        return (int) Math.round(Math.PI * this.radius * this.radius);
    }
    public java.awt.Color getColor() {
        return this.color;
    }

    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }
    public void setVelocity(Velocity v) {
    this.vel = v;
    }
    public void setVelocity(double dx, double dy) {
        this.vel = new Velocity(dx, dy);
    }
    public Velocity getVelocity() {
        return vel;
    }
    public void setBounds(Point start, Point end) {
        this.startBound = start;
        this.endBound = end;
    }
    public void setBounds(double x1, double y1, double x2, double y2) {
        this.startBound = new Point(x1, y1);
        this.endBound = new Point(x2, y2);
    }

    public void moveOneStep() {
    this.center = this.getVelocity().applyToPoint(this.center);
    if (this.center.getX() + this.radius >= endBound.getX() || this.center.getX() <= startBound.getX() + this.radius) {
    setVelocity(-(this.vel.getDx()), this.vel.getDy());
    }
    if (this.center.getY() + this.radius >= endBound.getY() || this.center.getY() <= startBound.getY() + this.radius) {
    setVelocity(this.vel.getDx(), -(this.vel.getDy()));
    }
}
}
