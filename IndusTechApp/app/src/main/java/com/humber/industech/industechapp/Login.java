package com.humber.industech.industechapp;

/**
 * Created by Saad on 2016-11-13.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "logincreds")
public class Login {
    private String id;
    private String username;
    private String password;
    private Boolean hardCover;
    //private String haskey;

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id= Id;
    }

    @DynamoDBIndexHashKey(attributeName = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    @DynamoDBAttribute(attributeName = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= password;
    }
/*
    @DynamoDBHashKey(attributeName = "haskey")
    public String getHaskey() {
        return haskey;
    }

    public void setHaskey(String haskey) {
        this.haskey = haskey;
    }


    @DynamoDBHashKey(attributeName = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @DynamoDBAttribute(attributeName = "Hardcover")
    public Boolean getHardCover() {
        return hardCover;
    }

    public void setHardCover(Boolean hardCover) {
        this.hardCover = hardCover;
    }

    */



}


