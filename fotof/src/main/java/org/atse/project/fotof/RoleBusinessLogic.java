package org.atse.project.fotof;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.identity.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Stateless
@Named
public class RoleBusinessLogic {

  // Inject the entity manager
  @PersistenceContext
  private EntityManager entityManager;

  public void persistRole(DelegateExecution delegateExecution) {
    RoleEntity roleEntity = new RoleEntity();
    List<User> userList = delegateExecution.getProcessEngineServices().getIdentityService().createUserQuery().memberOfGroup("photographer").list();
    Random rand = new Random();
    User user = userList.get(rand.nextInt(userList.size()));
    Map<String, Object> variables = delegateExecution.getVariables();
    roleEntity.setRole(user.getId());
    entityManager.persist(roleEntity);
    entityManager.flush();
    variables.put("role", user.getId());
    delegateExecution.setVariable("role", roleEntity.getRole());
  }

}