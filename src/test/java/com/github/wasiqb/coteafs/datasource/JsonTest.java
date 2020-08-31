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
public class JsonTest {

    /**
     * @author Faisal Khatri
     * @since Aug 31, 2020
     * @return testdata
     */
    @Test
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
    public void readingJsonFile (String doe, String ray, float pi, int frenchHens, String [] callingBirds,
        XmasFifthDay xmasFifthDay) {
        System.out.println ("Starting Json test...");
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

        System.out.println ("Value of Doe: " + doe);
        System.out.println ("Value of Ray: " + ray);
        System.out.println ("Value of Pi: " + pi);
        System.out.println ("Value of CallingBirds first value: " + callingBirds [0]);
        System.out.println ("Value of frenchHens:" + frenchHens);
        System.out.println ("Value of Xmas Fifth Day: " + xmasFifthDay);

    }

}
