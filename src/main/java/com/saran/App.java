package com.saran;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
      StandardServiceRegistry ssr=new 
    		  StandardServiceRegistryBuilder().configure().build();
      Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
      SessionFactory sf=meta.getSessionFactoryBuilder().build();
      Session session=sf.openSession();
      Transaction t1=session.beginTransaction();
      Employee e1=new Employee(1,"Geeta",12345);
      Employee e2=new Employee(2,"Pradhan",12345);
      Employee e3=new Employee(3,"Olu Funke",12345);
   //   session.save(e1);session.save(e2);session.save(e3);
   //  t1.commit();
      System.out.println("Employee records inserted");
      System.out.println("________________________________");
      Employee er=session.load(Employee.class, new Integer(2));
      System.out.println(er.getEmpName());
      System.out.println(er.getEmpSal());
      System.out.println("________________________________");
      Session session2=sf.openSession();
      Employee er2=session2.load(Employee.class, new Integer(2));
      System.out.println(er2.getEmpName());
      System.out.println(er2.getEmpSal());
      System.out.println("________________________________");      
      
      session.close(); sf.close();
      
    }
}
