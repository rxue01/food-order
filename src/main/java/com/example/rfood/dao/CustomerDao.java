package com.example.rfood.dao;
import com.example.rfood.entity.Authorities;
import com.example.rfood.entity.Customer;
import org.springframework.stereotype.Repository;

// 与数据库交互
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Session: this is the central API class abstracting the notion of a
// persistence service, the main function of the Session is to offer create,
// read and delete operations for instances of mapped entity classes.
// 用session进行entity在data base里增删查改
// session factory 是singleton，thread safe
@Repository

public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null; // session 接口
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();// 确认是否成功

            } catch (Exception ex) {
                ex.printStackTrace();
                session.getTransaction().rollback();// 不成功回到原发状态
            } finally {
                if (session != null) {
                    session.close();// 关闭连接
                }
            }
        }


    public Customer getCustomer(String email) {// dont consider multi-thread imn here so we don't need transaction to keep uniform
        Customer customer = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return customer;
    }



}
