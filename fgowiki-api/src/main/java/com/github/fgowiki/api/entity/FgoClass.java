package com.github.fgowiki.api.entity;

import lombok.Data;
import javax.persistence.*;
/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2017/12/22
 */
@Entity
@Data
public class FgoClass {
    @Id
    private Integer id;
    private String name;
    private String nameEn;


}
