package com.proiectmvc.demo.depozit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

import com.proiectmvc.demo.document.NotaPredare;
import com.proiectmvc.demo.produsfinit.ProdusFinit;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "depozit", schema = "public")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Depozit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "denumire_depozit")
    private String denumireDepozit;

    @Enumerated(EnumType.STRING)
    @Column(name = "material_depozit")
    private StocDepozit materialDepozit;

    @OneToMany(mappedBy = "depozit")
    private List<ProdusFinit> produseFinite = new LinkedList<>();

    @OneToOne
    private NotaPredare notePredare;

    public Depozit() {
    }

    public Depozit(Long id, String denumireDepozit, StocDepozit materialDepozit, List<ProdusFinit> produseFinite) {
        this.id = id;
        this.denumireDepozit = denumireDepozit;
        this.materialDepozit = materialDepozit;
        this.produseFinite = produseFinite;
    }


    public Long getId() {
        return this.id;
    }

    public Depozit id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenumireDepozit() {
        return this.denumireDepozit;
    }

    public Depozit denumireDepozit(String denumireDepozit) {
        this.setDenumireDepozit(denumireDepozit);
        return this;
    }

    public void setDenumireDepozit(String denumireDepozit) {
        this.denumireDepozit = denumireDepozit;
    }

    public StocDepozit getMaterialDepozit() {
        return this.materialDepozit;
    }

    public Depozit materialDepozit(StocDepozit materialDepozit) {
        this.setMaterialDepozit(materialDepozit);
        return this;
    }

    public void setMaterialDepozit(StocDepozit materialDepozit) {
        this.materialDepozit = materialDepozit;
    }

    public List<ProdusFinit> getProduseFinite() {
        return this.produseFinite;
    }

    public void setProduseFinite(List<ProdusFinit> produsFinits) {
        if (this.produseFinite != null) {
            this.produseFinite.forEach(i -> i.setDepozit(null));
        }
        if (produsFinits != null) {
            produsFinits.forEach(i -> i.setDepozit(this));
        }
        this.produseFinite = produsFinits;
    }

    public Depozit produseFinites(List<ProdusFinit> produsFinits) {
        this.setProduseFinite(produsFinits);
        return this;
    }

    public Depozit addProduseFinite(ProdusFinit produsFinit) {
        this.produseFinite.add(produsFinit);
        produsFinit.setDepozit(this);
        return this;
    }

    public Depozit removeProduseFinite(ProdusFinit produsFinit) {
        this.produseFinite.remove(produsFinit);
        produsFinit.setDepozit(null);
        return this;
    }

    public NotaPredare getNotePredare() {
        return this.notePredare;
    }

    public void setNotePredare(NotaPredare notaPredare) {
        this.notePredare = notaPredare;
    }

    public Depozit notePredare(NotaPredare notaPredare) {
        this.setNotePredare(notaPredare);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Depozit)) {
            return false;
        }
        return id != null && id.equals(((Depozit) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Depozit{" +
            "id=" + getId() +
            ", denumireDepozit='" + getDenumireDepozit() + "'" +
            ", materialDepozit='" + getMaterialDepozit() + "'" +
            "}";
    }
}
