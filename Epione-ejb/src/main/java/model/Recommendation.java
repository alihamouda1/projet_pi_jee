package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Recommendations database table.
 * 
 */
@Entity
@Table(name="Recommendations")
@NamedQuery(name="Recommendation.findAll", query="SELECT r FROM Recommendation r")
public class Recommendation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Column(name="id_med")
	private int idMed;

	@Column(name="id_med_rec")
	private int idMedRec;

	@Column(name="id_pat_rec")
	private int idPatRec;

	@Column(name="name_med")
	private String nameMed;

	@Column(name="name_patient")
	private String namePatient;

	private String objet;

	public Recommendation() {
	}
	

	public Recommendation(String description, int idMed, String nameMed, String namePatient, String objet) {
		super();
		this.description = description;
		this.idMed = idMed;
		this.nameMed = nameMed;
		this.namePatient = namePatient;
		this.objet = objet;
	}


	public Recommendation(String description, int idMed, int idMedRec, int idPatRec, String nameMed, String namePatient,
			String objet) {
		super();
		this.description = description;
		this.idMed = idMed;
		this.idMedRec = idMedRec;
		this.idPatRec = idPatRec;
		this.nameMed = nameMed;
		this.namePatient = namePatient;
		this.objet = objet;
	}


	public Recommendation(int id, String description, int idMed, int idMedRec, int idPatRec, String nameMed,
			String namePatient, String objet) {
		super();
		this.id = id;
		this.description = description;
		this.idMed = idMed;
		this.idMedRec = idMedRec;
		this.idPatRec = idPatRec;
		this.nameMed = nameMed;
		this.namePatient = namePatient;
		this.objet = objet;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdMed() {
		return this.idMed;
	}

	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}

	public int getIdMedRec() {
		return this.idMedRec;
	}

	public void setIdMedRec(int idMedRec) {
		this.idMedRec = idMedRec;
	}

	public int getIdPatRec() {
		return this.idPatRec;
	}

	public void setIdPatRec(int idPatRec) {
		this.idPatRec = idPatRec;
	}

	public String getNameMed() {
		return this.nameMed;
	}

	public void setNameMed(String nameMed) {
		this.nameMed = nameMed;
	}

	public String getNamePatient() {
		return this.namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public String getObjet() {
		return this.objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

}