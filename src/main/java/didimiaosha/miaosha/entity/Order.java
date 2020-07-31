package didimiaosha.miaosha.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {
    private Long id;

    private Long goodId;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    private Date orderTime;

    private Date payTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

}