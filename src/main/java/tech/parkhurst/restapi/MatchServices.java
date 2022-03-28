package tech.parkhurst.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import tech.parkhurst.restapi.entities.HltvMatch;
import org.springframework.stereotype.Service;
import tech.parkhurst.restapi.repositories.MatchRepo;

import java.util.List;

@Service
public class MatchServices {

    @Autowired
    private MatchRepo MatchRepository;


    /**
        @return  returns all the data from the specified table(hltv_match)
     */
    public List<HltvMatch> getUserList() {
        return MatchRepository.findAll();
    }

    /**
     * @param id our match id generated by hltv
     * @return the match data with the matching id
     */
    public HltvMatch getMatchById(int id) {
        return MatchRepository.findById(id).orElse(null);
    }

    /**
     * @param competition Name of the competition we want to search for
     * @return a list of matches at that specific competition or an empty list if not found
     */
    public List<HltvMatch> getComp(String competition){
        return MatchRepository.findByCompetitionIsIgnoreCase(competition);
    }

    public List<HltvMatch> findA(String name){
        return MatchRepository.findByTeamA(name);
    }
}
