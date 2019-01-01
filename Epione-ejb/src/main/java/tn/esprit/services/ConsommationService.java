package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import model.AspNetUser;
@Stateful
@LocalBean
public class ConsommationService implements IConsommationServiceRemote{
	@PersistenceContext(unitName="Epione-ejb")
	EntityManager em;

	@Override
	public List<AspNetUser> listPatient() {
		
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:51403/User/CreateJJ");
		Response response=target.request().get();
		List res=response.readEntity(List.class);
		return res;
	}
	private List listMedecin;
	
	public List<AspNetUser> getListMedecin() {
		listMedecin = new ArrayList<AspNetUser>();
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:51403/User/CreateJ");
		Response response=target.request().get();
		String res=response.readEntity(String.class);
		System.out.println("AAAAAAAAAAAAAAAAAAAA show me " + res);
		res = res.replace("[", "");
		res = res.replace("]", "");
		ArrayList<String> listStr = new ArrayList<>();
		
		for (String string : res.split(",,")) {
			System.out.println("first string" + string.length());
			string = string.replace("{", "").replace("}", "");
			String[] test = string.split(":");
			for (String str : test){
				if(str.contains("FirstNa")||str.contains("Id")){
					
				}else{
					listStr.add(str.replace("\"", "").replace(" ",""));
				}
			}
		}
		for(int i=0;i<(listStr.size());i=i+3){
			AspNetUser Med = new AspNetUser();
			Med.setFirstName(listStr.get(i)+ " " + listStr.get(i+2));
			System.out.println("aaaaaa" + listStr.get(i+1));
			Med.setId(Integer.parseInt(listStr.get(i+1)));	
			System.out.println("nameeeee "+ listStr.get(i+2));
			Med.setUserName(listStr.get(i+2));
			listMedecin.add(Med);
		}
		return listMedecin;

	}
	

}
