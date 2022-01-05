package pl.coderslab.transaction;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransactionsDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void create(Transaction transaction) {
        entityManager.persist(transaction);
    }

    public Transaction findById(Long id) {
        return entityManager.find(Transaction.class, id);
    }

    public void edit(Transaction transaction) {
        entityManager.merge(transaction);
    }

    public void delete(Transaction transaction) {
        entityManager.remove(entityManager.contains(transaction) ? transaction : entityManager.merge(transaction));
    }

    public List<Transaction> getAll(){
       return entityManager.createQuery("select t from Transaction t order by t.id").getResultList();
    }
}
