package com.mingyu.springcloud.dao;

import com.mingyu.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName: PaymentDao
 * Description:
 * date: 2022/2/1 19:27
 *
 * @author yimingyu
 * @version 1.0
 * @since JDK 1.8
 */
@Mapper
public interface PaymentDao {
    @Insert("insert into payment(serial) values (#{serial})")
    int create(Payment payment);

    @Select("select * from payment where id = #{id}")
    Payment getPaymentById(@Param("id") Long id);
}
