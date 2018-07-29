

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gohenry.ChildInfo;
import gohenry.DbHelper;
import gohenry.ParentInfo;
import gohenry.ParentService;
import gohenry.Person;
import gohenry.Utility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ParentServiceTest {
	@Autowired
	private ParentService ps;

	@Test
	public void createParentsAndChildrenTest() {
		ParentInfo parentsInfo = ps.getParentsById(1);
//		for (int i = 1; i < 150; i++) {
//			try {
//				ps.deleteChild(i);
//			}catch(Exception e) {
//				
//			}
//		}
//		for (int i = 1; i < 150; i++) {
//			try {
//				ps.delete(i);
//			}catch(Exception e) {
//				
//			}
//		}
//		System.exit(1);
		ps.deleteChild(3);
		ps.deleteChild(2);
		ps.delete(3);
		ps.delete(2);
		ps.delete(1);
		ps.createParentsAndChildren(parentsInfo);
		ParentInfo parentsInfo2=ps.getParentsById(1);
		//copy parent
		Person p = new Person();
		Utility.copyParentInfoToPersonFields(parentsInfo, p);
		//save person
		Assert.assertTrue("Id not equal",parentsInfo.getId()==p.getId());
		Assert.assertTrue("Dob not equal",parentsInfo.getDateOfBirth().getTime()==p.getDob().getTime());
		Assert.assertTrue("Email not equal",parentsInfo.getEmailAddress().equals(p.getEmailAddress()));
		Assert.assertTrue("FirstName not equal",parentsInfo.getFirstName().equals(p.getFirstName()));
		Assert.assertTrue("Gender not equal",parentsInfo.getGender().equals(p.getGender()));
		Assert.assertTrue("LastName not equal",parentsInfo.getLastName().equals(p.getLastName()));
		Assert.assertTrue("SecondName not equal",parentsInfo.getSecondName().equals(p.getSecondName()));
		Assert.assertTrue("Title not equal",parentsInfo.getTitle().equals(p.getTitle()));
		//copy children
		List<ChildInfo> children = parentsInfo.getChildren();
		for(ChildInfo childInfo : children) {
			//create person
			Person p2 = new Person();
			//copy child info accross
			Utility.copyChildInfoToPersonFields(childInfo, p2);
			Assert.assertTrue("Id not equal",childInfo.getId()==p2.getId());
			Assert.assertTrue("Dob not equal",childInfo.getDateOfBirth().getTime()==p2.getDob().getTime());
			Assert.assertTrue("Email not equal",childInfo.getEmailAddress().equals(p2.getEmailAddress()));
			Assert.assertTrue("FirstName not equal",childInfo.getFirstName().equals(p2.getFirstName()));
			Assert.assertTrue("Gender not equal",childInfo.getGender().equals(p2.getGender()));
			Assert.assertTrue("LastName not equal",childInfo.getLastName().equals(p2.getLastName()));
			Assert.assertTrue("SecondName not equal",childInfo.getSecondName().equals(p2.getSecondName()));
			Assert.assertTrue("Title not equal","".equals(p2.getTitle()));
		}

	}

}
