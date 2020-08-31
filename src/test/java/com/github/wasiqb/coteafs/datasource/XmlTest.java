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
public class XmlTest {

    /**
     * @author Faisal Khatri
     * @since Aug 31, 2020
     * @return testdata
     */
    @Test
    @DataProvider
    public Iterator<Object []> testData () {
        final XmlData testData = DataSource.parse (XmlData.class);
        final List<Object []> data = new ArrayList<> ();
        data.add (
            new Object [] { testData.getTo (), testData.getFrom (), testData.getHeading (), testData.getBody () });
        return data.iterator ();
    }

    /**
     * Test to read Json file using coteafs-datasource
     *
     * @author Faisal Khatri
     * @since Aug 31, 2020
     * @param to
     * @param from
     * @param heading
     * @param body
     */
    @Test (dataProvider = "testData")
    public void readingXmlFile (String to, String from, String heading, String body) {

        System.out.println ("Starting xml test...");
        assertWithMessage ("to").that (to)
            .isNotEmpty ();
        assertWithMessage ("from").that (from)
            .isNotEmpty ();
        assertWithMessage ("heading").that (heading)
            .isNotEmpty ();
        assertWithMessage ("body").that (body)
            .isNotEmpty ();

        System.out.println ("Value of To: " + to);
        System.out.println ("Value of From: " + from);
        System.out.println ("Value of Heading: " + heading);
        System.out.println ("Value of Body: " + body);

    }

}
