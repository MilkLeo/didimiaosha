package didimiaosha.miaosha.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Goods implements Serializable {
    private Long id;

    private String name;

    private Integer number;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Date startTime;

    private Date endTime;

    private static final long serialVersionUID = 1L;


}