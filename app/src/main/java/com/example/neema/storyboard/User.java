package com.example.neema.storyboard;

class User {
    private String username, fullname, email, uid;

    public User(String username, String fullname, String email, String uid){
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getUid() {
        return uid;
    }
}
