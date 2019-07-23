/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.iface;

import java.io.Serializable;

/**
 * Object with this interface is identifiable by unique I of given type.
 * 
 * @param <I> Type of the I for identification.
 *
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public interface Identifiable<I extends Serializable> {

    /**
     * @return the unique I of an object
     */
    I getId();

}
