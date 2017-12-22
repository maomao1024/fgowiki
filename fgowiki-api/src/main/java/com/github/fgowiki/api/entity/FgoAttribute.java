package com.github.fgowiki.api.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * 功能描述：
 *
 * @author 蒋经
 * @version 1.0
 * @since 2017/12/22
 */
@Data
@SuppressWarnings("unused")
public class FgoAttribute {
    private String id;
    private String name;
}
