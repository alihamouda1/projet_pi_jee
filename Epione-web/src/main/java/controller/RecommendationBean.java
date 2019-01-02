package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Query;

import model.AspNetUser;
import model.Recommendation;
import tn.esprit.services.ConsommationService;
import tn.esprit.services.RecommendationService;

@ManagedBean(name = "recommendationBean")
@ViewScoped
public class RecommendationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int idMed;
	private int idMedRec;
	private int idPatRec;
	private String description;
	private String nameMed;
	private String namePatient;
	private String objet;
	private int testId;
	private int testId1;
	private String Contenu;
	private List<AspNetUser> listAs;
	private Recommendation editRecommentation;
	private List<AspNetUser> asps;
	private List<Recommendation> recommendation;
	private List<Recommendation> recommendation1;
	private List<AspNetUser> listMedecins;
	private List<AspNetUser> listPatients;
	private Recommendation r;

	@EJB
	RecommendationService rs;

	@EJB
	ConsommationService cs;

	@PostConstruct
	public void Init() {
		// listAs =cs.listPatient();
		listMedecins = rs.getMedcin();
		listPatients = rs.getPatient();
		recommendation = rs.getRecommendationById();
		recommendation1 = rs.getRecommendePar();
		System.out.println("thiiiis" + recommendation1);
		System.out.println("FIRST NAME ==>" + listMedecins.get(0).getFirstName());
		System.out.println("FIRST NAME ==>" + listPatients.get(0).getFirstName());

	}

	@Override
	public String toString() {
		return "RecommendationBean [listMedecins=" + listMedecins + ", listPatients=" + listPatients + "]";
	}

	public String editRecommendations() {
		this.r = getEditRecommentation();

		return "editRecommendation.xhtml";
	}

	public String editRecommendation() {

		try {
			rs.editRecommendation(this.r);

			recommendation = rs.getRecommendationById();
			return "listeRecommandee.xhtml?faces-redirect=true";
		} catch (Exception e) {
			return null;
		}

	}

	public void RemoveRecPar(int id) {
		rs.removeRecommendation(id);

	}

	public void RemoveRec(int id) {
		rs.envoyerEmailSupp();
		rs.removeRecommendation(id);

	}

	public void ajoutRecom() {
		System.out.println("id recupere ==>" + testId + " nom recupere ==>" + nameMed);
		String testname = rs.getMedName(testId);
		String testname1 = rs.getMedName(testId1);
		String mailMed = rs.getMail(testId);
		Recommendation r1 = new Recommendation(description, 6, testname, testname1, objet);
		r1.setIdMedRec(testId);
		r1.setIdPatRec(testId1);
		rs.ajouterRecommendation(r1);
		rs.envoyerEmail(mailMed);
	}

	public List<AspNetUser> getAllMedecins() {
		return rs.getMedcin();
	}

	public List<AspNetUser> getAllPatients() {
		return rs.getPatient();
	}

	public List<Recommendation> getRecommendepar(int idMed) {
		recommendation = rs.getRecommendePar();
		return recommendation;
	}

	public List<Recommendation> getRecommendationById() {

		recommendation1 = rs.getRecommendationById();
		return recommendation1;
	}

	
	
	
	
	
	
	
	
	public List<Recommendation> getRecommendation1() {
		return recommendation1;
	}

	public void setRecommendation1(List<Recommendation> recommendation1) {
		this.recommendation1 = recommendation1;
	}
	
		

	public List<AspNetUser> getListMedecins() {
		return listMedecins;
	}

	public void setListMedecins(List<AspNetUser> listMedecins) {
		this.listMedecins = listMedecins;
	}

	public int getIdMed() {
		return idMed;
	}

	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public int getIdMedRec() {
		return idMedRec;
	}

	public void setIdMedRec(int idMedRec) {
		this.idMedRec = idMedRec;
	}

	

	public List<AspNetUser> getAsps() {
		return asps;
	}

	public void setAsps(List<AspNetUser> asps) {
		this.asps = asps;
	}


	public int getIdPatRec() {
		return idPatRec;
	}

	public void setIdPatRec(int idPatRec) {
		this.idPatRec = idPatRec;
	}

	public List<Recommendation> getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(List<Recommendation> recommendation) {
		this.recommendation = recommendation;
	}

	public RecommendationService getRs() {
		return rs;
	}

	public void setRs(RecommendationService rs) {
		this.rs = rs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameMed() {
		return nameMed;
	}

	public void setNameMed(String nameMed) {
		this.nameMed = nameMed;
	}

	public String getNamePatient() {
		return namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public List<AspNetUser> getListPatients() {
		return listPatients;
	}

	public void setListPatients(List<AspNetUser> listPatients) {
		this.listPatients = listPatients;
	}

	public Recommendation getEditRecommentation() {
		return editRecommentation;
	}

	public void setEditRecommentation(Recommendation editRecommentation) {
		this.editRecommentation = editRecommentation;
	}

	public Recommendation getR() {
		return r;
	}

	public void setR(Recommendation r) {
		this.r = r;
	}

	public List<AspNetUser> getListAs() {
		return listAs;
	}

	public void setListAs(List<AspNetUser> listAs) {
		this.listAs = listAs;
	}

	public int getTestId1() {
		return testId1;
	}

	public void setTestId1(int testId1) {
		this.testId1 = testId1;
	}

	public int getTestId() {
		return testId;
	}

	public String getContenu() {
		return Contenu;
	}

	public void setContenu(String contenu) {
		Contenu = contenu;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

}
