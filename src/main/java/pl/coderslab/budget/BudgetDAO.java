package pl.coderslab.budget;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BudgetDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void create(Budget budget){
        entityManager.persist(budget);
    }

    public Budget findById(Long id){
        return entityManager.find(Budget.class, id);
    }

    public List<Budget> getAll(){
        return entityManager.createQuery("select b from Budget b order by b.id").getResultList();
    }

    public void edit (Budget budget){
        entityManager.merge(budget);
    }

    public void delete (Budget budget){
        entityManager.remove(entityManager.contains(budget) ? budget : entityManager.merge(budget));
    }
}
