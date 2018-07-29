package gohenry;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Child")
public class Child {
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="parent_id")
	private int parentId;
	@Column(name="person_id")
	private int personId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}

}
