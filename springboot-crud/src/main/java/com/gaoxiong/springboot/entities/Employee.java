package com.gaoxiong.springboot.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", insertable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "gender")
  private Integer gender;

  @Column(name = "birth")
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date birth;

  
}