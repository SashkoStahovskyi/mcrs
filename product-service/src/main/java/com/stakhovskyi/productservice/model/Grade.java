package com.stakhovskyi.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Grade")
public class Grade {

    @Id
    private String id;

    private Double studentId;

    private Double classId;

    private List<Score> scores;


}


