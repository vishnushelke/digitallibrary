package org.geeksforgeeks.digitallibrary.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonDeserialize
@JsonSerialize
public class BookDto {

    private String name;

    private String author;

    private double price;

    private String isbn;
}
