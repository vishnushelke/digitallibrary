package org.geeksforgeeks.digitallibrary.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@JsonSerialize
@JsonDeserialize
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
public class UserDto {

    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
}
