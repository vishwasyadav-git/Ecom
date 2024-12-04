package com.userservice.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonDeserialize(as = Role.class)
public class Role extends BaseModel{
    private String role;
}
