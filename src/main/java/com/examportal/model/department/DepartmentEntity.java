package com.examportal.model.department;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
@Data
public class DepartmentEntity extends AbstractAuditable {

    @Id
    private String id;
    private String courseLabel;
}
