package com.mingyu.springcloud.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Payment
 * Description:
 * date: 2022/2/1 19:18
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
