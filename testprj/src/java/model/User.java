/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class User {

//    	[id] [int] IDENTITY(1,1) NOT NULL,
//	[role] [nvarchar](50) NOT NULL,
//	[name] [nvarchar](50) NOT NULL,
//	[email] [nvarchar](50) NOT NULL,
//	[username] [nvarchar](50) NOT NULL,
//	[password] [nvarchar](255) NOT NULL,
//	[avatar] [nvarchar](255) NULL,
    int id;
    String role;
    String name;
    String email;
    String username;
    String password;
    String avatar;

    public User() {
    }

    public User( String role, String name, String email, String username, String password) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(int id, String role, String name, String email, String username, String password, String avatar) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", role=" + role + ", name=" + name + ", email=" + email + ", username=" + username + ", password=" + password + ", avatar=" + avatar + '}';
    }

    
    
}
