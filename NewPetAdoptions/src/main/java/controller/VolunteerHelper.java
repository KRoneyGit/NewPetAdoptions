package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pet;
import model.Volunteer;

/**
* @author Kevin Roney - karoney
* CIS 175 - Fall 2023
* Feb 28, 2023
*/
public class VolunteerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("NewPetAdoptions");
	
	public void insertNewVolunteer(Volunteer v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Volunteer> getVolunteers(){
		EntityManager em= emfactory.createEntityManager();
		List<Volunteer> allVolunteers = em.createQuery("SELECT d FROM Volunteer d").getResultList();
		return allVolunteers;
	}
	
	public void deleteVolunteer(Volunteer toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Volunteer> typedQuery = em.createQuery("SELECT v FROM Volunteer v where v.id = :selectedId", Volunteer.class);

		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Volunteer result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Volunteer searchForVolunteerById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Volunteer found = em.find(Volunteer.class, tempId);
		em.close();
		return found;
	}

	public void updateVolunteer(Volunteer toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
