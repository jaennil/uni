public final class Vector3 {
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public void add(Vector3 v){
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }

    public static Vector3 add(Vector3 v1, Vector3 v2){
        return new Vector3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public void multiply(double scalar){
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }

    public static Vector3 multiply(Vector3 v, double scalar){
        return new Vector3(v.x * scalar, v.y * scalar, v.z * scalar);
    }

    public double scalar_multiply(Vector3 v){
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public static double scalar_multiply(Vector3 v1, Vector3 v2){
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public Vector3 vector_multiply(Vector3 v){
        return new Vector3(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);
    }

    public static Vector3 vector_multiply(Vector3 v1, Vector3 v2){
        return new Vector3(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }

    public double length(){
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public boolean greater(Vector3 v){
        return this.length() > v.length();
    }

    public static boolean greater(Vector3 v1, Vector3 v2){
        return v1.length() > v2.length();
    }

    public void print() {
        System.out.println("x: " + this.x + " y: " + this.y + " z: " + this.z);
    }
}
