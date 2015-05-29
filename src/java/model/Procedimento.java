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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thyago
 */
@Entity
@Table(name = "procedimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimento.findAll", query = "SELECT p FROM Procedimento p"),
    @NamedQuery(name = "Procedimento.findByIdProcedimento", query = "SELECT p FROM Procedimento p WHERE p.idProcedimento = :idProcedimento"),
    @NamedQuery(name = "Procedimento.findByNome", query = "SELECT p FROM Procedimento p WHERE p.nome = :nome"),
    @NamedQuery(name = "Procedimento.findByObservacoes", query = "SELECT p FROM Procedimento p WHERE p.observacoes = :observacoes")})
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procedimento")
    private Integer idProcedimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 200)
    @Column(name = "observacoes")
    private String observacoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProcedimento")
    private Collection<ConvenioProcedimento> convenioProcedimentoCollection;
    @JoinColumn(name = "id_tipo_procedimento", referencedColumnName = "id_tipo_procedimento")
    @ManyToOne(optional = false)
    private TipoProcedimento idTipoProcedimento;

    public Procedimento() {
    }

    public Procedimento(Integer idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public Procedimento(Integer idProcedimento, String nome) {
        this.idProcedimento = idProcedimento;
        this.nome = nome;
    }

    public Integer getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(Integer idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @XmlTransient
    public Collection<ConvenioProcedimento> getConvenioProcedimentoCollection() {
        return convenioProcedimentoCollection;
    }

    public void setConvenioProcedimentoCollection(Collection<ConvenioProcedimento> convenioProcedimentoCollection) {
        this.convenioProcedimentoCollection = convenioProcedimentoCollection;
    }

    public TipoProcedimento getIdTipoProcedimento() {
        return idTipoProcedimento;
    }

    public void setIdTipoProcedimento(TipoProcedimento idTipoProcedimento) {
        this.idTipoProcedimento = idTipoProcedimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedimento != null ? idProcedimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimento)) {
            return false;
        }
        Procedimento other = (Procedimento) object;
        if ((this.idProcedimento == null && other.idProcedimento != null) || (this.idProcedimento != null && !this.idProcedimento.equals(other.idProcedimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Procedimento[ idProcedimento=" + idProcedimento + " ]";
    }
    
}
