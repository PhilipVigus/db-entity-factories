package com.philvigus.dbentityfactories.testfixtures.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Child entity class used by tests for this library.
 */
@Entity
@Getter
@Setter
public class ChildEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "parent_id")
    private ParentEntity parent;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ChildEntity that = (ChildEntity) o;

        return Objects.equals(id, that.id) && Objects.equals(this.getParent(), that.getParent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parent);
    }
}
