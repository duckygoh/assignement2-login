package controllers.action;

import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entities.Account;

@Namespace("/account")
public class AccountAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Action(value = "index", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/account/index.jsp") })
	public String index() {
		this.account = new Account();
		return SUCCESS;
	}

	public String login() {

		String ret = ERROR;
		Connection conn = null;

		try {
			String URL = "jdbc:mysql://localhost/accountdb";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "testing123");
			String sql = "SELECT username FROM users WHERE";
			sql += " username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.account.getUsername());
			ps.setString(2, this.account.getPassword());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (this.account.getUsername().equals(rs.getString(1))) {
					ret = SUCCESS;
				}
			}
		} catch (Exception e) {
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		return SUCCESS;
	}

}
