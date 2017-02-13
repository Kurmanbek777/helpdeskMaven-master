/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "severity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Severity.findAll", query = "SELECT s FROM Severity s")
    , @NamedQuery(name = "Severity.findById", query = "SELECT s FROM Severity s WHERE s.id = :id")
    , @NamedQuery(name = "Severity.findBySeverity", query = "SELECT s FROM Severity s WHERE s.severity = :severity")})
public class Severity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Severity")
    private String severity;
    @OneToMany(mappedBy = "severityID")
    private Collection<Helpdesk> helpdeskCollection;

    public Severity() {
    }

    public Severity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    @XmlTransient
    public Collection<Helpdesk> getHelpdeskCollection() {
        return helpdeskCollection;
    }

    public void setHelpdeskCollection(Collection<Helpdesk> helpdeskCollection) {
        this.helpdeskCollection = helpdeskCollection;
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
        if (!(object instanceof Severity)) {
            return false;
        }
        Severity other = (Severity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
     //   return "jpa.entities.Severity[ id=" + id + " ]";
     return id + ". " + severity;
    }
    
}
