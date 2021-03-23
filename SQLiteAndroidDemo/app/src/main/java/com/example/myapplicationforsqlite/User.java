package com.example.myapplicationforsqlite;

public class User
{
    int _id;
    String _username;
    String _password;
    String _phone;
    String _email;
    String _address;
    String _years;

    public User()
    {
    }

    public User(String _username, String _password) {
        this._username = _username;
        this._password = _password;
    }

    public User(int _id, String _username, String _password) {
        this._id = _id;
        this._username = _username;
        this._password = _password;
    }

    public User(String _username, String _password, String _email, String _address, String _phone, String _years) {
        this._username = _username;
        this._password = _password;
        this._email = _email;
        this._address = _address;
        this._phone = _phone;
        this._years = _years;
    }

    public User(int _id, String _username, String _password, String _email, String _address, String _phone, String _years) {
        this._id = _id;
        this._username = _username;
        this._password = _password;
        this._email = _email;
        this._address = _address;
        this._phone = _phone;
        this._years = _years;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_years() {
        return _years;
    }

    public void set_years(String _years) {
        this._years = _years;
    }
}
