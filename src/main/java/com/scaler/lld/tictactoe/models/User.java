package com.scaler.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// FlyWeight Design Pattern : Intrinsic state - which wil not change
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private String photo;
}
