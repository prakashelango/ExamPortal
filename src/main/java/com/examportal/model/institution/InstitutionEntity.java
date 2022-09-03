package com.examportal.model.institution;

import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "institution")
@Data
public class InstitutionEntity {
    @Id
    private String id;
    private String institutionName;
    private String institutionAddress;
}
