package zsy.thinkinjava;

public class Test19 {
    public static void main(String[] args) {
        Base19 base19 = new Derive19();
        base19.say("Hello");
        base19.say("Hello");
        base19.say("Hello");
        base19.say("Hello");
    }
}

class Base19 {
    private int i = 0;

    public void say(String s) {
        System.out.println("Base19: " + s + " " + (i++));
    }
}

class Derive19 extends Base19 {
}