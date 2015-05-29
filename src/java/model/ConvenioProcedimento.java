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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thyago
 */
@Entity
@Table(name = "convenio_procedimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConvenioProcedimento.findAll", query = "SELECT c FROM ConvenioProcedimento c"),
    @NamedQuery(name = "ConvenioProcedimento.findById", query = "SELECT c FROM ConvenioProcedimento c WHERE c.id = :id"),
    @NamedQuery(name = "ConvenioProcedimento.findByValor", query = "SELECT c FROM ConvenioProcedimento c WHERE c.valor = :valor")})
public class ConvenioProcedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConvenioProcedimento")
    private Collection<ConsultaProcedimento> consultaProcedimentoCollection;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio")
    @ManyToOne(optional = false)
    private Convenio idConvenio;
    @JoinColumn(name = "id_procedimento", referencedColumnName = "id_procedimento")
    @ManyToOne(optional = false)
    private Procedimento idProcedimento;

    public ConvenioProcedimento() {
    }

    public ConvenioProcedimento(Integer id) {
        this.id = id;
    }

    public ConvenioProcedimento(Integer id, int valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<ConsultaProcedimento> getConsultaProcedimentoCollection() {
        return consultaProcedimentoCollection;
    }

    public void setConsultaProcedimentoCollection(Collection<ConsultaProcedimento> consultaProcedimentoCollection) {
        this.consultaProcedimentoCollection = consultaProcedimentoCollection;
    }

    public Convenio getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenio idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Procedimento getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(Procedimento idProcedimento) {
        this.idProcedimento = idProcedimento;
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
        if (!(object instanceof ConvenioProcedimento)) {
            return false;
        }
        ConvenioProcedimento other = (ConvenioProcedimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ConvenioProcedimento[ id=" + id + " ]";
    }
    
}
