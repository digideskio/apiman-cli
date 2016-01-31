/*
 * Copyright 2016 Pete Cornish
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apiman.cli.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.junit.Assert.*;

/**
 * Tests for {@link MappingUtil}.
 *
 * @author Pete Cornish {@literal <outofcoffee@gmail.com>}
 */
public class MappingUtilTest {
    private static final String INPUT_STRING = "This is a ${key.1} sample ${key.2} string.";

    @Test
    public void testResolvePlaceholders_Success() throws Exception {
        // test data
        final String original = INPUT_STRING;

        final List<String> replacements = Lists.newArrayList(
                "key.1=value.1",
                "key.2=value.2"
        );

        // test
        final String actual = MappingUtil.resolvePlaceholders(original, replacements);

        // assertions
        assertEquals("This is a value.1 sample value.2 string.", actual);
    }

    @Test
    public void testResolvePlaceholders_EmptyReplacements() throws Exception {
        // test data
        final String original = INPUT_STRING;

        final List<String> replacements = Lists.newArrayList();

        // test
        final String actual = MappingUtil.resolvePlaceholders(original, replacements);

        // assertions
        assertEquals(INPUT_STRING, actual);
    }

    @Test
    public void testResolvePlaceholders_NullReplacements() throws Exception {
        // test data
        final String original = INPUT_STRING;

        final List<String> replacements = null;

        // test
        final String actual = MappingUtil.resolvePlaceholders(original, replacements);

        // assertions
        assertEquals(INPUT_STRING, actual);
    }

    @Test
    public void testSafeWriteValueAsJson_Populated() throws Exception {
        // test data
        final Map<String, String> input = newHashMap();
        input.put("key", "value");

        // test
        final String actual = MappingUtil.safeWriteValueAsJson(input);

        // assertions
        assertEquals("{\n  \"key\" : \"value\"\n}", actual);
    }

    @Test
    public void testSafeWriteValueAsJson_Null() throws Exception {
        // test data
        final Map<String, String> input = null;

        // test
        final String actual = MappingUtil.safeWriteValueAsJson(input);

        // assertions
        assertEquals("null", actual);
    }
}