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
package eu.lundegaard.commons.exception;

import java.io.Serializable;

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
