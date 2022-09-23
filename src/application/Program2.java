package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: seller findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== Test 2: seller findByAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller insert ===");
		Department newDep = new Department(null, "Foods");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep);
		
		System.out.println("\n=== Test 4: seller update ===");
		department = departmentDao.findById(1);
		department.setName("Administration");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n=== Test 5: seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
