package org.atse.project.fotof;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.identity.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

@Stateless
@Named
public class FotoFBusinessLogic {

  // Inject the entity manager
  @PersistenceContext
  private EntityManager entityManager;

  public void persistRole(DelegateExecution delegateExecution) {
    RoleEntity roleEntity = new RoleEntity();
    IdentityService identityService = delegateExecution.getProcessEngineServices().getIdentityService();
    List<User> userList = identityService.createUserQuery().memberOfGroup("photographer").list();

    Random rand = new Random();
    User user = userList.get(rand.nextInt(userList.size()));

    roleEntity.setRole(user.getId());

    entityManager.persist(roleEntity);
    entityManager.flush();

    delegateExecution.setVariable("role", roleEntity.getRole());
  }

  public void notifyCustomer(DelegateExecution delegateExecution) {

  }

  public void receiveOrder(DelegateExecution delegateExecution) {

  }

  public void add100EU(DelegateExecution delegateExecution) {

  }

  public void add150EU(DelegateExecution delegateExecution) {

  }

  public void deletePhotos(DelegateExecution delegateExecution) {

  }
}