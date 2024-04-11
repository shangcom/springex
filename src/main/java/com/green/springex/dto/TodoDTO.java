package com.green.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;

    private String title;

    @Future
    private LocalDate dueDate;

    private boolean finished;

    private String writer;

}
