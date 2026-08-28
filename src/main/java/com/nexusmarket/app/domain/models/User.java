package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.UserRole;
import com.nexusmarket.app.domain.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String fullName;
    private String email;
    private UserRole role;
    private UserStatus status;
}
