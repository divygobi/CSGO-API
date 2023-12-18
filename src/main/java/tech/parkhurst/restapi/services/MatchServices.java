package tech.parkhurst.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import tech.parkhurst.restapi.entities.HltvMatch;
import org.springframework.stereotype.Service;
import tech.parkhurst.restapi.repositories.MatchRepo;

import java.util.List;

@Service
public class MatchServices {

    @Autowired
    private MatchRepo MatchRepository;

    public List<String> getIDList(){
        return MatchRepository.findAllIds();
    }

    /**
     * @return returns all the data from the specified table(hltv_match)
     */
    public List<HltvMatch> getUserList() {
        return MatchRepository.findAll();
    }

    /**
     * @param num number of results desired
     * @return list of matches size-limited by parameter num
     */

    public List<HltvMatch> findTopNMatches(int num) {
        return MatchRepository.findAllTopN(num);
    }


    /**
     * @param id our match id generated by hltv
     * @return the match data with the matching id
     */
    public HltvMatch getMatchById(String id) {
        return MatchRepository.findById(id).orElse(null);
    }


    /**
     * @param competition Name of the competition we want to search for
     * @return a list of matches at that specific competition or an empty list if not found
     */
    public List<HltvMatch> getComp(String competition) {
        return MatchRepository.findByCompetitionIsIgnoreCase(competition);
    }

    /**
     * @param name Team name you want to look up
     * @return A list of matches the specified team played
     */
    public List<HltvMatch> findTeam(String name) {
        return MatchRepository.findByTeamAIgnoreCaseOrTeamBIgnoreCase(name, name);
    }

    /**
     * @param typeofmatch The specific kind of match(bo3,bo5,trn(train))
     * @return a list of matches that have tht type of match(all bo3 matches)
     */
    public List<HltvMatch> gatherType(String typeofmatch) {
        return MatchRepository.findByTypeofmatchIgnoreCase(typeofmatch);
    }

    /**
     * @param match is an HltvMatch object that we add to our db
     * @return
     */
    public HltvMatch createMatch(HltvMatch match) {
        return MatchRepository.save(match);
    }
}
