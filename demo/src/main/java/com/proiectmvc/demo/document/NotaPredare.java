package com.proiectmvc.demo.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.proiectmvc.demo.depozit.Depozit;
import com.proiectmvc.demo.produsfinit.ProdusFinit;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A NotaPredare.
 */
@Entity
@Table(name = "nota_predare")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NotaPredare extends Document {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "notePredare")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "depozit", "notePredare" }, allowSetters = true)
    private Set<ProdusFinit> produseFinites = new HashSet<>();

    @OneToMany(mappedBy = "notePredare")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "produseFinites", "notePredare" }, allowSetters = true)
    private Set<Depozit> depozites = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public NotaPredare id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProdusFinit> getProduseFinites() {
        return this.produseFinites;
    }

    public void setProduseFinites(Set<ProdusFinit> produsFinits) {
        if (this.produseFinites != null) {
            this.produseFinites.forEach(i -> i.setNotePredare(null));
        }
        if (produsFinits != null) {
            produsFinits.forEach(i -> i.setNotePredare(this));
        }
        this.produseFinites = produsFinits;
    }

    public NotaPredare produseFinites(Set<ProdusFinit> produsFinits) {
        this.setProduseFinites(produsFinits);
        return this;
    }

    public NotaPredare addProduseFinite(ProdusFinit produsFinit) {
        this.produseFinites.add(produsFinit);
        produsFinit.setNotePredare(this);
        return this;
    }

    public NotaPredare removeProduseFinite(ProdusFinit produsFinit) {
        this.produseFinites.remove(produsFinit);
        produsFinit.setNotePredare(null);
        return this;
    }

    public Set<Depozit> getDepozites() {
        return this.depozites;
    }

    public void setDepozites(Set<Depozit> depozits) {
        if (this.depozites != null) {
            this.depozites.forEach(i -> i.setNotePredare(null));
        }
        if (depozits != null) {
            depozits.forEach(i -> i.setNotePredare(this));
        }
        this.depozites = depozits;
    }

    public NotaPredare depozites(Set<Depozit> depozits) {
        this.setDepozites(depozits);
        return this;
    }

    public NotaPredare addDepozite(Depozit depozit) {
        this.depozites.add(depozit);
        depozit.setNotePredare(this);
        return this;
    }

    public NotaPredare removeDepozite(Depozit depozit) {
        this.depozites.remove(depozit);
        depozit.setNotePredare(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NotaPredare)) {
            return false;
        }
        return id != null && id.equals(((NotaPredare) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.co,m/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NotaPredare{" +
            "id=" + getId() +
            "}";
    }
}
