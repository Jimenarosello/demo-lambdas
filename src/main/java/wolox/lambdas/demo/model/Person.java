package wolox.lambdas.demo.model;

import java.util.List;

public class Person {

    private String name;
    private int age;
    private double money;
    private String currency;
    private List<Hobby> hobbies;

    public Person(String name, int age, List<Hobby> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.money = 0D;
    }

    public Person(String name, int age, double money, String currency, List<Hobby> hobbies) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.currency = currency;
        this.hobbies = hobbies;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}
