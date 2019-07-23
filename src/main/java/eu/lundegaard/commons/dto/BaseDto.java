/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.dto;

import eu.lundegaard.commons.iface.Identifiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTOs are used as output from services.
 *
 * This class should be used as parent of all the DTOs. We assume, that every
 * DTO is identifiable and serializable. Based on it's identification (usually
 * ID from DB entity) there is implementation of standard methods
 * {@code equals}, {@code hashCode} and {@code toString}.
 *
 * @param <I> Type of DTO's identificator
 *
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public abstract class BaseDto<I extends Serializable> implements Identifiable<I>, Serializable {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseDto<?> dto = (BaseDto<?>) o;

        return getId().equals(dto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + getId() + ")";
    }
}
