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
@Table(name = "convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c"),
    @NamedQuery(name = "Convenio.findByIdConvenio", query = "SELECT c FROM Convenio c WHERE c.idConvenio = :idConvenio"),
    @NamedQuery(name = "Convenio.findByNome", query = "SELECT c FROM Convenio c WHERE c.nome = :nome")})
public class Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_convenio")
    private Integer idConvenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConvenio")
    private Collection<Paciente> pacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConvenio")
    private Collection<ConvenioProcedimento> convenioProcedimentoCollection;

    public Convenio() {
    }

    public Convenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Convenio(Integer idConvenio, String nome) {
        this.idConvenio = idConvenio;
        this.nome = nome;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @XmlTransient
    public Collection<ConvenioProcedimento> getConvenioProcedimentoCollection() {
        return convenioProcedimentoCollection;
    }

    public void setConvenioProcedimentoCollection(Collection<ConvenioProcedimento> convenioProcedimentoCollection) {
        this.convenioProcedimentoCollection = convenioProcedimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvenio != null ? idConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.idConvenio == null && other.idConvenio != null) || (this.idConvenio != null && !this.idConvenio.equals(other.idConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Convenio[ idConvenio=" + idConvenio + " ]";
    }
    
}
