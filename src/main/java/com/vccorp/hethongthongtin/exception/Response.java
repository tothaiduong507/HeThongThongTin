package com.vccorp.hethongthongtin.exception;

import com.vccorp.hethongthongtin.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private HttpStatus status;
    private String message;
    private int code;
    private List<UserDto> data;

    public Response(HttpStatus status, String message, int code){
        this.status = status;
        this.message = message;
        this.code = code;
    }

}
