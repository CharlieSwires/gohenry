package gohenry;

public class Utility {


	public static void copyPersonToParentInfoFields(Person p, ParentInfo ob) {
		ob.setId(p.getId());
		ob.setDateOfBirth(p.getDob());
		ob.setEmailAddress(p.getEmailAddress());
		ob.setFirstName(p.getFirstName());
		ob.setGender(p.getGender());
		ob.setLastName(p.getLastName());
		ob.setSecondName(p.getSecondName());
		ob.setTitle(p.getTitle());
	}

	public static void copyParentInfoToPersonFields(ParentInfo parentsInfo, Person p) {
		p.setId(parentsInfo.getId());
		p.setDob(parentsInfo.getDateOfBirth());
		p.setEmailAddress(parentsInfo.getEmailAddress());
		p.setFirstName(parentsInfo.getFirstName());
		p.setGender(parentsInfo.getGender());
		p.setLastName(parentsInfo.getLastName());
		p.setSecondName(parentsInfo.getSecondName());
		p.setTitle(parentsInfo.getTitle());
	}

	public static void copyChildInfoToPersonFields(ChildInfo childInfo, Person p2) {
		p2.setId(childInfo.getId());
		p2.setDob(childInfo.getDateOfBirth());
		p2.setEmailAddress(childInfo.getEmailAddress());
		p2.setFirstName(childInfo.getFirstName());
		p2.setGender(childInfo.getGender());
		p2.setLastName(childInfo.getLastName());
		p2.setSecondName(childInfo.getSecondName());
		p2.setTitle("");
	}

	public static void copyPersonToChildInfoFields(Person c, ChildInfo ci) {
		ci.setId(c.getId());
		ci.setDateOfBirth(c.getDob());
		ci.setEmailAddress(c.getEmailAddress());
		ci.setFirstName(c.getFirstName());
		ci.setGender(c.getGender());
		ci.setLastName(c.getLastName());
		ci.setSecondName(c.getSecondName());
	}

}
