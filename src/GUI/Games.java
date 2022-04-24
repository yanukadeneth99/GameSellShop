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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yanukadeneth
 */
@Entity
@Table(name = "GAMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Games.findAll", query = "SELECT g FROM Games g")
    , @NamedQuery(name = "Games.findById", query = "SELECT g FROM Games g WHERE g.id = :id")
    , @NamedQuery(name = "Games.findByName", query = "SELECT g FROM Games g WHERE g.name = :name")
    , @NamedQuery(name = "Games.findByDatereleased", query = "SELECT g FROM Games g WHERE g.datereleased = :datereleased")
    , @NamedQuery(name = "Games.findByDateadded", query = "SELECT g FROM Games g WHERE g.dateadded = :dateadded")
    , @NamedQuery(name = "Games.findByCompany", query = "SELECT g FROM Games g WHERE g.company = :company")
    , @NamedQuery(name = "Games.findByPurchasedprice", query = "SELECT g FROM Games g WHERE g.purchasedprice = :purchasedprice")
    , @NamedQuery(name = "Games.findByRetailprice", query = "SELECT g FROM Games g WHERE g.retailprice = :retailprice")
    , @NamedQuery(name = "Games.findByDiscount", query = "SELECT g FROM Games g WHERE g.discount = :discount")
    , @NamedQuery(name = "Games.findByStocks", query = "SELECT g FROM Games g WHERE g.stocks = :stocks")
    , @NamedQuery(name = "Games.findByPicture", query = "SELECT g FROM Games g WHERE g.picture = :picture")
    , @NamedQuery(name = "Games.findBySoldamount", query = "SELECT g FROM Games g WHERE g.soldamount = :soldamount")})
public class Games implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATERELEASED")
    @Temporal(TemporalType.DATE)
    private Date datereleased;
    @Basic(optional = false)
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.DATE)
    private Date dateadded;
    @Basic(optional = false)
    @Column(name = "COMPANY")
    private String company;
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "PURCHASEDPRICE")
    private int purchasedprice;
    @Basic(optional = false)
    @Column(name = "RETAILPRICE")
    private int retailprice;
    @Basic(optional = false)
    @Column(name = "DISCOUNT")
    private int discount;
    @Basic(optional = false)
    @Column(name = "STOCKS")
    private int stocks;
    @Column(name = "PICTURE")
    private String picture;
    @Basic(optional = false)
    @Column(name = "SOLDAMOUNT")
    private int soldamount;
    @JoinColumn(name = "GENRE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Genre genre;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameid")
    private Collection<Purchases> purchasesCollection;

    public Games() {
    }

    public Games(Integer id) {
        this.id = id;
    }

    public Games(Integer id, String name, Date dateadded, String company, int purchasedprice, int retailprice, int discount, int stocks, int soldamount) {
        this.id = id;
        this.name = name;
        this.dateadded = dateadded;
        this.company = company;
        this.purchasedprice = purchasedprice;
        this.retailprice = retailprice;
        this.discount = discount;
        this.stocks = stocks;
        this.soldamount = soldamount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getDatereleased() {
        return datereleased;
    }

    public void setDatereleased(Date datereleased) {
        Date oldDatereleased = this.datereleased;
        this.datereleased = datereleased;
        changeSupport.firePropertyChange("datereleased", oldDatereleased, datereleased);
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        Date oldDateadded = this.dateadded;
        this.dateadded = dateadded;
        changeSupport.firePropertyChange("dateadded", oldDateadded, dateadded);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        String oldCompany = this.company;
        this.company = company;
        changeSupport.firePropertyChange("company", oldCompany, company);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public int getPurchasedprice() {
        return purchasedprice;
    }

    public void setPurchasedprice(int purchasedprice) {
        int oldPurchasedprice = this.purchasedprice;
        this.purchasedprice = purchasedprice;
        changeSupport.firePropertyChange("purchasedprice", oldPurchasedprice, purchasedprice);
    }

    public int getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(int retailprice) {
        int oldRetailprice = this.retailprice;
        this.retailprice = retailprice;
        changeSupport.firePropertyChange("retailprice", oldRetailprice, retailprice);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        int oldDiscount = this.discount;
        this.discount = discount;
        changeSupport.firePropertyChange("discount", oldDiscount, discount);
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        int oldStocks = this.stocks;
        this.stocks = stocks;
        changeSupport.firePropertyChange("stocks", oldStocks, stocks);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        String oldPicture = this.picture;
        this.picture = picture;
        changeSupport.firePropertyChange("picture", oldPicture, picture);
    }

    public int getSoldamount() {
        return soldamount;
    }

    public void setSoldamount(int soldamount) {
        int oldSoldamount = this.soldamount;
        this.soldamount = soldamount;
        changeSupport.firePropertyChange("soldamount", oldSoldamount, soldamount);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        Genre oldGenre = this.genre;
        this.genre = genre;
        changeSupport.firePropertyChange("genre", oldGenre, genre);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        Status oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    @XmlTransient
    public Collection<Purchases> getPurchasesCollection() {
        return purchasesCollection;
    }

    public void setPurchasesCollection(Collection<Purchases> purchasesCollection) {
        this.purchasesCollection = purchasesCollection;
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
        if (!(object instanceof Games)) {
            return false;
        }
        Games other = (Games) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
