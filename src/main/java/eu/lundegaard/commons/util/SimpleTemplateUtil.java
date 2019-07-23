/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
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
