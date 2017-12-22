package com.github.fgowiki.api.domain;

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
@Table(name = "FGO_CLASS")
@SuppressWarnings("unused")
public class FgoClass {
    @Id
    private Integer id;
    private String name;
    @Column(name = "NAME_EN")
    private String nameEn;


}
