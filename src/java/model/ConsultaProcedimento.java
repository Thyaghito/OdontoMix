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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thyago
 */
@Entity
@Table(name = "consulta_procedimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaProcedimento.findAll", query = "SELECT c FROM ConsultaProcedimento c"),
    @NamedQuery(name = "ConsultaProcedimento.findById", query = "SELECT c FROM ConsultaProcedimento c WHERE c.id = :id")})
public class ConsultaProcedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsultaProcedimento")
    private Collection<ConsultaProcedimentoDente> consultaProcedimentoDenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsultaProcedimento")
    private Collection<ProcedimentoPagamento> procedimentoPagamentoCollection;
    @JoinColumn(name = "id_convenio_procedimento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConvenioProcedimento idConvenioProcedimento;
    @JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta")
    @ManyToOne(optional = false)
    private Consulta idConsulta;

    public ConsultaProcedimento() {
    }

    public ConsultaProcedimento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<ConsultaProcedimentoDente> getConsultaProcedimentoDenteCollection() {
        return consultaProcedimentoDenteCollection;
    }

    public void setConsultaProcedimentoDenteCollection(Collection<ConsultaProcedimentoDente> consultaProcedimentoDenteCollection) {
        this.consultaProcedimentoDenteCollection = consultaProcedimentoDenteCollection;
    }

    @XmlTransient
    public Collection<ProcedimentoPagamento> getProcedimentoPagamentoCollection() {
        return procedimentoPagamentoCollection;
    }

    public void setProcedimentoPagamentoCollection(Collection<ProcedimentoPagamento> procedimentoPagamentoCollection) {
        this.procedimentoPagamentoCollection = procedimentoPagamentoCollection;
    }

    public ConvenioProcedimento getIdConvenioProcedimento() {
        return idConvenioProcedimento;
    }

    public void setIdConvenioProcedimento(ConvenioProcedimento idConvenioProcedimento) {
        this.idConvenioProcedimento = idConvenioProcedimento;
    }

    public Consulta getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Consulta idConsulta) {
        this.idConsulta = idConsulta;
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
        if (!(object instanceof ConsultaProcedimento)) {
            return false;
        }
        ConsultaProcedimento other = (ConsultaProcedimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ConsultaProcedimento[ id=" + id + " ]";
    }
    
}
