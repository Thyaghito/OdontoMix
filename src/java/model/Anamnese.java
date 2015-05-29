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
@Table(name = "anamnese")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anamnese.findAll", query = "SELECT a FROM Anamnese a"),
    @NamedQuery(name = "Anamnese.findByIdAnamnese", query = "SELECT a FROM Anamnese a WHERE a.idAnamnese = :idAnamnese"),
    @NamedQuery(name = "Anamnese.findByGengiva", query = "SELECT a FROM Anamnese a WHERE a.gengiva = :gengiva"),
    @NamedQuery(name = "Anamnese.findByDentesSensiveis", query = "SELECT a FROM Anamnese a WHERE a.dentesSensiveis = :dentesSensiveis"),
    @NamedQuery(name = "Anamnese.findByRetencaoalimentos", query = "SELECT a FROM Anamnese a WHERE a.retencaoalimentos = :retencaoalimentos"),
    @NamedQuery(name = "Anamnese.findByAlergiaMedicamento", query = "SELECT a FROM Anamnese a WHERE a.alergiaMedicamento = :alergiaMedicamento"),
    @NamedQuery(name = "Anamnese.findByAlergiaAlimento", query = "SELECT a FROM Anamnese a WHERE a.alergiaAlimento = :alergiaAlimento"),
    @NamedQuery(name = "Anamnese.findByMordeLapis", query = "SELECT a FROM Anamnese a WHERE a.mordeLapis = :mordeLapis"),
    @NamedQuery(name = "Anamnese.findByRoiUnhas", query = "SELECT a FROM Anamnese a WHERE a.roiUnhas = :roiUnhas"),
    @NamedQuery(name = "Anamnese.findByOutrosVicios", query = "SELECT a FROM Anamnese a WHERE a.outrosVicios = :outrosVicios"),
    @NamedQuery(name = "Anamnese.findByGravida", query = "SELECT a FROM Anamnese a WHERE a.gravida = :gravida"),
    @NamedQuery(name = "Anamnese.findByDoenca", query = "SELECT a FROM Anamnese a WHERE a.doenca = :doenca"),
    @NamedQuery(name = "Anamnese.findByObservacoes", query = "SELECT a FROM Anamnese a WHERE a.observacoes = :observacoes")})
public class Anamnese implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_anamnese")
    private Integer idAnamnese;
    @Size(max = 1)
    @Column(name = "gengiva")
    private String gengiva;
    @Size(max = 10)
    @Column(name = "dentes_sensiveis")
    private String dentesSensiveis;
    @Size(max = 30)
    @Column(name = "Retencao_alimentos")
    private String retencaoalimentos;
    @Size(max = 45)
    @Column(name = "alergia_medicamento")
    private String alergiaMedicamento;
    @Size(max = 45)
    @Column(name = "alergia_alimento")
    private String alergiaAlimento;
    @Size(max = 1)
    @Column(name = "morde_lapis")
    private String mordeLapis;
    @Size(max = 1)
    @Column(name = "roi_unhas")
    private String roiUnhas;
    @Size(max = 45)
    @Column(name = "outros_vicios")
    private String outrosVicios;
    @Size(max = 4)
    @Column(name = "gravida")
    private String gravida;
    @Size(max = 45)
    @Column(name = "doenca")
    private String doenca;
    @Size(max = 100)
    @Column(name = "observacoes")
    private String observacoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnamnese")
    private Collection<Paciente> pacienteCollection;

    public Anamnese() {
    }

    public Anamnese(Integer idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public Integer getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(Integer idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public String getGengiva() {
        return gengiva;
    }

    public void setGengiva(String gengiva) {
        this.gengiva = gengiva;
    }

    public String getDentesSensiveis() {
        return dentesSensiveis;
    }

    public void setDentesSensiveis(String dentesSensiveis) {
        this.dentesSensiveis = dentesSensiveis;
    }

    public String getRetencaoalimentos() {
        return retencaoalimentos;
    }

    public void setRetencaoalimentos(String retencaoalimentos) {
        this.retencaoalimentos = retencaoalimentos;
    }

    public String getAlergiaMedicamento() {
        return alergiaMedicamento;
    }

    public void setAlergiaMedicamento(String alergiaMedicamento) {
        this.alergiaMedicamento = alergiaMedicamento;
    }

    public String getAlergiaAlimento() {
        return alergiaAlimento;
    }

    public void setAlergiaAlimento(String alergiaAlimento) {
        this.alergiaAlimento = alergiaAlimento;
    }

    public String getMordeLapis() {
        return mordeLapis;
    }

    public void setMordeLapis(String mordeLapis) {
        this.mordeLapis = mordeLapis;
    }

    public String getRoiUnhas() {
        return roiUnhas;
    }

    public void setRoiUnhas(String roiUnhas) {
        this.roiUnhas = roiUnhas;
    }

    public String getOutrosVicios() {
        return outrosVicios;
    }

    public void setOutrosVicios(String outrosVicios) {
        this.outrosVicios = outrosVicios;
    }

    public String getGravida() {
        return gravida;
    }

    public void setGravida(String gravida) {
        this.gravida = gravida;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnamnese != null ? idAnamnese.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anamnese)) {
            return false;
        }
        Anamnese other = (Anamnese) object;
        if ((this.idAnamnese == null && other.idAnamnese != null) || (this.idAnamnese != null && !this.idAnamnese.equals(other.idAnamnese))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Anamnese[ idAnamnese=" + idAnamnese + " ]";
    }
    
}
