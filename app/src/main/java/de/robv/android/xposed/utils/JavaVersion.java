/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.robv.android.xposed.utils;

import androidx.annotation.NonNull;

/**
 * <p>An enum representing all the versions of the Java specification.
 * This is intended to mirror available values from the
 * <em>java.specification.version</em> System property. </p>
 *
 * @since 3.0
 * @version $Id: $
 */
public enum JavaVersion {
    /**
     * The Java version reported by Android. This is not an official Java version number.
     */
    JAVA_0_9(1.5f, "0.9"),
    
    /**
     * Java 1.1.
     */
    JAVA_1_1(1.1f, "1.1"),

    /**
     * Java 1.2.
     */
    JAVA_1_2(1.2f, "1.2"),

    /**
     * Java 1.3.
     */
    JAVA_1_3(1.3f, "1.3"),

    /**
     * Java 1.4.
     */
    JAVA_1_4(1.4f, "1.4"),

    /**
     * Java 1.5.
     */
    JAVA_1_5(1.5f, "1.5"),

    /**
     * Java 1.6.
     */
    JAVA_1_6(1.6f, "1.6"),

    /**
     * Java 1.7.
     */
    JAVA_1_7(1.7f, "1.7"),

    /**
     * Java 1.8.
     */
    JAVA_1_8(1.8f, "1.8");

    /**
     * The float value.
     */
    private final float value;
    /**
     * The standard name.
     */
    private final String name;

    /**
     * Constructor.
     *
     * @param value  the float value
     * @param name  the standard name, not null
     */
    JavaVersion(final float value, final String name) {
        this.value = value;
        this.name = name;
    }

    // -----------------------------------------------------------------------
    /**
     * <p>Whether this version of Java is at least the version of Java passed in.</p>
     *
     * <p>For example:<br />
     *  {@code myVersion.atLeast(JavaVersion.JAVA_1_4)}<p>
     *
     * @param requiredVersion  the version to check against, not null
     * @return true if this version is equal to or greater than the specified version
     */
    public boolean atLeast(JavaVersion requiredVersion) {
        return this.value >= requiredVersion.value;
    }

    /**
     * Transforms the given string with a Java version number to the
     * corresponding constant of this enumeration class. This method is used
     * internally.
     *
     * @return the corresponding enumeration constant or <b>null</b> if the
     * version is unknown
     */
    static JavaVersion get() {
        if ("0.9".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_0_9;
        } else if ("1.1".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_1;
        } else if ("1.2".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_2;
        } else if ("1.3".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_3;
        } else if ("1.4".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_4;
        } else if ("1.5".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_5;
        } else if ("1.6".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_6;
        } else if ("1.7".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_7;
        } else if ("1.8".equals(SystemUtils.JAVA_SPECIFICATION_VERSION)) {
            return JAVA_1_8;
        }
        return null;
    }

    // -----------------------------------------------------------------------
    /**
     * <p>The string value is overridden to return the standard name.</p>
     *
     * <p>For example, <code>"1.5"</code>.</p>
     *
     * @return the name, not null
     */
    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
