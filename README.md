<p align="center">
  <a href="#">
    <img src="assets/coteafs-datasource-logo.jpg" width=300 padding=10 />
  </a>
</p>

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)][home]
[![Test](https://github.com/WasiqB/coteafs-datasource/actions/workflows/test.yml/badge.svg?branch=master)][actions]

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
<a aria-label="All Contributors" href="#contributors-"><img alt="" src="https://img.shields.io/badge/all_contributors-2-17BB8A.svg?style=for-the-badge&labelColor=000000"></a>
<!-- ALL-CONTRIBUTORS-BADGE:END -->

[![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/datasource.svg?style=for-the-badge)][maven]
[![Github Releases](https://img.shields.io/github/downloads/WasiqB/coteafs-datasource/total.svg?style=for-the-badge)][release]
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?style=for-the-badge)][license]

## Usage :running:

### Dependency

```xml

<dependency>
    <groupId>com.github.wasiqb.coteafs</groupId>
    <artifactId>datasource</artifactId>
    <version>1.2.0</version>
</dependency>
```

### Example

#### Pojo Classes

Pojo class for our data file `login-data.yml`.

```java
import java.util.List;

import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import lombok.Data;

@Data
@DataFile
public class LoginData {
    private List<Login> loginData;
}

@Data
public class Login {
    private String password;
    private String userName;
    private String path;
}
```

#### Data file content

Data for our Yml data file `login-data.yml`.

```yml
login_data:
  - user_name: WasiqB
    password: Admin
    path: ${sys:user.dir}
  - user_name: FaisalK
    password: Abcd
    path: ${sys:user.dir}
```

#### Parsing data file

Following is an example to convert data file into a TestNG data provider.

```java
import static com.google.common.truth.Truth.assertWithMessage;
import static java.lang.System.getProperty;

import com.github.wasiqb.coteafs.datasource.data.LoginData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSourceYmlTest {
    @DataProvider
    public Iterator<Object[]> getLoginDataYml () {
        final LoginData loginData = DataSource.parse (LoginData.class);
        final List<Object[]> data = new ArrayList<> ();
        loginData.getLoginData ()
            .forEach (d -> data.add (new Object[] { d }));
        return data.iterator ();
    }

    @Test (dataProvider = "getLoginDataYml")
    public void testYmlDataSource (final Login login) {
        assertWithMessage ("User Name").that (login.getUserName ())
            .isNotEmpty ();
        assertWithMessage ("Password").that (login.getPassword ())
            .isNotEmpty ();
        assertWithMessage ("Path").that (login.getPath ())
            .isEqualTo (getProperty ("user.dir"));
    }
}
```

#### Parsing placeholders in file field values

You can use placeholders in JSON and YML files. Following is the table of allowed variable formats which can be used in
the placeholder.

Desired value | Sample Placeholder
------------|------------
Base64 Decoder | `${base64Decoder:SGVsbG9Xb3JsZCE=}`
Base64 Encoder | `${base64Encoder:HelloWorld!}`
Java Constant | `${const:java.awt.event.KeyEvent.VK_ESCAPE}`
Date | `${date:yyyy-MM-dd}`
DNS | <code>${dns:address&#124;apache.org}</code>
Environment Variable | `${env:USERNAME}`
File Content | `${file:UTF-8:src/test/resources/document.properties}`
Java | `${java:version}`
Localhost | `${localhost:canonical-name}`
Properties File | `${properties:src/test/resources/document.properties::mykey}`
Resource Bundle | `${resourceBundle:org.example.testResourceBundleLookup:mykey}`
Script | `${script:javascript:3 + 4}`
System Property | `${sys:user.dir}`
URL Decoder | `${urlDecoder:Hello%20World%21}`
URL Encoder | `${urlEncoder:Hello World!}`
URL Content (HTTP) | `${url:UTF-8:http://www.apache.org}`
URL Content (HTTPS) | `${url:UTF-8:https://www.apache.org}`
URL Content (File) | `${url:UTF-8:file:///${sys:user.dir}/src/test/resources/document.properties}`
XML XPath | `${xml:src/test/resources/document.xml:/root/path/to/node}`

> Custom value is not supported in the placeholder.

## Contributors ✨

Thanks to these wonderful people ([emoji key][emojis]):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://wasiqb.github.io"><img src="https://avatars3.githubusercontent.com/u/9130909?v=4" width="100px;" alt=""/><br /><sub><b>Wasiq Bhamla</b></sub></a><br /><a href="https://github.com/WasiqB/coteafs-datasource/commits?author=WasiqB" title="Code">💻</a> <a href="https://github.com/WasiqB/coteafs-datasource/commits?author=WasiqB" title="Tests">⚠️</a> <a href="#infra-WasiqB" title="Infrastructure (Hosting, Build-Tools, etc)">🚇</a> <a href="https://github.com/WasiqB/coteafs-datasource/commits?author=WasiqB" title="Documentation">📖</a> <a href="#ideas-WasiqB" title="Ideas, Planning, & Feedback">🤔</a> <a href="#maintenance-WasiqB" title="Maintenance">🚧</a></td>
    <td align="center"><a href="https://mfaisalkhatri.github.io"><img src="https://avatars3.githubusercontent.com/u/18361917?v=4" width="100px;" alt=""/><br /><sub><b>Mohammad Faisal Khatri</b></sub></a><br /><a href="https://github.com/WasiqB/coteafs-datasource/commits?author=mfaisalkhatri" title="Tests">⚠️</a></td>
  </tr>
</table>

<!-- markdownlint-enable -->
<!-- prettier-ignore-end -->
<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors][contributors] specification. Contributions of any kind welcome!

[emojis]: https://allcontributors.org/docs/en/emoji-key
[contributors]: https://github.com/all-contributors/all-contributors
[home]: https://github.com/wasiqb/coteafs-config
[actions]: https://github.com/WasiqB/coteafs-datasource/actions/workflows/test.yml
[coverage]: https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Adatasource&metric=Coverage
[maven]: https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/datasource
[release]: https://github.com/WasiqB/coteafs-datasource/releases
[license]: https://opensource.org/licenses/Apache-2.0