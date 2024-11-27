package edu.upc.eetac.dsa.db.orm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class users {
    String Name;
    String Password;
    String Correu;
    double Money;
    double Cobre;

    public users() {
    }

    public users(String name, String password, String correu, double money, double cobre) {
        Name = name;
        Password = password;
        Correu = correu;
        Money = money;
        Cobre = cobre;
    }

    public users(String name, String password, String correu) {
        Name = name;
        Password = password;
        Correu = correu;
    }

    public double getCobre() {
        return Cobre;
    }

    public void setCobre(double cobre) {
        Cobre = cobre;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public String getCorreu() {
        return Correu;
    }

    public void setCorreu(String correu) {
        Correu = correu;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
