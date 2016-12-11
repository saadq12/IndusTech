package com.humber.industech.industechapp;

/**
 * Created by Saad on 2016-12-10.
 */

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "data")
public class Data {
    private String dataid;
    private String data;

    @DynamoDBHashKey(attributeName = "dataid")
    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }

    @DynamoDBIndexHashKey(attributeName = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
