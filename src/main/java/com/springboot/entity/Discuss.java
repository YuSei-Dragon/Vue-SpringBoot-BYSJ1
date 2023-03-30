package com.springboot.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-03-30
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Discuss implements Serializable {

    private static final long serialVersionUID=1L;

    private String text;

      private String class;

    private String user;


}
