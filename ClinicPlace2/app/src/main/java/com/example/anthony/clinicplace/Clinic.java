package com.example.anthony.clinicplace;

/**
 * Created by Anthony on 04/11/2017.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
@DynamoDBTable(tableName = "clinicplace-mobilehub-2110396219-Clinica")
public class Clinic {
    private String userId;
    private String Nombre;
    private String Sede;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @DynamoDBRangeKey(attributeName = "Nombre")
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    @DynamoDBAttribute(attributeName = "Sede")
    public String getSede() {
        return Sede;
    }
    public void setSede(String sede) {
        Sede = sede;
    }
}
