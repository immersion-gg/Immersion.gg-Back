package com.immersion.riot.spectator.infra;
import com.immersion.riot.config.RiotFeignConfiguration;
import com.immersion.riot.spectator.app.SpectatorQueryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "spectator", configuration = RiotFeignConfiguration.class, url = "${riot.api.url.kr}")

public interface SpectatorClient {
    @GetMapping("/lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}")
    SpectatorQueryResponse getSpectator(@PathVariable String encryptedSummonerId);
}