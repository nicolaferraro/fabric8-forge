/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.forge.addon.utils;

import io.fabric8.utils.Strings;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 */
public class MavenHelpersTest {
    @Test
    public void testVersions() throws Exception {
        assertVersionFound("junit", "junit");
        assertVersionFound("org.apache.maven.plugins", "maven-surefire-plugin");
        assertVersionFound("io.fabric8", "fabric8-maven-plugin");
        assertVersionFound("io.fabric8.archetypes", "archetypes-catalog");
        assertVersionFound("io.hawt", "hawtio-maven-plugin");
        assertVersionFound("org.jolokia", "docker-maven-plugin");
    }

    public static void assertVersionFound(String groupId, String artifactId) {
        String version = MavenHelpers.getVersion(groupId, artifactId);
        System.out.println("Found " + groupId + ":" + artifactId + " = version: " + version);
        assertTrue("No version found for " + groupId + ":" + artifactId, Strings.isNotBlank(version));
        assertFalse("Version includes '$' for " + groupId + ":" + artifactId, version.contains("$"));
    }

}
