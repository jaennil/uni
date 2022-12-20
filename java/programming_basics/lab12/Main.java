public class Main {
    public static void main(String [] args) {
        System.out.println("add matrix");
        Matrix m_add = new Matrix();
        Matrix m_add2 = new Matrix();
        System.out.println("instance method");
        m_add.add(m_add2);
        m_add.print();
        System.out.println("class method");
        Matrix m_add3 = Matrix.add(m_add, m_add2);
        m_add3.print();

        System.out.println("multiply matrix by number");
        Matrix m_multiplyn = new Matrix();
        System.out.println("instance method");
        m_multiplyn.multiply(3);
        m_multiplyn.print();
        System.out.println("class method");
        Matrix m_multiplyn2 = Matrix.multiply(m_multiplyn, 5);

        Matrix m_multiply = new Matrix();
        Matrix m_multiply2 = new Matrix();
        System.out.println("multiplication matrix by another matrix");
        System.out.println("instance method");
        m_multiply.multiply(m_multiply2);
        m_multiply.print();
        System.out.println("class method");
        Matrix m_multiply3 = Matrix.multiply(m_multiply, m_multiply2);
        m_multiply3.print();



    }

}
