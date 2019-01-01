package tn.esprit.services;

import java.util.List;
import java.util.Properties;
import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.AspNetUser;
import model.Recommendation;

/**
 * Session Bean implementation class RecommendationService
 */
@Stateful
@LocalBean
public class RecommendationService implements RecommendationServiceRemote {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public RecommendationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int ajouterRecommendation(Recommendation r) {
		// TODO Auto-generated method stub
		em.persist(r);
		System.out.println("nom:" + r.getNameMed());
		return r.getId();
	}

	@Override
	public List<AspNetUser> getMedcin() {
		// TODO Auto-generated method stub

		String Medecin = "Medecin";

		TypedQuery<AspNetUser> query = em.createQuery("Select u from AspNetUser u " + "where u.role=:Medecin",
				AspNetUser.class);
		query.setParameter("Medecin", Medecin);
		System.out.println(query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<AspNetUser> getPatient() {
		// TODO Auto-generated method stub
		String Patient = "Patient";

		TypedQuery<AspNetUser> query = em.createQuery("Select u from AspNetUser u " + "where u.role=:Patient",
				AspNetUser.class);
		query.setParameter("Patient", Patient);
		System.out.println(query.getResultList().size());
		return query.getResultList();
	}

	public String getMedName(int id) {

		Query query = em.createQuery("Select u.firstName from AspNetUser u " + "where u.id=:id");
		query.setParameter("id", id);
		return query.getSingleResult().toString();
	}

	public String getMedPatient(int id) {

		Query query = em.createQuery("Select u.firstName from AspNetUser u " + "where u.id=:id");
		query.setParameter("id", id);
		return query.getSingleResult().toString();
	}
	
	public String getMail(int id) {

		Query query = em.createQuery("Select u.email from AspNetUser u " + "where u.id=:id");
		query.setParameter("id", id);
		return query.getSingleResult().toString();
	}

	@Override
	public List<Recommendation> getRecommendationById() {
		Query query = em.createQuery("Select u from Recommendation u " + "where u.idMed=:id");
		query.setParameter("id", 6);
		return query.getResultList();

	}

	@Override
	public List<Recommendation> getRecommendePar() {
		Query query = em.createQuery("Select u from Recommendation u " + "where u.idMedRec=:id");
		query.setParameter("id", 6);
		return query.getResultList();
	}

	@Override
	public void removeRecommendation(int id) {
		// TODO Auto-generated method stub
		System.out.println("In removeUser : ");
		em.remove(em.find(Recommendation.class, id));
		System.out.println("out removeUser : ");
		
	}

	@Override
	public void envoyerEmail(String mail) {
		// TODO Auto-generated method stub
try {
			
			String from = "ali.hamouda@esprit.tn";
			String pass = "salutali"; 
			String to = mail;
			String subject = "Recommendation";
			String messageText = "Vous etiez recommendés pour un nouveau patient. Veeuillez consulter votre liste des recommendations";

			String host = "smtp.gmail.com";

			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");

			props.put("mail.smtp.host", host);

			props.put("mail.smtp.port", "587");

			props.put("mail.smtp.auth", "true");

			props.put("mail.smtp.starttls.required", "true");

			Session mailSession = Session.getDefaultInstance(props, null);

			mailSession.setDebug(sessionDebug);

			Message msg = new MimeMessage(mailSession);

			msg.setFrom(new InternetAddress(from));

			InternetAddress[] address = { new InternetAddress(to) };

			msg.setRecipients(Message.RecipientType.TO, address);

			msg.setSubject(subject);
			msg.setSentDate(new Date());

			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");

			transport.connect(host, from, pass);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			System.out.println("message send successfully");

		} catch (Exception ex)

		{
			System.out.println(ex);

		}
		
	}

	@Override
	public void envoyerEmailSupp() {
		// TODO Auto-generated method stub
try {
			
			String from = "ali.hamouda@esprit.tn";
			String pass = "salutali"; 
			String to ="ali.hamouda@esprit.tn";
			String subject = "Recommendation";
			String messageText = "Une de vos Recommendation a été annulée";

			String host = "smtp.gmail.com";

			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");

			props.put("mail.smtp.host", host);

			props.put("mail.smtp.port", "587");

			props.put("mail.smtp.auth", "true");

			props.put("mail.smtp.starttls.required", "true");

			Session mailSession = Session.getDefaultInstance(props, null);

			mailSession.setDebug(sessionDebug);

			Message msg = new MimeMessage(mailSession);

			msg.setFrom(new InternetAddress(from));

			InternetAddress[] address = { new InternetAddress(to) };

			msg.setRecipients(Message.RecipientType.TO, address);

			msg.setSubject(subject);
			msg.setSentDate(new Date());

			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");

			transport.connect(host, from, pass);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			System.out.println("message send successfully");

		} catch (Exception ex)

		{
			System.out.println(ex);

		}
		
		
		
	}

	@Override
	public void envoyerEmailModif() {
		// TODO Auto-generated method stub
try {
			
			String from = "ali.hamouda@esprit.tn";
			String pass = "salutali"; 
			String to ="ali.hamouda@esprit.tn";
			String subject = "Recommendation";
			String messageText = "messsagee";

			String host = "smtp.gmail.com";

			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");

			props.put("mail.smtp.host", host);

			props.put("mail.smtp.port", "587");

			props.put("mail.smtp.auth", "true");

			props.put("mail.smtp.starttls.required", "true");

			Session mailSession = Session.getDefaultInstance(props, null);

			mailSession.setDebug(sessionDebug);

			Message msg = new MimeMessage(mailSession);

			msg.setFrom(new InternetAddress(from));

			InternetAddress[] address = { new InternetAddress(to) };

			msg.setRecipients(Message.RecipientType.TO, address);

			msg.setSubject(subject);
			msg.setSentDate(new Date());

			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");

			transport.connect(host, from, pass);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			System.out.println("message send successfully");

		} catch (Exception ex)

		{
			System.out.println(ex);

		}
		
		
	}

	@Override
	public long calcul1() {
		String sql = "SELECT COUNT(r) FROM Recommendation r WHERE r.idMedRec=6";
		Query q = em.createQuery(sql);
		long count = (long) q.getSingleResult();

		return count;
	}

	@Override
	public long calcul2() {
		String sql = "SELECT COUNT(r) FROM Recommendation r";
		Query q = em.createQuery(sql);
		long count = (long) q.getSingleResult();

		return count;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Recommendation editRecommendation(Recommendation r) throws Exception {
        try {
            System.out.println("User hereko " + r);
            em.merge(r);
            em.flush();
            return r;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }

}
