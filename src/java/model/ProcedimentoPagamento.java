/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thyago
 */
@Entity
@Table(name = "procedimento_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcedimentoPagamento.findAll", query = "SELECT p FROM ProcedimentoPagamento p"),
    @NamedQuery(name = "ProcedimentoPagamento.findById", query = "SELECT p FROM ProcedimentoPagamento p WHERE p.id = :id"),
    @NamedQuery(name = "ProcedimentoPagamento.findByValor", query = "SELECT p FROM ProcedimentoPagamento p WHERE p.valor = :valor")})
public class ProcedimentoPagamento implements Serializable {
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
    @JoinColumn(name = "id_consulta_procedimento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConsultaProcedimento idConsultaProcedimento;
    @JoinColumn(name = "id_formas_de_pagamento", referencedColumnName = "id_formas_de_pagamento")
    @ManyToOne(optional = false)
    private FormasDePagamento idFormasDePagamento;

    public ProcedimentoPagamento() {
    }

    public ProcedimentoPagamento(Integer id) {
        this.id = id;
    }

    public ProcedimentoPagamento(Integer id, int valor) {
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

    public ConsultaProcedimento getIdConsultaProcedimento() {
        return idConsultaProcedimento;
    }

    public void setIdConsultaProcedimento(ConsultaProcedimento idConsultaProcedimento) {
        this.idConsultaProcedimento = idConsultaProcedimento;
    }

    public FormasDePagamento getIdFormasDePagamento() {
        return idFormasDePagamento;
    }

    public void setIdFormasDePagamento(FormasDePagamento idFormasDePagamento) {
        this.idFormasDePagamento = idFormasDePagamento;
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
        if (!(object instanceof ProcedimentoPagamento)) {
            return false;
        }
        ProcedimentoPagamento other = (ProcedimentoPagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProcedimentoPagamento[ id=" + id + " ]";
    }
    
}
