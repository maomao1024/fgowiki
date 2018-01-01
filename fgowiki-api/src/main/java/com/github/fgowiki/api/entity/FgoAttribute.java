package com.github.fgowiki.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2017/12/22
 */
@Data
@Entity
public class FgoAttribute {
    @Id
    private String id;
    private String name;
}
