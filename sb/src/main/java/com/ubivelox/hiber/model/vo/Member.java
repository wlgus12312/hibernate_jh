package com.ubivelox.hiber.model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MEMBER")
public class Member implements Serializable
{

    /**
    *
    */
    private static final long serialVersionUID = 6106056069152242170L;
    @Id
    @Column(name = "mno",
            unique = true,
            nullable = false)
    private Long              mno;
    @Column(name = "name",
            unique = false,
            nullable = false)
    private String            name;
    @Column(name = "job",
            unique = false,
            nullable = false)
    private String            job;
    @Column(name = "phone",
            unique = false,
            nullable = false)
    private String            phone;





    public Member()
    {
    }





    public Member(final Long mno, final String name, final String job, final String phone)
    {
        super();
        this.mno = mno;
        this.name = name;
        this.job = job;
        this.phone = phone;
    }

}
