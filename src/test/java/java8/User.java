package java8;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    int age;
    int weight;
    String name;
    String speciality;
    boolean isSex;

    public User(int age, int weight, String name, String speciality, boolean isSex) {
        this.age = age;
        this.weight = weight;
        this.name = name;
        this.speciality = speciality;
        this.isSex = isSex;
    }

    @Override
    public String toString(){
        String sex;
        if(isSex)  sex = "male";else sex = "female";
        return "You are " + age + ", your weight is " + weight + "kg, your parents named you " + name
                + ", you work everyday as " + speciality + ", nature made you a " + sex +
                ". I KNOW EVERYTHING ABOUT YOU 0_0, " + name;
    }
}
