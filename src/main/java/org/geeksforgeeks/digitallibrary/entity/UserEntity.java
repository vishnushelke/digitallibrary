package org.geeksforgeeks.digitallibrary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.geeksforgeeks.digitallibrary.enums.SubscriptionType;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@JsonDeserialize

@Entity
@Table(name = "lib_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name", columnDefinition = "varchar(32) NOT NULL", nullable = false)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(32) NOT NULL", nullable = false)
    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_of_birth", columnDefinition = "varchar(32) NOT NULL", nullable = false)
    private LocalDate dateOfBirth;

    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "subscriptionType", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SubscriptionType subscriptionType = SubscriptionType.NO_SUBSCRIPTION;

    @Column(name = "isActive", nullable = false)
    private boolean active = true;
}
