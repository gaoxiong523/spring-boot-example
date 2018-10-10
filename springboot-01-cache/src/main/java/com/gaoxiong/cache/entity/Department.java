package com.gaoxiong.cache.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", insertable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "department_name")
  private String departmentName;

  
}