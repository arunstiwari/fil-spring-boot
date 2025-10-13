package com.fil.springbasic.employee;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String age;
    private String department;

    protected Employee() {
    }

    public Employee(Long id, String name, String age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("age", age)
                .append("department", department)
                .toString();
    }
}
