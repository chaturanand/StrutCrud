package com.digimarket.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.digimarket.listener.HibernateListener;
import com.digimarket.model.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Chaturanand yadav
 * @date 2022-1-04
 */

public class EmployeeAction extends ActionSupport implements ModelDriven<Object> {
	private static final long serialVersionUID = -7234472936649108818L;
	Employee employee = new Employee();
	List<Employee> empList = new ArrayList<>();

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public Object getModel() {
		return employee;
	}

	// add employee in database
	@SuppressWarnings("unchecked")
	public String addEmployee() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		empList = null;
		empList = session.createQuery("from Employee").list();
		return SUCCESS;
	}

	// fetch employees from database
	@SuppressWarnings("unchecked")
	public String fetchEmployee() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext()
				.getAttribute(HibernateListener.KEY_NANE);
		Session session = sessionFactory.openSession();
		empList = session.createQuery("from Employee").list();
		return SUCCESS;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
}
