package com.github.fgowiki.api.entity;

import com.github.fgowiki.core.bean.BaseEntity;
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
public class FgoClass extends BaseEntity {
    @Id
    private Integer id;
    private String name;
    private String nameEn;


}
