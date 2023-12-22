package com.crud.crud.controller

import org.json.JSONArray
import org.json.simple.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

import com.crud.crud.entites.Employee

import io.swagger.annotations.ApiOperation

@Controller
class UsersController {

	@RequestMapping("/")
	def m1() {
		println "success.."

		// Create an outer JSON object
		JSONObject outerObject = new JSONObject();
		// Add a key-value pair to the outer object
		println "Before adding OuterObject "+outerObject
		outerObject.put("userchoice", "Filter");
		outerObject.put("outputtype", "Filter");
		outerObject.put("filtername", "Filter");

		println "After adding OuterObject "+outerObject

		JSONArray innerArray = new JSONArray();
		JSONArray innerArray1 = new JSONArray();
		JSONArray innerArray2 = new JSONArray();
		JSONArray innerArray3 = new JSONArray();
		
		JSONObject innerObject1 = new JSONObject();
		JSONObject innerObject2 = new JSONObject();
		JSONObject innerObject3 = new JSONObject();

		innerObject1.put("filtername", "Filter");
		innerObject1.put("filter_status", "Status");
		println "Step 1 innerObject1 "+innerObject1
		innerObject1.put("tabletitle", "Filter");

		//adding data from innerObject to inner Array
		innerArray.put(innerObject1)		
				
		println "innerArray "+innerArray
		
		//innerArray3.put("value/12")
		
		//innerObject3.put("Mean", innerArray3)
		//innerArray2.put(innerObject3);
		//innerObject2.put("table", innerObject3);
		
		println "innerArray2 "+innerArray2
		innerObject2.put("table", innerArray2);
		println "innerObject2 "+innerObject2

		innerArray.put(innerObject2);
		println "innerArray "+innerArray

		outerObject.put("value", innerArray);
		println "outerObject "+outerObject

		innerArray1.put(innerArray)
		
		
		for(int i=1; i<2; i++) {
			innerArray= [];
			innerArray3 = [];
			innerArray2 = []
			innerObject1 = []
			innerObject1.put("tabletitle", "Derive");
			innerArray.put(innerObject1)
			innerArray3.put("value/12")
			innerObject3.put("Condition", innerArray3)
			innerArray2.put(innerObject3);
			innerObject2.put("table", innerObject3);
			innerObject2.put("table", innerArray2);
			innerArray.put(innerObject2);
			outerObject.put("value", innerArray);
			
			innerArray1.put(innerArray)
			println "innerArray1 "+innerArray1
		}

		outerObject.put("value", innerArray1);
		println "outerObject "+outerObject

		// Convert the outer JSON object to a string
		String jsonString = outerObject.toString();
		println 'converting into json String '+jsonString;

		return "index.html"
	}

	org.slf4j.Logger logger = LoggerFactory.getLogger(UsersController.class);

	//@Autowired
	//private UserService userService;

	@GetMapping("/fetch/{userid}")
	@ApiOperation("Returns Uer based in user id .")
	public Employee getUserById(@PathVariable  String  userid){
		//return userService.getUserById(userid);
		return "";
	}

	@GetMapping("/fetchAll")
	public List<Employee> getAllUsers(){
		//return userService.getAllUsers();
		return "";
	}

	@DeleteMapping("/delete/{userid}")
	public String deleteUserById(@PathVariable  String  userid){
		//return userService.deleteUserById(userid);
		return "";
	}

	@PostMapping("/create")
	public Employee saveUser(@RequestBody  Employee  user){
		//return userService.saveUser(user);
		return "";
	}
}
