package org.geeksforgeeks.digitallibrary.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonSerialize
@JsonDeserialize
public class BookIssueDto {

    private long bookId;

    private long userId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate issueDate = LocalDate.now();
}
