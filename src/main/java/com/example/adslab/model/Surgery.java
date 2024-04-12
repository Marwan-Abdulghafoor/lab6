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
public class Surgery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surgeryNo;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
    @OneToOne
    private Address address;
}
