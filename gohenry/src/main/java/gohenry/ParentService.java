package gohenry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {
	@Autowired
	public DbHelper db;

	public ParentInfo getParentsById(Integer id) {
		ParentInfo ob = new ParentInfo();
		//get the parent
		Person p = db.getPerson(id);
		//copy fields
		Utility.copyPersonToParentInfoFields(p,ob);
		//get the children
		List<Child> children = db.getChildren(id);
		List<ChildInfo> lci = new ArrayList<ChildInfo>();
		//copy fields
		for(Child child: children) {
			ChildInfo ci = new ChildInfo();
			Person c = db.getPerson(child.getPersonId());
			Utility.copyPersonToChildInfoFields(c,ci);
			lci.add(ci);	
		}
		ob.setChildren(lci);
		return ob;
	}

	public boolean createParentsAndChildren(ParentInfo parentsInfo) {
		try {
			//copy parent
			Person p = new Person();
			Utility.copyParentInfoToPersonFields(parentsInfo, p);
			//save person
			parentsInfo.setId(db.savePerson(p));
			//copy children
			List<ChildInfo> children = parentsInfo.getChildren();
			for(ChildInfo childInfo : children) {
				//create person
				Person p2 = new Person();
				//copy child info accross
				Utility.copyChildInfoToPersonFields(childInfo, p2);
				//save person to db
				childInfo.setId(db.savePerson(p2));
				//create Child
				Child c = new Child();
				//Child link to parent and to person
				c.setId(childInfo.getId());
				c.setParentId(p.getId());
				c.setPersonId(p2.getId());
				//save Child
				db.saveChild(c);
			}
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public ParentInfo updateParentsById(ParentInfo parentInfo, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChildInfo updateChildById(ChildInfo childInfo, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int i) {
		db.delete(i);
		
	}

	public void deleteChild(int i) {
		db.deleteChild(i);
		
	}

}
