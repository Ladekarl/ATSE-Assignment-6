package org.atse.project.fotof;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class RoleEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String id = UUID.randomUUID().toString();

  @Version
  protected long version;

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  protected String role;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }
}