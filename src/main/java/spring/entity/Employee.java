package spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="employee")
public class Employee {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="salary")
    private float salary;

    @Column(name="email")
    private String email;

    @Column(name="adress")
    private String adress;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = {CascadeType.PERSIST})
    private List<toDO> todo;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee()
    {
        this.todo=new ArrayList<>();
    }

    public List<toDO> getTodo() {
        return todo;
    }

    public void setTodo(List<toDO> todo) {
        this.todo = todo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
