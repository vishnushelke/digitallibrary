package org.geeksforgeeks.digitallibrary.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.geeksforgeeks.digitallibrary.enums.SubscriptionType;

import java.time.LocalDate;

@JsonSerialize
@JsonDeserialize
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class UpdateUserDto {

    private String firstName;
    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    private SubscriptionType subscriptionType;
}
