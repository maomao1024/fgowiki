package com.github.fgowiki.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.fgowiki.core.bean.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author jiang
 * @create 2018-03-25 18:07
 **/
@Entity
@Data
public class FgoRole extends BaseEntity {
    @Id
    @JSONField(serialize = false)
    private int id;
    private String role;
    private String name;

}
