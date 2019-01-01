package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import model.AspNetUser;
import model.Recommendation;


@Remote
public interface RecommendationServiceRemote {
	public int ajouterRecommendation(Recommendation r);
	public List<AspNetUser> getMedcin();
	public List<AspNetUser> getPatient();
	public  List<Recommendation> getRecommendationById();
	public  List<Recommendation> getRecommendePar();
	public void removeRecommendation(int id);
	public void envoyerEmail(String mail);
	public void envoyerEmailSupp();
	public void envoyerEmailModif();
	public long calcul1();
	public long calcul2();
	public String getMail(int id);
	 public Recommendation editRecommendation(Recommendation r) throws Exception;

}
