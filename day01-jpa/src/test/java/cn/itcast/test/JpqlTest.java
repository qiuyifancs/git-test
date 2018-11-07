package cn.itcast.test;

import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * 测试jpql
 */
public class JpqlTest {

    /**
     * 测试查询所有
     *      sql:select * from cst_customer
     *     jpql:from (全限定类名)Customer
     *
     * 一般流程：
     *      1.创建query查询对象
     *      2.对参数进行赋值
     *      3.查询并得到返回结果
     */
    @Test
    public void testFindAll(){
        //1.创建EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询所有
        String jpql="from Customer";
        Query query = em.createQuery(jpql);
        List list = query.getResultList();
        for (Object customer : list) {
            System.out.println(customer);
        }
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 排序查询：根据id倒序查询
     *      sql:select * from cst_customer order by cust_id desc
     *     jpql:from Customer order by custId desc
     */
    @Test
    public void testOrder(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql="from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        for (Object customer : resultList) {
            System.out.println(customer);
        }
        transaction.commit();
        entityManager.close();
    }

    /**
     * 统计查询：查询客户总数
     *      sql:select count(cust_id) from cst_customer
     *     jpql:select count(custId) from Customer
     */
    @Test
    public void testCount(){
        //1.创建EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.统计查询
        String jpql="select count(custId) from Customer";
        Query query = em.createQuery(jpql);
        Object count = query.getSingleResult();
        System.out.println(count);
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 分页查询
     */
    @Test
    public void testPage(){
        //1.创建EntityManager对象
        EntityManager em = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //3.查询所有
        //i.获取query对象
        String jpql="from Customer";
        Query query = em.createQuery(jpql);
        //ii.参数赋值
        query.setFirstResult(0);
        query.setMaxResults(2);
        //iii.查询并得到返回结果
        List list = query.getResultList();
        for (Object customer : list) {
            System.out.println(customer);
        }
        //4.提交事务
        tx.commit();
        //5.释放资源
        em.close();
    }

    /**
     * 条件查询：查询名称以传智开头的客户
     *      sql:select * from cst_customer where cust_name like '传智%'
     *     jpql:from Customer where custName like ?
     */
    @Test
    public void testCondition(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql="from Customer where custName like ?";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1,"传智%");
        List list = query.getResultList();
        for (Object customer : list) {
            System.out.println(customer);
        }
        transaction.commit();
        entityManager.close();
    }

}
