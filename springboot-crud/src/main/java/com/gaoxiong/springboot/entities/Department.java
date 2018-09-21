package com.gaoxiong.springboot.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "department")
public class Department implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  @Column(name = "department_name")
  private String departmentName;

  
}