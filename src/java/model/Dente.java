/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thyago
 */
@Entity
@Table(name = "dente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dente.findAll", query = "SELECT d FROM Dente d"),
    @NamedQuery(name = "Dente.findByIdDente", query = "SELECT d FROM Dente d WHERE d.idDente = :idDente"),
    @NamedQuery(name = "Dente.findByNome", query = "SELECT d FROM Dente d WHERE d.nome = :nome")})
public class Dente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dente")
    private Integer idDente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDente")
    private Collection<ConsultaProcedimentoDente> consultaProcedimentoDenteCollection;

    public Dente() {
    }

    public Dente(Integer idDente) {
        this.idDente = idDente;
    }

    public Dente(Integer idDente, String nome) {
        this.idDente = idDente;
        this.nome = nome;
    }

    public Integer getIdDente() {
        return idDente;
    }

    public void setIdDente(Integer idDente) {
        this.idDente = idDente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<ConsultaProcedimentoDente> getConsultaProcedimentoDenteCollection() {
        return consultaProcedimentoDenteCollection;
    }

    public void setConsultaProcedimentoDenteCollection(Collection<ConsultaProcedimentoDente> consultaProcedimentoDenteCollection) {
        this.consultaProcedimentoDenteCollection = consultaProcedimentoDenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDente != null ? idDente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dente)) {
            return false;
        }
        Dente other = (Dente) object;
        if ((this.idDente == null && other.idDente != null) || (this.idDente != null && !this.idDente.equals(other.idDente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dente[ idDente=" + idDente + " ]";
    }
    
}
