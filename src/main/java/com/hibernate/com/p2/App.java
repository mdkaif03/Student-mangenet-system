package com.hibernate.com.p2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {

    
        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("dhananjay");
        employee.setCompany("Tcs");
        employee.setCity("cg");
        employee.setAge(2);
        employee.setSalary(60000);
        employee.setGender("Male");

  
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(ssr).addAnnotatedClass(Employee.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(employee);

         
            transaction.commit();
            System.out.println("Employee saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
