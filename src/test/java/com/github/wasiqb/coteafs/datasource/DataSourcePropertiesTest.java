package com.github.wasiqb.coteafs.datasource;

import static com.google.common.truth.Truth.assertWithMessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.wasiqb.coteafs.datasource.data.PropertiesData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since Aug 31, 2020
 */
public class DataSourcePropertiesTest {

    /**
     * @author Faisal Khatri
     * @since Aug 31, 2020
     * @return testdata
     */
    @DataProvider
    public Iterator<Object []> testData () {
        final PropertiesData testData = DataSource.parse (PropertiesData.class);
        final List<Object []> data = new ArrayList<> ();
        data.add (new Object [] { testData.getTesturl (), testData.getUsername (), testData.getPort () });
        return data.iterator ();
    }

    /**
     * Test to read Properties file using coteafs-datasource
     *
     * @author Faisal Khatri
     * @since Aug 31, 2020
     * @param testUrl
     * @param userName
     * @param port
     */
    @Test (dataProvider = "testData")
    public void readingPropertiesFileTest (String testUrl, String userName, int port) {

        assertWithMessage ("testurl").that (testUrl)
            .isNotEmpty ();
        assertWithMessage ("username").that (userName)
            .isNotEmpty ();
        assertWithMessage ("port").that (port)
            .isNotNull ();

    }

}
