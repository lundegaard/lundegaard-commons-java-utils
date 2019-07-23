/*
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertNull;

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
public class SimpleTemplateUtilTest {

    @Test
    public void testProcessTemplate_Nulls() throws Exception {
        assertNull(SimpleTemplateUtil.processTemplate(null, null));
        assertNull(SimpleTemplateUtil.processTemplate(null, emptyMap()));
        assertNull(SimpleTemplateUtil.processTemplate("", null));
    }

    @Test
    public void testProcessTemplate_Empty() throws Exception {
        Assert.assertEquals("", SimpleTemplateUtil.processTemplate("", emptyMap()));
    }

    @Test
    public void testProcessTemplate_Simple() throws Exception {
        Map<String, String> attrs = new HashMap<>();
        attrs.put("A", "aa");

        Assert.assertEquals("aa", SimpleTemplateUtil.processTemplate("###A###", attrs));
    }

    @Test
    public void testProcessTemplate_MissingAttr() throws Exception {
        Map<String, String> attrs = new HashMap<>();

        Assert.assertEquals("###A###", SimpleTemplateUtil.processTemplate("###A###", attrs));
    }

    @Test
    public void testProcessTemplate_MissingPlaceholder() throws Exception {
        Map<String, String> attrs = new HashMap<>();
        attrs.put("A", "aa");

        Assert.assertEquals("###B###", SimpleTemplateUtil.processTemplate("###B###", attrs));
    }

    @Test
    public void testProcessTemplate_Multivalue() throws Exception {
        Map<String, String> attrs = new HashMap<>();
        attrs.put("A", "aa");
        attrs.put("B", "bb");

        Assert.assertEquals("bb aa", SimpleTemplateUtil.processTemplate("###B### ###A###", attrs));
    }

}
