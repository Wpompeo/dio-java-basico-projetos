package br.com.dio.model;

// ...existing code...

import java.time.LocalDate;
import java.util.Objects;

public class UserModel{
    private long id;
    private String name;
    private String email;
    private LocalDate birthday;

    

    public UserModel(final long id, final String name, final String email, final LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }   

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel userModel)) return false;
        return id == userModel.id && 
               name.equals(userModel.name) && 
               email.equals(userModel.email) && 
               birthday.equals(userModel.birthday);       
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthday);
    }
    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
