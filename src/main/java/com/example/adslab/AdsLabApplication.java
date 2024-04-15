package com.example.adslab;

import com.example.adslab.model.*;
import com.example.adslab.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdsLabApplication implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DentistRepository dentistRepository;
    @Autowired
    SurgeryRepository surgeryRepository;


    public static void main(String[] args) {
        SpringApplication.run(AdsLabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("application is running ");

        Address fairfield = new Address(null,"Fairfield", "Iowa", "52556");
        Address peoria = new Address(null,"Peoria", "Illinois", "61606");
        Address chicago = new Address(null,"Chicago", "Illinois", "11111");
        Address cedar = new Address(null,"Cedar Rapids", "Iowa", "22222");

        addressRepository.save(fairfield);
        addressRepository.save(peoria);
        addressRepository.save(chicago);
        addressRepository.save(cedar);



        Dentist smith = new Dentist(null, "Tony Smith", null);
        Dentist pearson = new Dentist(null, "Helen Pearson", null);
        Dentist plevin = new Dentist(null, "Robin Plevin", null);

        dentistRepository.save(smith);
        dentistRepository.save(pearson);
        dentistRepository.save(plevin);


        Patient patient1 = new Patient(null,"P100", "Gillian White", "123456", "white@gmail.com",
                fairfield, null);
        Patient patient2 = new Patient(null, "P105","Jill Bell", "234567", "bell@gmail.com",
                peoria, null);
        Patient patient3 = new Patient(null, "P108","Ian MacKey", "345678", "mac@gmail.com",
                cedar, null);
        Patient patient4 = new Patient(null, "P110","John Walker", "456789", "walker@gmail.com",
                chicago, null);



        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);



        Surgery surgery15 = new Surgery(null,"S15", null, fairfield );
        Surgery surgery10 = new Surgery(null,"S10", null, peoria );
        Surgery surgery13 = new Surgery(null,"S13", null, chicago );


        surgeryRepository.save(surgery10);
        surgeryRepository.save(surgery15);
        surgeryRepository.save(surgery13);

        Appointment appointment1 = new Appointment(null, LocalDateTime.of(2013, 9, 12, 10,00), smith,patient1,surgery15);
        Appointment appointment2 = new Appointment(null, LocalDateTime.of(2013, 9, 12, 12,00), smith,patient2,surgery15);
        Appointment appointment3 = new Appointment(null, LocalDateTime.of(2013, 9, 12, 10,00), pearson,patient3,surgery10);
        Appointment appointment4 = new Appointment(null, LocalDateTime.of(2013, 9, 14, 14,00), pearson,patient3,surgery10);
        Appointment appointment5 = new Appointment(null, LocalDateTime.of(2013, 9, 14, 16,30), plevin,patient2,surgery15);
        Appointment appointment6 = new Appointment(null, LocalDateTime.of(2013, 9, 15, 18,00), plevin,patient4,surgery13);

        appointmentRepository.save(appointment1);
        appointmentRepository.save(appointment2);
        appointmentRepository.save(appointment3);
        appointmentRepository.save(appointment4);
        appointmentRepository.save(appointment5);
        appointmentRepository.save(appointment6);

        smith.setAppointments(List.of(appointment1, appointment2));
        pearson.setAppointments(List.of(appointment3, appointment4));
        plevin.setAppointments(List.of(appointment5, appointment6));

        surgery15.setAppointments(List.of(appointment1, appointment2, appointment5));
        surgery10.setAppointments(List.of(appointment3, appointment4));
        surgery13.setAppointments(List.of(appointment6));


        patient1.setAppointments(List.of(appointment1));
        patient2.setAppointments(List.of(appointment2, appointment5));
        patient3.setAppointments(List.of(appointment3, appointment4));
        patient4.setAppointments(List.of(appointment6));

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);

        Patient patient = patientRepository.findById(1).get();
        
    }
}
