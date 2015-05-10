package dao;

import java.util.List;

import play.db.ebean.Model;
import play.db.ebean.Transactional;
import models.Employee;
@Transactional
public class EmployeeDao {
	public static void saveEmployee(Employee employee){
		employee.save();
	}
	public static void updateEmployee(Employee employee){
		employee.update();
	}
	public static Employee  findEmployeeById(Integer id){
		return new Model.Finder<>(Integer.class, Employee.class).byId(id);
	}
	public static List<Employee> findEmployees(){
		return new Model.Finder<>(Integer.class, Employee.class).all();
	}
	
	public static void deleteEmployeeById(Integer id){
		new Model.Finder<>(Integer.class, Employee.class).ref(id).delete();
	}
	
	public static void deleteEmployee(Employee employee){
		employee.delete();
	}
	public static List<Employee> findEmployeeWithAgeGreaterThan(Integer age){
		String query = "from Employee e where e.age > :=age ";
		return new Model.Finder<>(Integer.class, Employee.class).setQuery(query).setParameter("age", age).findList();
	}
}
