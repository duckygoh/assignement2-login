package controllers.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entities.Account;

@Namespace("/account")
public class AccountAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String errorMessage = "";
	private Account account;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Action(value = "index", results = {
		@Result(name = SUCCESS, location = "/WEB-INF/views/account/index.jsp")
	})
	public String index() {
		this.account = new Account();
		return SUCCESS;
	}

	@Action(value = "login", results = {
		@Result(name = SUCCESS, location = "/WEB-INF/views/account/welcome.jsp"),
		@Result(name = ERROR, location = "/WEB-INF/views/account/index.jsp")
	})
	public String login() {
		if (this.account.getUsername().equalsIgnoreCase("testing123") && this.account.getPassword().equalsIgnoreCase("testing")) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("username", this.account.getUsername());
			return SUCCESS;
		} else {
			this.errorMessage = "Invalid Account";
			return ERROR;
		}
	}

	@Action(value = "logout", results = {
		@Result(name = SUCCESS, type = "redirectAction", params = { "namespace", "/account", "actionName", "index" })
	})
	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		return SUCCESS;
	}

}