package controllers;

import java.util.List;

import models.Employee;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;

import dao.EmployeeDao;

public class EmmployeeController extends Controller {
	public static Result saveEmployee() {
		return ok(saveEmployee.render());
	}

	public static Result saveEmployeePost() {
		Employee employee = Form.form(Employee.class).bindFromRequest().get();
		EmployeeDao.saveEmployee(employee);
		return redirect(routes.EmmployeeController.fetchEmployeeList());
	}

	public static Result updateEmployee(int id) {
		Employee emp = EmployeeDao.findEmployeeById(id);
		return ok(updateEmployee.render(emp));
	}

	public static Result updateEmployeePost() {
		Employee employee = Form.form(Employee.class).bindFromRequest().get();
		EmployeeDao.updateEmployee(employee);
		return redirect(routes.EmmployeeController.fetchEmployeeList());
	}

	public static Result fetchEmployeeList() {
		List<Employee> employees = EmployeeDao.findEmployees();
		return ok(employeeList.render(employees));
	}

	public static Result deleteEmployee(int id) {
		EmployeeDao.deleteEmployeeById(id);
		return redirect(routes.EmmployeeController.fetchEmployeeList());
	}

	public static Result jsonSaveEmployee() {
		JsonNode json = request().body().asJson();
		Employee emp = Json.fromJson(json, Employee.class);
		EmployeeDao.saveEmployee(emp);
		return ok(Json.toJson(emp));
	}

	public static Result jsonFetchEmployeeList() {

		return ok(Json.toJson(EmployeeDao.findEmployees()));
	}

}
