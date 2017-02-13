/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
import java.io.*;
 import java.sql.*;
 import java.util.*;
 
 import org.apache.commons.dbcp.*;
 import org.apache.commons.pool.impl.*;
*/
/**
 *
 * @author User
 */
@Entity
@Table(name = "helpdesk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Helpdesk.findAll", query = "SELECT h FROM Helpdesk h")
    , @NamedQuery(name = "Helpdesk.findById", query = "SELECT h FROM Helpdesk h WHERE h.id = :id")
    , @NamedQuery(name = "Helpdesk.findByFName", query = "SELECT h FROM Helpdesk h WHERE h.fName = :fName")
    , @NamedQuery(name = "Helpdesk.findByLName", query = "SELECT h FROM Helpdesk h WHERE h.lName = :lName")
    , @NamedQuery(name = "Helpdesk.findByEmail", query = "SELECT h FROM Helpdesk h WHERE h.email = :email")
    , @NamedQuery(name = "Helpdesk.findByComments", query = "SELECT h FROM Helpdesk h WHERE h.comments = :comments")})
public class Helpdesk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "FName")
    private String fName;
    @Size(max = 45)
    @Column(name = "LName")
    private String lName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Email")
    private String email;
    @Size(max = 45)
    @Column(name = "Comments")
    private String comments;
    @JoinColumn(name = "StatusID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status statusID;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Department departmentID;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employeeID;
    @JoinColumn(name = "SeverityID", referencedColumnName = "ID")
    @ManyToOne
    private Severity severityID;

    public Helpdesk() {
    }

    public Helpdesk(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Status getStatusID() {
        return statusID;
    }

    public void setStatusID(Status statusID) {
        this.statusID = statusID;
    }

    public Department getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Department departmentID) {
        this.departmentID = departmentID;
    }

    public Employee getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employee employeeID) {
        this.employeeID = employeeID;
    }

    public Severity getSeverityID() {
        return severityID;
    }

    public void setSeverityID(Severity severityID) {
        this.severityID = severityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Helpdesk)) {
            return false;
        }
        Helpdesk other = (Helpdesk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Helpdesk[ id=" + id + " ]";
    }
        

    
/**  Калыс, посмотри как этот код использовать для поиска заявок по ID
 * 
}

public class ConnectionPool
 {
   protected GenericObjectPool connectionPool;
 
   public void initConnectionPool( String driver, String dbURL, String dbUser, String dbPswd )
   {
     try
     {
       Class.forName( driver ).newInstance();//создаем новый объект класса драйвера,
       //тем самым инициализируя его
 
       connectionPool = new GenericObjectPool( null );//создаем GenericObjectPool
       //создаем connection factory ("фабрика соединений" - объект который будет создавать соединения)
       ConnectionFactory connectionFactory = new DriverManagerConnectionFactory( dbURL, dbUser, dbPswd );
 
       //создаем PoolableConnectionFactory
       new PoolableConnectionFactory( connectionFactory, connectionPool, null, "SELECT 1", false, true );
 
       new PoolingDataSource( connectionPool );
       connectionPool.setMaxIdle( 20 );//устанавливаем максимальное кол-во простаивающих соединений
       connectionPool.setMaxActive( 300 );//устанавилваем макс. кол-во активных соединений
     }
     catch( Exception ex )
     {
        ex.printStackTrace();
     }
   }
 
   /**
    * Функция получения connection из пула
    * @return Connection
    */
  /**
    public final Connection getConnection()
   {
     try
     {
       if( connectionPool.getMaxActive() <= connectionPool.getNumActive() )
       {
          System.err.println( "Connections limit is over!!!" );
       }
 
       Connection con = (Connection)connectionPool.borrowObject();
       return con;
     }
     catch( Exception ex )
     {
       ex.printStackTrace();
       return null;
     }
   }
 */
   /**
    * Функция возвращения connection в пул
    */
   
    /**
    public final void returnConnection( Connection con )
   {
     if( con == null )
     {
       System.err.println( "Returning NULL to pool!!!" );
       return;
     }
 
     try
     {
       connectionPool.returnObject( con );
     }
     catch( Exception ex )
     {
     }
   }
 
 
   public static void main( String[] args )
   {
     //создаем наш объект ConnectionPool
     ConnectionPool pool = new ConnectionPool();
     //единожды инициализируем его указав класс драйвера, URL базы данных, а также логин и пароль к базе данных
     pool.initConnectionPool( "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mwd", "root", "root" );
 
     //получаем connection
     Connection con = pool.getConnection();
 
     //что нибудь делаем
     PreparedStatement ps = con.prepareStatement( "SELECT * FROM employee WHERE id=?" );
     ps.setInt( 1, 3546 );
 
     ResultSet rs = ps.executeQuery();
     //получаем следующую строку результата, если она есть. '''В самом начале курсор стоит перед'''
     //'''первой строкой'''. Если строка есть функция next() возвращает true и передвигает курсор
     //на следующую строку
     while( rs.next() )
     {
       System.out.println( rs.getString( "lastname" ) );
     }
     ps.close();
 
     //возвращаем соединение в пул
     pool.returnConnection( con );
   }
 }
  */