package controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.services.RecommendationService;

@ManagedBean
@ViewScoped
public class RecommendationChartsBean {

	long nb1;
	long nb2;
	long nb3;
	@EJB
	RecommendationService rs;
	
	@PostConstruct
	public void init() {
		nb1 = rs.calcul1();
		nb2 = rs.calcul2();
		nb3 = nb2 - nb1;
	
		

	}
	public RecommendationChartsBean() {
		super();
	}
	public long getNb1() {
		return nb1;
	}
	public void setNb1(long nb1) {
		this.nb1 = nb1;
	}
	public long getNb2() {
		return nb2;
	}
	public void setNb2(long nb2) {
		this.nb2 = nb2;
	}
	
	public long getNb3() {
		return nb3;
	}
	public void setNb3(long nb3) {
		this.nb3 = nb3;
	}
	public RecommendationService getRs() {
		return rs;
	}
	public void setRs(RecommendationService rs) {
		this.rs = rs;
	}
	
}
