package zsy.thinkinjava;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Random;

public class Test14 {
    public static void main(String[] args) {
//        System.out.println((new Cat("C") instanceof Individual));
        Integer integer = 10;
        System.out.println((new Dog("")).getClass().isInstance(new Pet("")));
        System.out.println((new Dog("")).getClass().isAssignableFrom((new Pet("").getClass())));
        System.out.println((new Pet("")).getClass().isInstance(new Dog("")));
        System.out.println((new Pet("")).getClass().isAssignableFrom((new Dog("").getClass())));
        System.out.println();
    }
}

class Individual {
    private String name;

    public Individual(String name) {
        this.name = name;
    }
}

class Person extends Individual {
    private String name;

    public Person(String name) {
        super(name);
        this.name = name;
    }
}

class Pet extends Individual {
    private String name;

    public Pet(String name) {
        super(name);
        this.name = name;
    }
}

class Dog extends Pet {
    private String name;

    public Dog(String name) {
        super(name);
        this.name = name;
    }
}

class Cat extends Pet {
    private String name;

    public Cat(String name) {
        super(name);
        this.name = name;
    }
}

abstract class PetCreator {
    private Random random = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        List<Class<? extends Pet>> list = types();
        try {
            return list.get(random.nextInt(types().size())).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}