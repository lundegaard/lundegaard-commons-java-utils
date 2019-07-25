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

/**
 * ApplicationException is used as base exception thrown by Lundegaard
 * applications.
 *
 * The Exception allows you to set additional error code for further
 * investigation of the problem or for better UI responses to the user.
 *
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public class ApplicationException extends RuntimeException {

    /**
     * Error code of the application. This code can be used for further
     * investigation of the problem, formal recognition of the errors or for
     * displaying more specific info to the user.
     */
    protected ApplicationExceptionCode code = null;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message, ApplicationExceptionCode code) {
        super(message);
        this.code = code;
    }

    public ApplicationException(String message, Throwable cause, ApplicationExceptionCode code) {
        super(message, cause);
        this.code = code;
    }

    public ApplicationExceptionCode getCode() {
        return code;
    }

    public void setCode(ApplicationExceptionCode code) {
        this.code = code;
    }

}
