package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class User {
    private  String name;


    private List<String> roles;


}
