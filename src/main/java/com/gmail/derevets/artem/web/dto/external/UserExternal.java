package com.gmail.derevets.artem.web.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.gmail.derevets.artem.web.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserExternal {


    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private Role role;

    private Boolean isAccountNonLocked;

    private Boolean isAccountNonExpired;

    private Boolean isCredentialsNonLocked;

    private Boolean isEnabled;

    private Long verificationCode;

    private LocalDateTime creationTime;

    private LocalDateTime modificationTime;

    private long version;
}
