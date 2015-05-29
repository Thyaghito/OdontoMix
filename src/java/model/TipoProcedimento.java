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
@Table(name = "tipo_procedimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProcedimento.findAll", query = "SELECT t FROM TipoProcedimento t"),
    @NamedQuery(name = "TipoProcedimento.findByIdTipoProcedimento", query = "SELECT t FROM TipoProcedimento t WHERE t.idTipoProcedimento = :idTipoProcedimento"),
    @NamedQuery(name = "TipoProcedimento.findByNome", query = "SELECT t FROM TipoProcedimento t WHERE t.nome = :nome")})
public class TipoProcedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_procedimento")
    private Integer idTipoProcedimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProcedimento")
    private Collection<Procedimento> procedimentoCollection;

    public TipoProcedimento() {
    }

    public TipoProcedimento(Integer idTipoProcedimento) {
        this.idTipoProcedimento = idTipoProcedimento;
    }

    public TipoProcedimento(Integer idTipoProcedimento, String nome) {
        this.idTipoProcedimento = idTipoProcedimento;
        this.nome = nome;
    }

    public Integer getIdTipoProcedimento() {
        return idTipoProcedimento;
    }

    public void setIdTipoProcedimento(Integer idTipoProcedimento) {
        this.idTipoProcedimento = idTipoProcedimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Procedimento> getProcedimentoCollection() {
        return procedimentoCollection;
    }

    public void setProcedimentoCollection(Collection<Procedimento> procedimentoCollection) {
        this.procedimentoCollection = procedimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProcedimento != null ? idTipoProcedimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProcedimento)) {
            return false;
        }
        TipoProcedimento other = (TipoProcedimento) object;
        if ((this.idTipoProcedimento == null && other.idTipoProcedimento != null) || (this.idTipoProcedimento != null && !this.idTipoProcedimento.equals(other.idTipoProcedimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoProcedimento[ idTipoProcedimento=" + idTipoProcedimento + " ]";
    }
    
}
