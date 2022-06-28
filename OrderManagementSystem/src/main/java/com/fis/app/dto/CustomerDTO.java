package com.fis.app.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CustomerDTO {

    private Long id;

    @NotNull
    @Size(min=10, max=100)
    private String name;

    @NotNull
    @Pattern(regexp="^0[0-9]{1,10}")
    private String mobile;

    @NotNull
    @Size(min=10, max=100)
    private String address;

}
