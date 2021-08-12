package net.ibxnjadev.kruby.core.redis;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.ibxnjadev.kruby.core.annotations.RouteFile;

@RouteFile(
        route = "redis.json"
)
@JsonDeserialize(as = CoreRedisConfiguration.class)
public interface RedisConfiguration {

    /**
     * @return The host
     */

    String getHost();

    /**
     * @return The port
     */

    int getPort();

    /**
     * @return The password
     */

    String getPassword();

}
