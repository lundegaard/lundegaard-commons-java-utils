/*
 * Copyright (C) 2019 Lundegaard a.s., All Rights Reserved
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; version 3.0 of the License.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * https://www.gnu.org/licenses/lgpl-3.0.html
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
