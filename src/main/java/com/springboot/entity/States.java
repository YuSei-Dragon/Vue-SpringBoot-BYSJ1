package com.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-04-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class States implements Serializable {

    private static final long serialVersionUID=1L;

    private String username;

    private String classes;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String state;


}
