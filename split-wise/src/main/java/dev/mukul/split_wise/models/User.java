package dev.mukul.split_wise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String phone;
    private String hashedPassword;

}
