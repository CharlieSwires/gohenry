package gohenry;

import java.util.Date;
import java.util.List;

public class ParentInfo {

	private int id;
	private String title;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Date dateOfBirth;
	private String gender;
	private String secondName;
	private List<ChildInfo> children;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dob) {
		this.dateOfBirth = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public List<ChildInfo> getChildren() {
		return children;
	}
	public void setChildren(List<ChildInfo> children) {
		this.children = children;
	}

}
