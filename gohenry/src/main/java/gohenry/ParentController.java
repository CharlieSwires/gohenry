package gohenry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ParentController {
	@Autowired
	private ParentService parentService;

	//Fetches parents by id
	@GetMapping("/parents/{id}")
	public ResponseEntity<ParentInfo> getParentsById(@PathVariable("id") Integer id) {
		ParentInfo ob = parentService.getParentsById(id);
		return new ResponseEntity<ParentInfo>(ob, HttpStatus.OK);
	}

	//Creates a new parents
	@PostMapping("/parents")
	public ResponseEntity<Void> addParents(@RequestBody ParentInfo parentsInfo, UriComponentsBuilder builder) {
		boolean flag = parentService.createParentsAndChildren(parentsInfo);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/parents/{id}").buildAndExpand(parentsInfo.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//Updates parents
	@PutMapping("/parents/{id}")
	public ResponseEntity<ParentInfo> updateParentsById(@PathVariable("id") Integer id, @RequestBody ParentInfo parentInfo) {
		ParentInfo ob = parentService.updateParentsById(parentInfo, id);
		return new ResponseEntity<ParentInfo>(ob, HttpStatus.OK);
	}

	//Updates children
	@PutMapping("/children/{id}")
	public ResponseEntity<ChildInfo> updateChildrenById(@PathVariable("id") Integer id,@RequestBody ChildInfo childInfo) {
		ChildInfo ob = parentService.updateChildById(childInfo, id);
		return new ResponseEntity<ChildInfo>(ob, HttpStatus.OK);
	}


} 