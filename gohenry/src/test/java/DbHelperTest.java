

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gohenry.Child;
import gohenry.DbHelper;
import gohenry.ParentService;
import gohenry.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DbHelperTest {

	@Autowired
	private DbHelper db;
	
	@Test
	public void savePerson() {
		//save person
		Assert.assertTrue(db!=null);
		Person porig = null;
		try {
			porig = db.getPerson(100);
			//clean person
			db.delete(100);
		} catch (NullPointerException e) {
			
		}
		
		Person p = new Person();
		p.setId(100);
		p.setDob(new Date());
		p.setEmailAddress("jane.doe@gohenry.com");
		p.setFirstName("Jane");
		p.setGender("Female");
		p.setLastName("Doe");
		p.setSecondName("Ann");
		p.setTitle("Mrs");
		
		Assert.assertTrue("Id not same",100==db.savePerson(p));
		Person p2 = db.getPerson(p.getId());
		
		//clean person
		db.delete(100);
		//restore person
		if(porig != null)
			Assert.assertTrue("Id not same",100==db.savePerson(porig));
		
		Assert.assertTrue("Id not equal",p2.getId()==p.getId());
		//Assert.assertTrue("Dob not equal",p2.getDob().getTime()==p.getDob().getTime());
		Assert.assertTrue("Email not equal",p2.getEmailAddress().equals(p.getEmailAddress()));
		Assert.assertTrue("FirstName not equal",p2.getFirstName().equals(p.getFirstName()));
		Assert.assertTrue("Gender not equal",p2.getGender().equals(p.getGender()));
		Assert.assertTrue("LastName not equal",p2.getLastName().equals(p.getLastName()));
		Assert.assertTrue("SecondName not equal",p2.getSecondName().equals(p.getSecondName()));
		Assert.assertTrue("Title not equal",p2.getTitle().equals(p.getTitle()));

	}
	@Test
	public void saveChild() {
		//save Child
		Assert.assertTrue(db!=null);
		Child corig = null;
		Person porig = null;
		try {
			corig = db.getChild(100);
			//clean Child
			db.deleteChild(100);
			porig = db.getPerson(100);
			//clean Person
			db.delete(100);
		} catch (NullPointerException e) {
			
		}
		Person p1 = new Person();
		p1.setId(100);
		p1.setDob(new Date());
		p1.setEmailAddress("jane.doe@gohenry.com");
		p1.setFirstName("Jane");
		p1.setGender("Female");
		p1.setLastName("Doe");
		p1.setSecondName("Ann");
		p1.setTitle("Mrs");
		
		Assert.assertTrue("Id not same",100==db.savePerson(p1));
		
		Child p = new Child();
		p.setId(100);
		p.setParentId(100);
		p.setPersonId(100);
		
		db.saveChild(p);
		Child p2 = db.getChild(p.getId());
		
		//clean Child
		db.deleteChild(100);		
		//clean person
		db.delete(100);
		//restore Child
		if(corig != null)
			db.saveChild(corig);
		//restore Person
		if(porig != null)
			db.savePerson(porig);
		
		Assert.assertTrue("Id not equal",p2.getId()==p.getId());
		//Assert.assertTrue("Dob not equal",p2.getDob().getTime()==p.getDob().getTime());
		Assert.assertTrue("ParentId not equal",p2.getParentId()==p.getParentId());
		Assert.assertTrue("PersonId not equal",p2.getPersonId()==p.getPersonId());
	}

}
