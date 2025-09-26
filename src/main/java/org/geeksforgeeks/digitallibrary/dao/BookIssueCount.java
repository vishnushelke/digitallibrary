package org.geeksforgeeks.digitallibrary.dao;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.geeksforgeeks.digitallibrary.entity.BookEntity;


@JsonSerialize
@JsonDeserialize

public record BookIssueCount(BookEntity entity, long issueCount){}
