/*
Team Name: IndusTech
Members: Ratha Ariyanayagam, Saad Qazi, Abhirup Das
 */
package com.humber.industech.industechapp;

/**
 * Created by Saad on 2016-11-14.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "machines")
public class Machines {
    private String mId;
    private String temp;
    private String error;
    private String voltage;

    @DynamoDBHashKey(attributeName = "machineID")
    public String getmId(){
        return mId;
    }

    public void setmId(String id){
        this.mId = id;
    }

    @DynamoDBAttribute(attributeName = "temperature")
    public String getTemp(){
        return temp;
    }

    public void setTemp(String temp){
        this.temp = temp;
    }

    @DynamoDBAttribute(attributeName = "error")
    public String getError(){
        return error;
    }

    public void setError(String err){
        this.error = err;
    }

    @DynamoDBAttribute(attributeName = "voltage")
    public String getVoltage(){
        return voltage;
    }

    public void setVoltage(String voltage){
        this.voltage = voltage;
    }


}
