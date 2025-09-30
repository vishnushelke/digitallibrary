package org.geeksforgeeks.digitallibrary.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
@JsonDeserialize

@AllArgsConstructor
@NoArgsConstructor
public class SaveInRedisCacheDto {
    private String key;
    private String value;
}
