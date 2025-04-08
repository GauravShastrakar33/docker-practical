package com.IBM.amazon.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseMessage {

    public String message;
    private boolean success;
    private HttpStatus status;

}
