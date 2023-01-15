public final class R3Vector {
    private double x;
    private double y;
    private double z;

    public R3Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public R3Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public void add(R3Vector v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }

    public static R3Vector add(R3Vector v1, R3Vector v2) {
        return new R3Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public void multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }

    public static R3Vector multiply(R3Vector v, double scalar) {
        return new R3Vector(v.x * scalar, v.y * scalar, v.z * scalar);
    }

    public double scalar_multiply(R3Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public static double scalar_multiply(R3Vector v1, R3Vector v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public R3Vector vector_multiply(R3Vector v) {
        return new R3Vector(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);
    }

    public static R3Vector vector_multiply(R3Vector v1, R3Vector v2) {
        return new R3Vector(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public boolean greater(R3Vector v) {
        return this.length() > v.length();
    }

    public static boolean greater(R3Vector v1, R3Vector v2) {
        return v1.length() > v2.length();
    }

    public void print() {
        System.out.println("x: " + this.x + " y: " + this.y + " z: " + this.z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
