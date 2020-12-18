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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.wasiqb.coteafs.datasource.data.XmlData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since Aug 31, 2020
 */
public class DataSourceXmlTest {
    /**
     * Test to read Json file using coteafs-datasource
     *
     * @author Faisal Khatri
     * @since Aug 31, 2020
     */
    @Test (dataProvider = "testData")
    public void readingXmlFileTest (final String to, final String from, final String heading, final String body) {
        assertWithMessage ("to").that (to)
            .isNotEmpty ();
        assertWithMessage ("from").that (from)
            .isNotEmpty ();
        assertWithMessage ("heading").that (heading)
            .isNotEmpty ();
        assertWithMessage ("body").that (body)
            .isNotEmpty ();
    }

    /**
     * @return testdata
     *
     * @author Faisal Khatri
     * @since Aug 31, 2020
     */
    @DataProvider
    public Iterator<Object[]> testData () {
        final XmlData testData = DataSource.parse (XmlData.class);
        final List<Object[]> data = new ArrayList<> ();
        data.add (new Object[] { testData.getTo (), testData.getFrom (), testData.getHeading (), testData.getBody () });
        return data.iterator ();
    }
}