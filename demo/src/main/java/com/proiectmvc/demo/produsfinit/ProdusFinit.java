package com.proiectmvc.demo.produsfinit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.document.NotaPredare;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ProdusFinit.
 */
@Entity
@Table(name = "produs_finit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProdusFinit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "cantitate")
    private Double cantitate;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "unitate_masura")
    private String unitateMasura;

    @ManyToOne
    @JsonIgnoreProperties(value = { "produseFinites", "notePredare" }, allowSetters = true)
    private Depozit depozit;

    @ManyToOne
    @JsonIgnoreProperties(value = { "produseFinites", "depozites" }, allowSetters = true)
    private NotaPredare notePredare;

    public ProdusFinit() {
    }

    public ProdusFinit(int id, double cantitate, String denumire, String um) {
        this.id = Long.valueOf(id);
        this.cantitate = cantitate;
        this.denumire = denumire;
        this.unitateMasura = um;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ProdusFinit id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCantitate() {
        return this.cantitate;
    }

    public ProdusFinit cantitate(Double cantitate) {
        this.setCantitate(cantitate);
        return this;
    }

    public void setCantitate(Double cantitate) {
        this.cantitate = cantitate;
    }

    public String getDenumire() {
        return this.denumire;
    }

    public ProdusFinit denumire(String denumire) {
        this.setDenumire(denumire);
        return this;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getUnitateMasura() {
        return this.unitateMasura;
    }

    public ProdusFinit unitateMasura(String unitateMasura) {
        this.setUnitateMasura(unitateMasura);
        return this;
    }

    public void setUnitateMasura(String unitateMasura) {
        this.unitateMasura = unitateMasura;
    }

    public Depozit getDepozit() {
        return this.depozit;
    }

    public void setDepozit(Depozit depozit) {
        this.depozit = depozit;
    }

    public ProdusFinit depozit(Depozit depozit) {
        this.setDepozit(depozit);
        return this;
    }

    public NotaPredare getNotePredare() {
        return this.notePredare;
    }

    public void setNotePredare(NotaPredare notaPredare) {
        this.notePredare = notaPredare;
    }

    public ProdusFinit notePredare(NotaPredare notaPredare) {
        this.setNotePredare(notaPredare);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProdusFinit)) {
            return false;
        }
        return id != null && id.equals(((ProdusFinit) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProdusFinit{" +
            "id=" + getId() +
            ", cantitate=" + getCantitate() +
            ", denumire='" + getDenumire() + "'" +
            ", unitateMasura='" + getUnitateMasura() + "'" +
            "}";
    }
}
