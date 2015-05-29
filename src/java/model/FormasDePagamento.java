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
@Table(name = "formas_de_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormasDePagamento.findAll", query = "SELECT f FROM FormasDePagamento f"),
    @NamedQuery(name = "FormasDePagamento.findByIdFormasDePagamento", query = "SELECT f FROM FormasDePagamento f WHERE f.idFormasDePagamento = :idFormasDePagamento"),
    @NamedQuery(name = "FormasDePagamento.findByNome", query = "SELECT f FROM FormasDePagamento f WHERE f.nome = :nome")})
public class FormasDePagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_formas_de_pagamento")
    private Integer idFormasDePagamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormasDePagamento")
    private Collection<ProcedimentoPagamento> procedimentoPagamentoCollection;

    public FormasDePagamento() {
    }

    public FormasDePagamento(Integer idFormasDePagamento) {
        this.idFormasDePagamento = idFormasDePagamento;
    }

    public FormasDePagamento(Integer idFormasDePagamento, String nome) {
        this.idFormasDePagamento = idFormasDePagamento;
        this.nome = nome;
    }

    public Integer getIdFormasDePagamento() {
        return idFormasDePagamento;
    }

    public void setIdFormasDePagamento(Integer idFormasDePagamento) {
        this.idFormasDePagamento = idFormasDePagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<ProcedimentoPagamento> getProcedimentoPagamentoCollection() {
        return procedimentoPagamentoCollection;
    }

    public void setProcedimentoPagamentoCollection(Collection<ProcedimentoPagamento> procedimentoPagamentoCollection) {
        this.procedimentoPagamentoCollection = procedimentoPagamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormasDePagamento != null ? idFormasDePagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormasDePagamento)) {
            return false;
        }
        FormasDePagamento other = (FormasDePagamento) object;
        if ((this.idFormasDePagamento == null && other.idFormasDePagamento != null) || (this.idFormasDePagamento != null && !this.idFormasDePagamento.equals(other.idFormasDePagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FormasDePagamento[ idFormasDePagamento=" + idFormasDePagamento + " ]";
    }
    
}
