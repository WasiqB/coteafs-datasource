package com.github.wasiqb.coteafs.datasource.data;

import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import lombok.Data;

/**
 * @author Faisal Khatri
 * @since Aug 31, 2020
 */
@Data
@DataFile
public class JsonTestData {

    private String       doe;
    private String       ray;
    private float        pi;
    private boolean      xmas;
    private int          frenchHens;
    private String []    callingBirds;
    private XmasFifthDay XmasFifthDay;

}
