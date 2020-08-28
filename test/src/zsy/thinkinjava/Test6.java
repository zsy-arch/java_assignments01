package zsy.thinkinjava;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        Customer customer1 = new Customer("ZhangSan", 10);
        Customer customer2 = new Customer("LiSi", 10);
        Customer customer3 = new Customer("WangWu", 8);
        Customer customer4 = new Customer("ZhaoLiu", 5);
        system.addCustomer(customer1);
        system.addCustomer(customer2);
        system.addCustomer(customer3);
        system.addCustomer(customer4);
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            system.addCustomer(new Customer("C-" + i, random.nextInt(300)));
        }
        system.printCustomers();
    }
}

class Customer {
    private String name;
    private int index;

    public Customer(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

class TicketSystem {
    private LinkedList<Customer> customers = new LinkedList<>();

    public TicketSystem() {
    }

    public void addCustomer(Customer customer) {
        customers.add(getNumber(customer), customer);
    }

    private int getNumber(Customer customer) {
        if (customers.size() == 0) return 0;
        for (Customer customer1 : customers) {
            if (customer.getIndex() > customer1.getIndex()) {
                return customers.indexOf(customer1);
            }
        }

        return customers.size();
    }

    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getName() + " : " + customer.getIndex());
        }
    }
}