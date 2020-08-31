package com.github.wasiqb.coteafs.datasource.data;

import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import lombok.Data;

/**
 * @author Faisal Khatri
 * @since Aug 31, 2020
 *
 */
@Data
@DataFile (fileName = "config.properties", folderPath = "src\\test\\resources\\properties_file")

public class PropertiesData {

    private String testurl;
    private String username;
    private int port;
}
