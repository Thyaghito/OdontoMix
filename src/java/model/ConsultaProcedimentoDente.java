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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thyago
 */
@Entity
@Table(name = "consulta_procedimento_dente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaProcedimentoDente.findAll", query = "SELECT c FROM ConsultaProcedimentoDente c"),
    @NamedQuery(name = "ConsultaProcedimentoDente.findById", query = "SELECT c FROM ConsultaProcedimentoDente c WHERE c.id = :id")})
public class ConsultaProcedimentoDente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_consulta_procedimento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConsultaProcedimento idConsultaProcedimento;
    @JoinColumn(name = "id_dente", referencedColumnName = "id_dente")
    @ManyToOne(optional = false)
    private Dente idDente;

    public ConsultaProcedimentoDente() {
    }

    public ConsultaProcedimentoDente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConsultaProcedimento getIdConsultaProcedimento() {
        return idConsultaProcedimento;
    }

    public void setIdConsultaProcedimento(ConsultaProcedimento idConsultaProcedimento) {
        this.idConsultaProcedimento = idConsultaProcedimento;
    }

    public Dente getIdDente() {
        return idDente;
    }

    public void setIdDente(Dente idDente) {
        this.idDente = idDente;
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
        if (!(object instanceof ConsultaProcedimentoDente)) {
            return false;
        }
        ConsultaProcedimentoDente other = (ConsultaProcedimentoDente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ConsultaProcedimentoDente[ id=" + id + " ]";
    }
    
}
