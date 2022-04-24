/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yanukadeneth
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
    , @NamedQuery(name = "Orders.findByCustomername", query = "SELECT o FROM Orders o WHERE o.customername = :customername")
    , @NamedQuery(name = "Orders.findByCustomerphone", query = "SELECT o FROM Orders o WHERE o.customerphone = :customerphone")
    , @NamedQuery(name = "Orders.findByPurchaseddate", query = "SELECT o FROM Orders o WHERE o.purchaseddate = :purchaseddate")
    , @NamedQuery(name = "Orders.findByNoofgamespurchased", query = "SELECT o FROM Orders o WHERE o.noofgamespurchased = :noofgamespurchased")
    , @NamedQuery(name = "Orders.findByTotalprice", query = "SELECT o FROM Orders o WHERE o.totalprice = :totalprice")})
public class Orders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Column(name = "CUSTOMERPHONE")
    private BigInteger customerphone;
    @Basic(optional = false)
    @Column(name = "PURCHASEDDATE")
    @Temporal(TemporalType.DATE)
    private Date purchaseddate;
    @Basic(optional = false)
    @Column(name = "NOOFGAMESPURCHASED")
    private int noofgamespurchased;
    @Basic(optional = false)
    @Column(name = "TOTALPRICE")
    private int totalprice;
    @JoinColumn(name = "CLIENTUSERNAME", referencedColumnName = "USERNAME")
    @ManyToOne(optional = false)
    private Users clientusername;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, String customername, Date purchaseddate, int noofgamespurchased, int totalprice) {
        this.id = id;
        this.customername = customername;
        this.purchaseddate = purchaseddate;
        this.noofgamespurchased = noofgamespurchased;
        this.totalprice = totalprice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        String oldCustomername = this.customername;
        this.customername = customername;
        changeSupport.firePropertyChange("customername", oldCustomername, customername);
    }

    public BigInteger getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(BigInteger customerphone) {
        BigInteger oldCustomerphone = this.customerphone;
        this.customerphone = customerphone;
        changeSupport.firePropertyChange("customerphone", oldCustomerphone, customerphone);
    }

    public Date getPurchaseddate() {
        return purchaseddate;
    }

    public void setPurchaseddate(Date purchaseddate) {
        Date oldPurchaseddate = this.purchaseddate;
        this.purchaseddate = purchaseddate;
        changeSupport.firePropertyChange("purchaseddate", oldPurchaseddate, purchaseddate);
    }

    public int getNoofgamespurchased() {
        return noofgamespurchased;
    }

    public void setNoofgamespurchased(int noofgamespurchased) {
        int oldNoofgamespurchased = this.noofgamespurchased;
        this.noofgamespurchased = noofgamespurchased;
        changeSupport.firePropertyChange("noofgamespurchased", oldNoofgamespurchased, noofgamespurchased);
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        int oldTotalprice = this.totalprice;
        this.totalprice = totalprice;
        changeSupport.firePropertyChange("totalprice", oldTotalprice, totalprice);
    }

    public Users getClientusername() {
        return clientusername;
    }

    public void setClientusername(Users clientusername) {
        Users oldClientusername = this.clientusername;
        this.clientusername = clientusername;
        changeSupport.firePropertyChange("clientusername", oldClientusername, clientusername);
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Orders[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
