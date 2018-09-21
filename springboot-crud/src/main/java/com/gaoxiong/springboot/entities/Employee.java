package com.gaoxiong.springboot.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "gender")
  private Integer gender;

  @Column(name = "birth")
  private Date birth;

  
}