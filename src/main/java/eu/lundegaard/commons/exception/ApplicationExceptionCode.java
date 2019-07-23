/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.exception;

import java.io.Serializable;
import eu.lundegaard.commons.exception.ApplicationException;

/**
 * This interface for ApplicationException error codes.
 *
 * @see ApplicationException
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public interface ApplicationExceptionCode extends Serializable {

    /**
     * Returns the error code.
     * 
     * @return code
     */
    int getCode();

}
