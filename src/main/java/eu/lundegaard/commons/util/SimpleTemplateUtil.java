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
package eu.lundegaard.commons.util;

import java.util.Map;

/**
 * Simple template processing util which replaces all placeholders with actual
 * values.
 *
 * This class is ineffective and should not be used for high load scenarios
 * (then templating frameworks such as Velocity of Freemarker are more
 * suitable).
 *
 * The placeholders are in the template placed in ###PLACEHOLDER### form.
 *
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
@SuppressWarnings("WeakerAccess")
public final class SimpleTemplateUtil {

    private static final String KEY_PREFIX = "###";
    private static final String KEY_SUFFIX = "###";

    private SimpleTemplateUtil() {
        // private constructor for util class
    }

    public static String processTemplate(String template, Map<String, String> attributes) {
        if (template == null) {
            return null;
        }
        if (attributes == null) {
            return null;
        }

        String output = template;
        for (String key : attributes.keySet()) {
            output = output.replaceAll(KEY_PREFIX + key + KEY_SUFFIX, attributes.get(key));
        }

        return output;
    }

}
