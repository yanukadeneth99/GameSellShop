/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yanukadeneth
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByForgotpasshint", query = "SELECT u FROM Users u WHERE u.forgotpasshint = :forgotpasshint")
    , @NamedQuery(name = "Users.findByResetpass", query = "SELECT u FROM Users u WHERE u.resetpass = :resetpass")})
public class Users implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "FORGOTPASSHINT")
    private String forgotpasshint;
    @Basic(optional = false)
    @Column(name = "RESETPASS")
    private Boolean resetpass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientusername")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "LANGUAGE", referencedColumnName = "LANGID")
    @ManyToOne(optional = false)
    private Language language;
    @JoinColumn(name = "USERTYPE", referencedColumnName = "TYPEID")
    @ManyToOne(optional = false)
    private Usertype usertype;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, String name, String password, String forgotpasshint, Boolean resetpass) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.forgotpasshint = forgotpasshint;
        this.resetpass = resetpass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getForgotpasshint() {
        return forgotpasshint;
    }

    public void setForgotpasshint(String forgotpasshint) {
        String oldForgotpasshint = this.forgotpasshint;
        this.forgotpasshint = forgotpasshint;
        changeSupport.firePropertyChange("forgotpasshint", oldForgotpasshint, forgotpasshint);
    }

    public Boolean getResetpass() {
        return resetpass;
    }

    public void setResetpass(Boolean resetpass) {
        Boolean oldResetpass = this.resetpass;
        this.resetpass = resetpass;
        changeSupport.firePropertyChange("resetpass", oldResetpass, resetpass);
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        Language oldLanguage = this.language;
        this.language = language;
        changeSupport.firePropertyChange("language", oldLanguage, language);
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(Usertype usertype) {
        Usertype oldUsertype = this.usertype;
        this.usertype = usertype;
        changeSupport.firePropertyChange("usertype", oldUsertype, usertype);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username + " : " + name;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
