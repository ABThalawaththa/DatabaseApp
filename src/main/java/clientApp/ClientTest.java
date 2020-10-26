package clientApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.DB.entities.Patient;
import com.DB.entities.Unit;
import com.DB.entities.Ward;

import util.HibernateUtil;

public class ClientTest {
	public static void main(String[] args) {
		final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Patient patient = new Patient();
		patient.setPatient_firstName("kamal");
		patient.setPatient_lastname("perera");
		
		Ward ward = new Ward();
		ward.setWardNumber("01");
		ward.setOccupiedBeds(1);
		ward.setMaxPatientsAllowed(20);
		
		Unit unit = new Unit();
		unit.setUnitName("OPD");
		
		ward.getPatientList().add(patient);
		patient.setWard(ward);
		
		unit.getWardList().add(ward);
		ward.setUnitPatient(unit);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(unit);
		session.getTransaction().commit();
		
		Patient patient2 =session.get(Patient.class,1);
		Ward ward2 = patient2.getWard();
		Unit unit2 = ward2.getUnitPatient();
		
		System.out.println(patient2.getPatient_firstName());
		System.out.println(ward2.getWardNumber());
		System.out.println(unit2.getUnitName());
		
		
	}
	
	
	
}
