package org.geeksforgeeks.digitallibrary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@JsonDeserialize

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", columnDefinition = "varchar(32) NOT NULL")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(32) NOT NULL")
    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_of_birth", columnDefinition = "varchar(32) NOT NULL")
    private LocalDate dateOfBirth;
}
