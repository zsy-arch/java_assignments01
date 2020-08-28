package zsy.thinkinjava;

public class Test10 {

    public static void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    public static void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            try {
            } finally {
                f();
                dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception!";
    }
}
