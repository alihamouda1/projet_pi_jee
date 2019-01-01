package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Disscussions database table.
 * 
 */
@Entity
@Table(name="Disscussions")
@NamedQuery(name="Disscussion.findAll", query="SELECT d FROM Disscussion d")
public class Disscussion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DisscussionId")
	private int disscussionId;

	@Column(name="Receiver")
	private String receiver;

	@Column(name="Sender")
	private String sender;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="patient_Id")
	private AspNetUser aspNetUser2;

	public Disscussion() {
	}

	public int getDisscussionId() {
		return this.disscussionId;
	}

	public void setDisscussionId(int disscussionId) {
		this.disscussionId = disscussionId;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

}