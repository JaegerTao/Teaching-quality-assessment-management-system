package com.watermelon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualEvaluation{

    private Integer individualId;

    private Integer roleId;

    private Integer fromId;

    private Integer teacherId;

    private Integer courseId;

    private Integer score1;

    private Integer score2;

    private Integer score3;

    private Integer score4;

    private Integer score5;

    private Integer score6;

    private Double totalScore;

    private String advice;

}
