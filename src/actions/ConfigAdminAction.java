package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.*;

import dao.ConfigDao;
import dao.UserDao;
import entity.User;

public class ConfigAdminAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	logger.info("ConfigDBAction invoked.");
	
	//reading db configuration
	String name=ActionContext.getParameter("name");
	String password=ActionContext.getParameter("password");
	String mailId=ActionContext.getParameter("mailId");
	User user=new User();
	user.setName(name);
	user.setMailId(mailId);
	user.setPassword(password);
	user.setRole(User.admin);
	UserDao dao=new UserDao();
	dao.save(user);	
	
	return "adminConfigured";
	}

}
