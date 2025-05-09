package br.com.simba.model.entities;
import br.com.simba.model.dao.UserDAO;
import br.com.simba.model.valueobject.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private Username username;
    private String name;
    private Address address;
    private Email email;
    private Password password;
    private List<Record> records = new ArrayList<>();

    public User(int id, String username, String name, String street, int number , String neighborhood, String city, String stateAbbr, String email, String password) {
        this.id = id;
        this.username = new Username(username);
        this.name = name;
        this.address = new Address(street, number, neighborhood, city, stateAbbr);
        this.email = new Email(email);
        this.password = new Password(password);
        this.records = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }
    public Username getUsername() {
        return username;
    }
    public void setUsername(Username username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Email getEmail() {
        return email;
    }
    public void setEmail(Email email) {
        this.email = email;
    }
    public String getPassword() {
        return password.getHash();
    }
    public void setPassword(String password) {
        this.password = new Password(password);
    }
    public void addRecord(Record record) {
        this.records.add(record);
    }
    public void removeRecord(Record record) {
        this.records.remove(record);
    }

    // ToDo

    public void login(String username, String password) {

    }
    public void logout() {

    }

    public void changePassword(String password) {
        if (!validatePassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }
        this.password = new Password(password);
    }

    private Boolean validatePassword(String password) {

        return true;
    }

    public int getId(){
        UserDAO userDAO = new UserDAO();
        return userDAO.getId(this.username.toString());
    }

    public void updateProfile(String username, String name, String street, int number , String neighborhood, String city, String stateAbbr, String email, String phone, String password) {
        this.username = new Username(username);
        this.name = name;
        this.address = new Address(street, number, neighborhood, city, stateAbbr);
        this.email = new Email(email);
        this.password = new Password(password);
        this.records = new ArrayList<>();
    }
    public List<Record> listRecords(){
        return records;
    }
}