package com.watermelon.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualEvaluation{
    @Null
    private Integer individualId;
    @Null
    private Integer roleId;
    @NotNull
    private Integer fromId;
    @NotNull
    private Integer teacherId;
    @NotNull
    private Integer courseId;
    @Min(value=2)
    @Max(value=5)
    private Integer score1;
    @Min(value=2)
    @Max(value=5)
    private Integer score2;
    @Min(value=2)
    @Max(value=5)
    private Integer score3;
    @Min(value=2)
    @Max(value=5)
    private Integer score4;
    @Min(value=2)
    @Max(value=5)
    private Integer score5;
    @Min(value=2)
    @Max(value=5)
    private Integer score6;
    @Null
    private Double totalScore;

    private String advice;

}
