package com.github.wasiqb.coteafs.datasource.data;

import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import lombok.Data;

/**
 * @author Faisal Khatri
 * @since Aug 29, 2020
 *
 */
@Data
@DataFile(fileName = "SampleFile.yaml")
public class SampleFile {
  
    private String doe;
    private String ray;
    private float pi;
    private boolean xmas;
    private int frenchhens;
    private String [] callingBirds;
    private XmasFifthDay XmasFifthDay;


}
