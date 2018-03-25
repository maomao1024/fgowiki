package com.github.fgowiki.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.fgowiki.core.bean.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * @author jiang
 * @create 2018-03-25 18:02
 **/
@Entity
@Data
public class FgoUser extends BaseEntity {
    @Id
    private int uid;
    private String username;
    @JSONField(serialize=false)
    private String password;
    private String head;
    private Timestamp loginTime;
    @JSONField(serialize=false)
    private String loginIp;
    @JoinTable(name = "fgo_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<FgoRole> roles;
}
