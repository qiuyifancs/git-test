package cn.itcast.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 客户实体类
 *      1.配置实体类与数据库表的映射
 *          @Entity:声明实体类
 *          @Table:配置实体类与表的映射关系
 *      2.配置实体类属性与表字段的映射
 */
@Entity
@Table(name = "cst_customer")
public class Customer implements Serializable{

    /**
     * @Id:声明主键的配置
     * @GeneratedValue:配置主键的生成策略
     *      GenerationType.IDENTITY:自增
     *          *底层数据库必须支持自动增长（底层数据库提供的id自增方式实现id自增）
     *      GenerationType.SEQUENCE:序列
     *          *底层数据库必须支持序列
     *      GenerationType.TABLE:jpa提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增
     *      GenerationType.AUTO:由程序自动帮助我们选择主键生成策略
     *      （一般选择前两种，后两种了解即可）
     * @Column:配置属性与字段的映射
     *      name:映射的表的字段
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_source")
    private String custSource;
    @Column(name = "cust_industry")
    private String custIndustry;
    @Column(name = "cust_level")
    private String custLevel;
    @Column(name = "cust_address")
    private String custAddress;
    @Column(name = "cust_phone")
    private String custPhone;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
