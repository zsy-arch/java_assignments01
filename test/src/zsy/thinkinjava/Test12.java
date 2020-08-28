package zsy.thinkinjava;

public class Test12 {
    public static void main(String[] args) {
        try {
            try {
                throw new Exception("Inner.");
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            System.out.println("Finally.");
        }
        System.out.println("Main stop.");
    }
}
