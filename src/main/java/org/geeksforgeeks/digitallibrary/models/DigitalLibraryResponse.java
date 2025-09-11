package org.geeksforgeeks.digitallibrary.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@JsonSerialize
@JsonDeserialize

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DigitalLibraryResponse<T> {
    private String status;
    private T data;
    private String errorMessage;
}
