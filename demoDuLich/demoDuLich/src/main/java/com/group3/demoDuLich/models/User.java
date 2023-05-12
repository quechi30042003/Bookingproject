package com.group3.demoDuLich.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String email;
    private String phone;
    private String place;
    private int people;
    private String checkin;
    private String checkout;
    private String roomtype;
    private boolean gender;
}
