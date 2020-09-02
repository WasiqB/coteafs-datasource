package com.github.wasiqb.coteafs.datasource;

import static com.google.common.truth.Truth.assertWithMessage;

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
     * @author Faisal Khatri
     * @since Aug 31, 2020
     * @return testdata
     */
    @DataProvider
    public Iterator<Object []> testData () {
        final JsonTestData testData = DataSource.parse (JsonTestData.class);
        final List<Object []> data = new ArrayList<> ();
        data.add (new Object [] { testData.getDoe (), testData.getRay (), testData.getPi (), testData.getFrenchHens (),
            testData.getCallingBirds (), testData.getXmasFifthDay () });
        return data.iterator ();
    }

    /**
     * Test to read Json file using coteafs-datasource
     *
     * @author Faisal Khatri
     * @param doe
     * @param ray
     * @param pi
     * @param frenchHens
     * @param callingBirds
     * @param xmasFifthDay
     * @since Aug 31, 2020
     */
    @Test (dataProvider = "testData")
    public void readingJsonFileTest (String doe, String ray, float pi, int frenchHens, String [] callingBirds,
        XmasFifthDay xmasFifthDay) {
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

}
