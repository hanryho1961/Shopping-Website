package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDetails {
	private int userDetailsId;
	private String userFirstname;
	private String userLastname;
	private Date dateOfBirth;
	private String gender;
	private int userId;
	
	public UserDetails() {
		this.userDetailsId = 0;
		this.userFirstname = "";
		this.userLastname = "";
		this.dateOfBirth = null;
		this.gender = "";
		this.userId = 0;
	}

	public UserDetails(int userDetailsId, String userFirstname, String userLastname, Date dateOfBirth, String gender, int userId) {
		this.userDetailsId = userDetailsId;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.userId = userId;
	}
	
	public UserDetails(ResultSet rs) {
		try {
			this.userDetailsId = rs.getInt("userdetailsid");
			this.userFirstname = rs.getString("userfirstname");
			this.userLastname = rs.getString("userlastname");
			java.sql.Date date = rs.getDate("dateofbirth");
			this.dateOfBirth = new Date(date.getTime());
			this.gender = rs.getString("gender");
			this.userId = rs.getInt("userid");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String result = (dateOfBirth.getMonth() + 1) + "/" + dateOfBirth.getDate() + "/" + df.format(dateOfBirth);
		return result;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetails [userDetailsId=" + userDetailsId + ", userFirstname=" + userFirstname + ", userLastname="
				+ userLastname + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", userId=" + userId + "]";
	}
	
	
}
