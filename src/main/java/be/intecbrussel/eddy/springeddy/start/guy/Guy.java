package be.intecbrussel.eddy.springeddy.start.guy;



import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity()
public class Guy {
    public Guy() {
    }

    @Id
   @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Guy setName(String name) {
        this.name = name;
        return this;
    }



    public Guy setAge(int age) {
        this.age = age;
        return this;
    }

    public int getAge() {
        return age;
    }
}
