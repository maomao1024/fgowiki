package com.github.fgowiki.api.entity;

import com.github.fgowiki.core.bean.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author jiang
 * @create 2018-03-26 20:18
 **/
@Entity
@Data
public class SysConfig extends BaseEntity{
    @Id
    private int id;
    private String name;
    private String value;
    private String configDesc;
    private int yxbz;

}
