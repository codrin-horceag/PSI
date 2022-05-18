package com.proiectmvc.demo.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
    private List<ProdusFinit> produseFinite = new LinkedList<>();

    @OneToOne(mappedBy = "notePredare")
    private Depozit depozit;

    public NotaPredare() {
    }

    public NotaPredare(LocalDate dataEliberare, LocalDate dataIntocmire, Integer nrDocument, List<ProdusFinit> produseFinite, Depozit depozit) {
        super(dataEliberare, dataIntocmire, nrDocument);
        this.produseFinite = produseFinite;
        this.depozit = depozit;
    }

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

    public List<ProdusFinit> getProduseFinite() {
        return this.produseFinite;
    }

    public void setProduseFinite(List<ProdusFinit> produseFinite) {
        if (this.produseFinite != null) {
            this.produseFinite.forEach(i -> i.setNotePredare(null));
        }
        if (produseFinite != null) {
            produseFinite.forEach(i -> i.setNotePredare(this));
        }
        this.produseFinite = produseFinite;
    }

    public NotaPredare produseFinites(List<ProdusFinit> produseFinite) {
        this.setProduseFinite(produseFinite);
        return this;
    }

    public NotaPredare addProduseFinite(ProdusFinit produsFinit) {
        this.produseFinite.add(produsFinit);
        produsFinit.setNotePredare(this);
        return this;
    }

    public NotaPredare removeProduseFinite(ProdusFinit produsFinit) {
        this.produseFinite.remove(produsFinit);
        produsFinit.setNotePredare(null);
        return this;
    }

    public Depozit getDepozit() {
        return depozit;
    }

    public void setDepozit(Depozit depozit) {
        this.depozit = depozit;
    }


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
