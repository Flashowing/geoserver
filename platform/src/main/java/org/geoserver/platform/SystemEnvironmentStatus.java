/* (c) 2016 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */

package org.geoserver.platform;

import java.util.Map.Entry;
import java.util.Optional;

/** Report system environment details to server status page. */
public class SystemEnvironmentStatus implements ModuleStatus {

    @Override
    public String getModule() {
        return "system-environment";
    }

    @Override
    public Optional<String> getComponent() {
        return Optional.ofNullable(System.getProperty("os.name"));
    }

    @Override
    public String getName() {
        return "System Environment";
    }

    @Override
    public Optional<String> getVersion() {
        return Optional.ofNullable(System.getProperty("os.version"));
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Optional<String> getMessage() {
        StringBuffer result = new StringBuffer();
        for (Entry<String, String> entry : System.getenv().entrySet()) {
            result.append(entry.getKey().toString() + "=" + entry.getValue().toString() + "\n");
        }
        return Optional.ofNullable(result.toString());
    }

    @Override
    public Optional<String> getDocumentation() {
        return Optional.empty();
    }
}
