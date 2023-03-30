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
 * @since 2023-03-20
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class SysAdmin implements Serializable {

    private static final long serialVersionUID=1L;

      private String sysName;

    private String sysPassword;

    private Integer id;


}
