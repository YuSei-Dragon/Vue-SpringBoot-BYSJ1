package com.springboot.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-03-20
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class SysAdmin implements Serializable {

    private static final long serialVersionUID=1L;

      private String sysName;

    private String sysPassword;

  @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


}
