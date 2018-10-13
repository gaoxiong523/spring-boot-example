package com.gaoxiong.cache.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Proxy;

@Data
@Entity
@Proxy(lazy = false)
@Table(name = "employee")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})//这个地方还有问题没解决,不加这个注解序列化的时候会出错
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

  @Column(name = "d_id")
  private Integer dId;

  public String getLastName () {
    return lastName;
  }

  public void setLastName ( String lastName ) {
    this.lastName = lastName;
  }
}