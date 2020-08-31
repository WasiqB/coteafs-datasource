package com.github.wasiqb.coteafs.datasource.data;

import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import lombok.Data;

/**
 * @author Faisal Khatri
 * @since Aug 31, 2020
 *
 */
@Data
@DataFile ( folderPath = "src\\test\\resources\\files\\xmlfiles", fileName = "testfile.xml")
public class XmlData {
    
    private String to;
    private String from;
    private String heading;
    private String body;
}
