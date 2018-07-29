package gohenry;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class DbHelper {
	private SessionFactory sessionFactory;

    public DbHelper() {
    	this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
	public int save(Person p) {
		System.out.println(p.getId());

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();

		session.close();
		System.out.println(p.getId());
		return p.getId();
	}
	public void save(Child p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public Person list(int id) {

		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Person where id=:id");
		query.setParameter("id", id);
		List<Person> personList = query.list();
		session.close();
		return personList.size() > 0 ? personList.get(0): null;
	}	
	
	@SuppressWarnings("unchecked")
	public Child listChild(int id) {

		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Child where id=:id");
		query.setParameter("id", id);
		List<Child> childList = query.list();
		session.close();
		return childList.size() > 0 ? childList.get(0): null;
	}

	@SuppressWarnings("unchecked")
	public List<Child> getChildren(Integer id) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Child where parentId=:id");
		query.setParameter("id", id);
		List<Child> childList = query.list();
		session.close();
		return childList;

	}

	public Person getPerson(Integer id) {
		return list(id);
	}

	public int savePerson(Person p) {
		return save(p);		
	}

	public void saveChild(Child c) {
		save(c);
	}

	public void delete(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete Person where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		tx.commit();
		session.close();	
	}
	

	public Child getChild(int id) {
		return listChild(id);
	}

	public void deleteChild(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete Child where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		tx.commit();
		session.close();	
		
	}

}
