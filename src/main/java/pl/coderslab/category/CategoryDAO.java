package pl.coderslab.category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDAO {
    @PersistenceContext
    EntityManager entityManager;

    public void create(Category category){
        entityManager.persist(category);
    }

    public Category findById(Long id){
        return entityManager.find(Category.class, id);
    }

    public List<Category> getAll(){
        return entityManager.createQuery("select c from Category c order by c.id").getResultList();
    }

    public void edit(Category category){
        entityManager.merge(category);
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }
}
