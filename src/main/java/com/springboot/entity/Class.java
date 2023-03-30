package com.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.springboot.form.SearchForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-03-29
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Class implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String text;


}
