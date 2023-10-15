package ru.springboot.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name")
    @NotBlank(message = "Field shouldn't empty")
    @Size(min = 1, max =50, message = "Name must have bigger than 0, but no more than 50")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "Field shouldn't empty")
    @Size(min = 1, max = 50, message = "Surname must be bigger than 0, but no more than 50")
    private String surname;
    @Column(name = "age")
    @Min(value = 0, message = ("Age should be bigger than 0"))
    private Byte age;
    @Column(name = "citizenship")
    @NotBlank(message = "Field shouldn't empty")
    @Size(min = 1, max = 50, message = "Surname must be bigger than 0, but no more than 50")
    private String Citizenship;

    public User() {

    }

    public User(String name, String surname, Byte age, String citizenship) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        Citizenship = citizenship;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Byte getAge() {
        return age;
    }

    public String getCitizenship() {
        return Citizenship;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public void setCitizenship(String citizenship) {
        Citizenship = citizenship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(age, user.age) && Objects.equals(Citizenship, user.Citizenship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, surname, age, Citizenship);
    }
}
