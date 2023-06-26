/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * @author User
 */
public class User {

    private int dni;
    private String name;
    private String last_name;
    private String gener;
    private String email;
    private String phone;
    private String ride;
    private String departure;
    private int num;

    public User(int dni, String name, String last_name, String gener, String email, String phone) {
        this.dni = dni;
        this.name = name;
        this.last_name = last_name;
        this.gener = gener;
        this.email = email;
        this.phone = phone;
    }

    public User(String name, String last_name, String gener, String email, String phone) {
        this.name = name;
        this.last_name = last_name;
        this.gener = gener;
        this.email = email;
        this.phone = phone;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRide() {
        return ride;
    }

    public void setRide(String ride) {
        this.ride = ride;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void show() {
        System.out.println(this.name);
        System.out.println(this.last_name);
        System.out.println(this.gener);
        System.out.println(this.email);
        System.out.println(this.phone);

    }

}
