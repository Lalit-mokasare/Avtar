package com.lrmd.agriculturestore.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseMessage {


       private  String message;


       private  Boolean success;

       private HttpStatus status;












}
