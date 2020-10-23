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

package com.github.wasiqb.coteafs.datasource.parser;

import static com.github.wasiqb.coteafs.datasource.utils.StringUtils.interpolate;

import java.io.FileInputStream;

import com.google.common.base.CaseFormat;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.ScalarNode;

/**
 * Yaml data parser.
 *
 * @author Wasiq Bhamla
 * @since 19-08-2020
 */
public class YamlDataSource implements IDataSource {
    @SneakyThrows
    @Override
    public <T> T parse (final String path, final Class<T> dataClass) {
        try (final FileInputStream in = new FileInputStream (path)) {
            final Constructor constructor = new Constructor (dataClass) {
                @Override
                protected String constructScalar (final ScalarNode node) {
                    return interpolate (node.getValue ());
                }
            };
            final PropertyUtils propertyUtils = new PropertyUtils () {
                @Override
                public Property getProperty (final Class<?> obj, final String name) {
                    String propertyName = name;
                    if (propertyName.indexOf ('_') > -1) {
                        propertyName = CaseFormat.LOWER_UNDERSCORE.to (CaseFormat.LOWER_CAMEL, propertyName);
                    }
                    return super.getProperty (obj, propertyName);
                }
            };
            constructor.setPropertyUtils (propertyUtils);
            final Yaml yaml = new Yaml (constructor);
            return yaml.load (in);
        }
    }
}