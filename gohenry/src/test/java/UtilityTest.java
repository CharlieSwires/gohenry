import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import gohenry.ChildInfo;
import gohenry.ParentInfo;
import gohenry.Person;
import gohenry.Utility;

public class UtilityTest {


	@Test
	public void test1() {
		Person p = new Person();
		ParentInfo ob = new ParentInfo();
		p.setId(1);
		p.setDob(new Date());
		p.setEmailAddress("jane.doe@gohenry.com");
		p.setFirstName("Jane");
		p.setGender("Female");
		p.setLastName("Doe");
		p.setSecondName("Ann");
		p.setTitle("Mrs");

		Utility.copyPersonToParentInfoFields(p, ob);

		Assert.assertTrue("Id not equal",ob.getId()==p.getId());
		Assert.assertTrue("Dob not equal",ob.getDateOfBirth().getTime()==p.getDob().getTime());
		Assert.assertTrue("Email not equal",ob.getEmailAddress().equals(p.getEmailAddress()));
		Assert.assertTrue("FirstName not equal",ob.getFirstName().equals(p.getFirstName()));
		Assert.assertTrue("Gender not equal",ob.getGender().equals(p.getGender()));
		Assert.assertTrue("LastName not equal",ob.getLastName().equals(p.getLastName()));
		Assert.assertTrue("SecondName not equal",ob.getSecondName().equals(p.getSecondName()));
		Assert.assertTrue("Title not equal",ob.getTitle().equals(p.getTitle()));
	}

	@Test
	public void test2() {
		Person p = new Person();
		ParentInfo parentsInfo = new ParentInfo();
		parentsInfo.setId(1);
		parentsInfo.setDateOfBirth(new Date());
		parentsInfo.setEmailAddress("jane.doe@gohenry.com");
		parentsInfo.setFirstName("Jane");
		parentsInfo.setGender("Female");
		parentsInfo.setLastName("Doe");
		parentsInfo.setSecondName("Ann");
		parentsInfo.setTitle("Mrs");

		Utility.copyParentInfoToPersonFields(parentsInfo, p);

		Assert.assertTrue("Id not equal",parentsInfo.getId()==p.getId());
		Assert.assertTrue("Dob not equal",parentsInfo.getDateOfBirth().getTime()==p.getDob().getTime());
		Assert.assertTrue("Email not equal",parentsInfo.getEmailAddress().equals(p.getEmailAddress()));
		Assert.assertTrue("FirstName not equal",parentsInfo.getFirstName().equals(p.getFirstName()));
		Assert.assertTrue("Gender not equal",parentsInfo.getGender().equals(p.getGender()));
		Assert.assertTrue("LastName not equal",parentsInfo.getLastName().equals(p.getLastName()));
		Assert.assertTrue("SecondName not equal",parentsInfo.getSecondName().equals(p.getSecondName()));
		Assert.assertTrue("Title not equal",parentsInfo.getTitle().equals(p.getTitle()));
	}

	@Test
	public void test3() {
		Person p = new Person();
		ChildInfo childInfo = new ChildInfo();
		childInfo.setId(1);
		childInfo.setDateOfBirth(new Date());
		childInfo.setEmailAddress("jane.doe@gohenry.com");
		childInfo.setFirstName("Jane");
		childInfo.setGender("Female");
		childInfo.setLastName("Doe");
		childInfo.setSecondName("Ann");
		
		Utility.copyChildInfoToPersonFields(childInfo, p);
		
		Assert.assertTrue("Id not equal",childInfo.getId()==p.getId());
		Assert.assertTrue("Dob not equal",childInfo.getDateOfBirth().getTime()==p.getDob().getTime());
		Assert.assertTrue("Email not equal",childInfo.getEmailAddress().equals(p.getEmailAddress()));
		Assert.assertTrue("FirstName not equal",childInfo.getFirstName().equals(p.getFirstName()));
		Assert.assertTrue("Gender not equal",childInfo.getGender().equals(p.getGender()));
		Assert.assertTrue("LastName not equal",childInfo.getLastName().equals(p.getLastName()));
		Assert.assertTrue("SecondName not equal",childInfo.getSecondName().equals(p.getSecondName()));
		Assert.assertTrue("Title not equal","".equals(p.getTitle()));
	}
	
		@Test
		public void test4() {
			Person p = new Person();
			ChildInfo childInfo = new ChildInfo();
			p.setId(1);
			p.setDob(new Date());
			p.setEmailAddress("jane.doe@gohenry.com");
			p.setFirstName("Jane");
			p.setGender("Female");
			p.setLastName("Doe");
			p.setSecondName("Ann");
			p.setTitle("Mrs");
			
			Utility.copyPersonToChildInfoFields(p, childInfo);
			
			Assert.assertTrue("Id not equal",childInfo.getId()==p.getId());
			Assert.assertTrue("Dob not equal",childInfo.getDateOfBirth().getTime()==p.getDob().getTime());
			Assert.assertTrue("Email not equal",childInfo.getEmailAddress().equals(p.getEmailAddress()));
			Assert.assertTrue("FirstName not equal",childInfo.getFirstName().equals(p.getFirstName()));
			Assert.assertTrue("Gender not equal",childInfo.getGender().equals(p.getGender()));
			Assert.assertTrue("LastName not equal",childInfo.getLastName().equals(p.getLastName()));
			Assert.assertTrue("SecondName not equal",childInfo.getSecondName().equals(p.getSecondName()));

		}

}
