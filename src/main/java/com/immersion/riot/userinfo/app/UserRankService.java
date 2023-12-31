package com.immersion.riot.userinfo.app;

import com.immersion.riot.userinfo.infra.client.UserInfoClient;
import com.immersion.riot.userinfo.infra.dto.LeagueEntryDTO;
import com.immersion.riot.userinfo.infra.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRankService {

    private final UserInfoClient userInfoClient;

    public LeagueEntryResponse getUserSoloRank(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        List<LeagueEntryDTO> summonerLeague = userInfoClient.getSummonerLeague(summonerDTO.id());
        LeagueEntryResponse soloRank = new LeagueEntryResponse();

        for (LeagueEntryDTO league : summonerLeague) {
            if(league.queueType().equals("RANKED_SOLO_5x5")) {
                soloRank.setQueueType(league.queueType());
                soloRank.setRank(league.rank());
                soloRank.setTier(league.tier());
                soloRank.setLeaguePoints(league.leaguePoints());
            }
        }

        if(soloRank.getQueueType() == null) {
            soloRank.setQueueType("RANKED_SOLO_5x5");
            soloRank.setRank(null);
            soloRank.setTier("Unranked");
            soloRank.setLeaguePoints(0);
        }

        return soloRank;
    }

    public LeagueEntryResponse getUserFlexRank(String summonerName) {
        SummonerDTO summonerDTO = userInfoClient.getSummoner(summonerName);
        List<LeagueEntryDTO> summonerLeague = userInfoClient.getSummonerLeague(summonerDTO.id());
        LeagueEntryResponse flexRank = new LeagueEntryResponse();

        for (LeagueEntryDTO league : summonerLeague) {
            if(league.queueType().equals("RANKED_FLEX_SR")) {
                flexRank.setQueueType(league.queueType());
                flexRank.setRank(league.rank());
                flexRank.setTier(league.tier());
                flexRank.setLeaguePoints(league.leaguePoints());
            }
        }

        if(flexRank.getQueueType() == null) {
            flexRank.setQueueType("RANKED_FLEX_SR");
            flexRank.setRank(null);
            flexRank.setTier("Unranked");
            flexRank.setLeaguePoints(0);
        }

        return flexRank;
    }
}
