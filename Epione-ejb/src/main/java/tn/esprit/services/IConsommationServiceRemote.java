package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import model.AspNetUser;
@Remote
public interface IConsommationServiceRemote {

	
	public List<AspNetUser> listPatient();
	
}
