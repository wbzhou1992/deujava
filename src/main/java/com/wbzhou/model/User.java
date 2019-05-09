package com.wbzhou.model;

public class User {
    private String id;
    private String phone;
    private String passwd;
    private Boolean admin;
    private String name;
    private String image;
    private Long createdAt;
    private Long updatedAt;
    private int version;

    public void setId(String id) {
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public int getVersion() {
        return version;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
