package com.github.wasiqb.coteafs.datasource;

import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;
import static java.text.MessageFormat.format;

import com.github.wasiqb.coteafs.datasource.parser.IDataSource;
import com.github.wasiqb.coteafs.datasource.parser.JsonDataSource;
import com.github.wasiqb.coteafs.datasource.parser.PropertiesDataSource;
import com.github.wasiqb.coteafs.datasource.parser.XmlDataSource;
import com.github.wasiqb.coteafs.datasource.parser.YamlDataSource;
import com.github.wasiqb.coteafs.datasource.utils.DataFileUtil;
import com.github.wasiqb.coteafs.error.OperationNotSupportedError;

public class DataSource {
    public <T> T parse (final Class<T> dataClass) {
        final DataFileUtil<T> dataFile = new DataFileUtil<> (dataClass);
        final String fileName = dataFile.getFileName ();
        final String extension = fileName.substring (fileName.lastIndexOf ('.') + 1);
        IDataSource dataSource = null;
        switch (extension.toLowerCase ()) {
            case "yaml":
            case "yml":
                dataSource = new YamlDataSource ();
                break;
            case "json":
                dataSource = new JsonDataSource ();
                break;
            case "properties":
                dataSource = new PropertiesDataSource ();
                break;
            case "xml":
                dataSource = new XmlDataSource ();
                break;
            default:
                fail (OperationNotSupportedError.class,
                    format ("This data file format [{0}] is not supported.", extension));
        }
        return dataSource.parse (dataFile.getPath (), dataClass);
    }
}