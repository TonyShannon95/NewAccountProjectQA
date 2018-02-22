package com.qa.intergration;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Param;

import com.qa.domain.Account;
import com.qa.service.repository.AccountDBRepository;
import com.qa.util.JSONUtil;

@Path("/account")
public class AccountEndpoint 
{
	@Inject
	private AccountDBRepository accRep;
	private JSONUtil util;
	
	@GET
	@Path("/json")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String getAllAccounts()
	{
		return accRep.getAllAccounts();
		
	}
	
	@GET
	@Path("/json-find/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Account findAccount(
	@PathParam("id") long id)
	{
		Account account = accRep.findAccount(id);
		
		return account;
	}
	
	
	@Path("/json-create")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String createAccount(String account)
	{
		
		String anAccount = accRep.createAccount(account);
		
		return anAccount;
	}
	
	@Path("/json-delete/{id}")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String deleteAccount(
			@PathParam("id") long id)
	{
		
		return accRep.deleteAccount(id);
		
	}
	
	@Path("/json-update/{id}")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String updateAccount(
			@PathParam("id") long id,String accountToUpdate)
	{
		return accRep.updateAccount(id, accountToUpdate);
		
	}
	
}
