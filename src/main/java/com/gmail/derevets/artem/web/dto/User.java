package com.gmail.derevets.artem.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;


/*@Document(collection = "users")
@Data
@Component*/
public class User {

    @Id
    @Field(value = "id")
    @JsonProperty("id")
    private String id;

    @Indexed(unique = true)
    @Field(value = "email")
    @JsonProperty("email")
    private String email;


    @Field(value = "firstName")
    @JsonProperty("firstName")
    private String firstName;


    @Field(value = "lastName")
    @JsonProperty("lastName")
    private String lastName;



    @Field(value = "password")
    @JsonProperty("password")
    private String password;



    @Field(value = "role")
    @JsonProperty("role")
    private String role;

}
