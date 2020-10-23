/*
 * Copyright (c) 2020 Wasiq Bhamla
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.wasiqb.coteafs.datasource;

import static com.google.common.truth.Truth.assertWithMessage;
import static java.lang.System.getProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.wasiqb.coteafs.datasource.data.JsonTestData;
import com.github.wasiqb.coteafs.datasource.data.XmasFifthDay;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since Aug 29, 2020
 */
public class DataSourceJsonTest {
    /**
     * Test to read Json file using coteafs-datasource
     *
     * @param doe
     * @param ray
     * @param pi
     * @param frenchHens
     * @param callingBirds
     * @param xmasFifthDay
     * @param user
     *
     * @author Faisal Khatri
     * @since Aug 31, 2020
     */
    @Test (dataProvider = "testData")
    public void readingJsonFileTest (final String doe, final String ray, final float pi, final int frenchHens,
        final String[] callingBirds, final XmasFifthDay xmasFifthDay, final String user) {
        assertWithMessage ("doe").that (doe)
            .isNotEmpty ();
        assertWithMessage ("ray").that (ray)
            .isNotEmpty ();
        assertWithMessage ("pi").that (pi)
            .isNonZero ();
        assertWithMessage ("frenchHens").that (frenchHens)
            .isNotNull ();
        assertWithMessage ("callingBirds").that (callingBirds)
            .isNotEmpty ();
        assertWithMessage ("xmasFifthDay").that (xmasFifthDay)
            .isNotNull ();
        assertWithMessage ("user").that (user)
            .isEqualTo (getProperty ("user.name"));
    }

    /**
     * @return testdata
     *
     * @author Faisal Khatri
     * @since Aug 31, 2020
     */
    @DataProvider
    public Iterator<Object[]> testData () {
        final JsonTestData testData = DataSource.parse (JsonTestData.class);
        final List<Object[]> data = new ArrayList<> ();
        data.add (new Object[] { testData.getDoe (), testData.getRay (), testData.getPi (), testData.getFrenchHens (),
            testData.getCallingBirds (), testData.getXmasFifthDay (), testData.getUser () });
        return data.iterator ();
    }
}