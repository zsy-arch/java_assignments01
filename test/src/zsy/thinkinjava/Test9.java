package zsy.thinkinjava;

public class Test9 {
    public static void main(String[] args) {
        try {
            Exception e1 = new Exception();
            Exception e2 = new Exception();
            e2.initCause(e1);
            Exception e3 = new Exception();
            e3.initCause(e2);
            throw e3;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


