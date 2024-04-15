package com.example.adslab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patientNo;
    private String name;
    private String phone;
    private String email;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}
