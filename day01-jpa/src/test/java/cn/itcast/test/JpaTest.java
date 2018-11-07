package cn.itcast.test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    /**
     * 测试保存
     * jpa操作步骤：
     *      1.加载配置文件创建工厂（实体管理器工厂）对象
     *      2.通过实体管理器工厂获取实体管理器
     *      3.获取事务对象，开启事务
     *      4.完成增删改查操作
     *      5.提交事务/回滚事务
     *      6.释放资源
     */
    @Test
    public void testSave(){
        //1.加载配置文件创建工厂（实体管理器工厂）对象
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过实体管理器工厂获取实体管理器
        EntityManager entityManager = factory.createEntityManager();
        //3.获取事务对象，开启事务
        EntityTransaction tx = entityManager.getTransaction();//获取事务对象
        tx.begin();//开启事务
        //4.完成增删改查操作：保存一个客户到数据库中
        Customer customer=new Customer();
        customer.setCustName("传智播客");
        customer.setCustIndustry("教育");
        entityManager.persist(customer);//保存操作
        //5.提交事务/回滚事务
        tx.commit();
        //6.释放资源
        entityManager.close();
        factory.close();
    }

    /**
     * 测试工具类
     */
    @Test
    public void testJpaUtils(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Customer customer=new Customer();
        customer.setCustName("传智播客");
        customer.setCustIndustry("教育");
        entityManager.persist(customer);
        tx.commit();
        entityManager.close();
    }

    /**
     * 根据id查询客户
     */
    @Test
    public void testFind(){
        //1.创建实体类管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.增删改查:根据id查询客户
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();
    }

    /**
     * 根据id查询客户
     */
    @Test
    public void testGetReference(){
        //1.创建实体类管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.增删改查:根据id查询客户
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();
    }

    /**
     * 删除客户
     */
    @Test
    public void testRemove(){
        //1.创建实体类管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.增删改查:删除客户
        Customer customer=entityManager.find(Customer.class,1L);
//        Customer customer=new Customer();
//        customer.setCustId(1L);
//        customer.setCustName("传智播客");
//        customer.setCustIndustry("教育");
        entityManager.remove(customer);
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();
    }

    /**
     * 修改客户信息
     */
    @Test
    public void testMerge(){
        //1.创建实体类管理器
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.增删改查:修改客户信息
        Customer customer = entityManager.find(Customer.class, 1L);
        customer.setCustIndustry("IT教育");
        entityManager.merge(customer);
        //4.提交事务
        transaction.commit();
        //5.释放资源
        entityManager.close();
    }

    public void testGit(){
        System.out.println("git");
    }

}
