package dev.mukul.split_wise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name="groups")
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> members;

    @ManyToOne
    private User admin;
}
