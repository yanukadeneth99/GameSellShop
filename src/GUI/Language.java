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
@Table(name = "LANGUAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l")
    , @NamedQuery(name = "Language.findByLangid", query = "SELECT l FROM Language l WHERE l.langid = :langid")
    , @NamedQuery(name = "Language.findByLanguage", query = "SELECT l FROM Language l WHERE l.language = :language")})
public class Language implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LANGID")
    private Integer langid;
    @Basic(optional = false)
    @Column(name = "LANGUAGE")
    private String language;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "language")
    private Collection<Users> usersCollection;

    public Language() {
    }

    public Language(Integer langid) {
        this.langid = langid;
    }

    public Language(Integer langid, String language) {
        this.langid = langid;
        this.language = language;
    }

    public Integer getLangid() {
        return langid;
    }

    public void setLangid(Integer langid) {
        Integer oldLangid = this.langid;
        this.langid = langid;
        changeSupport.firePropertyChange("langid", oldLangid, langid);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        String oldLanguage = this.language;
        this.language = language;
        changeSupport.firePropertyChange("language", oldLanguage, language);
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (langid != null ? langid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.langid == null && other.langid != null) || (this.langid != null && !this.langid.equals(other.langid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return language;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
