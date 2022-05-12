package com.proiectmvc.demo.document;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Document.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "data_eliberare")
    private LocalDate dataEliberare;

    @Column(name = "data_intocmire")
    private LocalDate dataIntocmire;

    @Column(name = "nr_document")
    private Integer nrDocument;

    public Document( LocalDate dataEliberare, LocalDate dataIntocmire, Integer nrDocument) {
        this.dataEliberare = dataEliberare;
        this.dataIntocmire = dataIntocmire;
        this.nrDocument = nrDocument;
    }

    public Document() {
    }
// jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Document id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEliberare() {
        return this.dataEliberare;
    }

    public Document dataEliberare(LocalDate dataEliberare) {
        this.setDataEliberare(dataEliberare);
        return this;
    }

    public void setDataEliberare(LocalDate dataEliberare) {
        this.dataEliberare = dataEliberare;
    }

    public LocalDate getDataIntocmire() {
        return this.dataIntocmire;
    }

    public Document dataIntocmire(LocalDate dataIntocmire) {
        this.setDataIntocmire(dataIntocmire);
        return this;
    }

    public void setDataIntocmire(LocalDate dataIntocmire) {
        this.dataIntocmire = dataIntocmire;
    }

    public Integer getNrDocument() {
        return this.nrDocument;
    }

    public Document nrDocument(Integer nrDocument) {
        this.setNrDocument(nrDocument);
        return this;
    }

    public void setNrDocument(Integer nrDocument) {
        this.nrDocument = nrDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Document)) {
            return false;
        }
        return id != null && id.equals(((Document) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Document{" +
            "id=" + getId() +
            ", dataEliberare='" + getDataEliberare() + "'" +
            ", dataIntocmire='" + getDataIntocmire() + "'" +
            ", nrDocument=" + getNrDocument() +
            "}";
    }
}
