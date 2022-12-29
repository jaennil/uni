public class Main {
        public static void main(String[] args){
            R3Vector v1 = new R3Vector(1,2,3);
            R3Vector v2 = new R3Vector(4,5,6);
            v1.add(v2);
            System.out.println("vector 2 add to vector 1:");
            v1.print();
            R3Vector v3 = R3Vector.add(v1,v2);
            System.out.println("vector 1 add to vector 2 and write to vector 3:");
            v3.print();
            v1.multiply(3);
            System.out.println("vector 1 multiply by 3:");
            v1.print();
            R3Vector v4 = R3Vector.multiply(v1, 2);
            System.out.println("vector 1 multiply by 2 and write to vector 4:");
            v4.print();
            System.out.println("v1 scalar multiplied by v2 " + v1.scalar_multiply(v2));
            System.out.println("v1 scalar multiplied by v2 static " + R3Vector.scalar_multiply(v1,v2));
            R3Vector v6 = v1.vector_multiply(v2);
            System.out.println("v1 vector multiplied by v2 and write to vector 6:");
            v6.print();
            R3Vector v7 = R3Vector.vector_multiply(v1,v2);
            System.out.println("v1 vector multiplied by v2 and write to vector 7 static:");
            v7.print();
            System.out.println("v1:");
            v1.print();
            System.out.println("vector1 length: " + v1.length());
            System.out.println("v2:");
            v2.print();
            System.out.println("vector2 length: " + v2.length());
            System.out.println("v1 > v2? " + v1.greater(v2));
            System.out.println("v1 > v2?static " + R3Vector.greater(v1,v2));
        }
}