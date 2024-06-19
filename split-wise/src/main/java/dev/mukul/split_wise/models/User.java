package dev.mukul.split_wise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseModel{
    private String name;
    private String phone;
    private String hashedPassword;

}
