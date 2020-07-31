package didimiaosha.miaosha.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;

    private String phone;

    private String password;

    private static final long serialVersionUID = 1L;


}