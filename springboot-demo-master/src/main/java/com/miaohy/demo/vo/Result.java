package com.miaohy.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T data;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time =new Date();

    public Result() {

    }
    public static Result ok(Object data) {
        return Result.builder()
                .data(data)
                .time(new Date())
                .build();
    }

}
