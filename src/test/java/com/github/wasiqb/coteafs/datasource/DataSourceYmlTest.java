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

import com.github.wasiqb.coteafs.datasource.data.Login;
import com.github.wasiqb.coteafs.datasource.data.LoginData;
import com.github.wasiqb.coteafs.datasource.data.SampleFile;
import com.github.wasiqb.coteafs.datasource.data.XmasFifthDay;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Wasiq Bhamla
 * @since Aug 21, 2020
 */
public class DataSourceYmlTest {
    /**
     * @return test data
     *
     * @author Faisal Khatri
     * @since Aug 21, 2020
     */
    @DataProvider
    public Iterator<Object[]> getLoginDataYml () {
        final LoginData loginData = DataSource.parse (LoginData.class);
        final List<Object[]> data = new ArrayList<> ();
        loginData.getLoginData ()
            .forEach (d -> data.add (new Object[] { d }));
        return data.iterator ();
    }

    /**
     * Test to read Yaml file using coteafs-datasource
     *
     * @author Faisal Khatri
     * @since Aug 29, 2020
     */
    @Test (dataProvider = "testData")
    public void readingYamlFileTest (final String doe, final String ray, final float pi, final int frenchHens,
        final String[] callingBirds, final XmasFifthDay xmasFifthDay) {

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
    }

    /**
     * @return testdata
     *
     * @author Faisal Khatri
     * @since Aug 29, 2020
     */
    @DataProvider
    public Iterator<Object[]> testData () {
        final SampleFile testData = DataSource.parse (SampleFile.class);
        final List<Object[]> data = new ArrayList<> ();
        data.add (new Object[] { testData.getDoe (), testData.getRay (), testData.getPi (), testData.getFrenchhens (),
            testData.getCallingBirds (), testData.getXmasFifthDay () });
        return data.iterator ();
    }

    /**
     * @param login Login data
     *
     * @author Wasiq Bhamla
     * @since Aug 21, 2020
     */
    @Test (dataProvider = "getLoginDataYml")
    public void testYmlDataSource (final Login login) {
        assertWithMessage ("User Name").that (login.getUserName ())
            .isNotEmpty ();
        assertWithMessage ("Password").that (login.getPassword ())
            .isNotEmpty ();
        assertWithMessage ("Path").that (login.getPath ())
            .isEqualTo (getProperty ("user.dir"));
    }
}