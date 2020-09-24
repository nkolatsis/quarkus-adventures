package org.nick;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Task extends PanacheEntity {

  public String name;
  public Boolean done;
  
  public static List<Task> findByName(String name) {
    return find("name", name).list();
  }
}
