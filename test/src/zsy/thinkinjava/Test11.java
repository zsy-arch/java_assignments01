package zsy.thinkinjava;

import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.http.HttpConnectTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {

    }
}

abstract class Inning {
    public abstract int test() throws IOException;

    public abstract int test2();
}

interface Storm {
    int test() throws IOException;
}

class InningStorm extends Inning implements Storm {
    @Override
    public int test() {
        return 0;
    }

    @Override
    public int test2() {
        return 0;
    }
}


