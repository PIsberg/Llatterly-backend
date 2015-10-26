package com.google.devrel.training.conference.spi;

import static com.google.devrel.training.conference.service.OfyService.ofy;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;
import com.google.devrel.training.conference.Constants;
import com.google.devrel.training.conference.domain.VideoData;
import com.google.devrel.training.conference.form.VideoDataForm;
import com.googlecode.objectify.Key;

/**
 * Defines Latterly APIs.
 */
@Api(name = "latterly", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
        Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, description = "API for the Latterly Android application.")
public class ConferenceApi {
	
	
    @ApiMethod(name = "deleteVideoData", path = "videodata/{id}", httpMethod = HttpMethod.DELETE)
    public VideoData deleteVideoData(final User user, @Named("id") final String id) throws NotFoundException{ 
    	
        Key key = Key.create(VideoData.class, id);
        VideoData videoData = (VideoData) ofy().load().key(key).now();
        
        if (videoData == null) {
            throw new NotFoundException("No video found with video id: " + id);
        }
    	
    	 ofy().delete().entity(videoData).now();
    	 
    	 return videoData;
    }


    @ApiMethod(name = "saveVideoData", path = "videodata/{id}", httpMethod = HttpMethod.POST)
    public VideoData saveVideoData(final User user, @Named("id") final String id, VideoDataForm videoDataForm)  { //throws UnauthorizedException

    	//TODO: input validation
    	//TODO: check if already exists
    	
    	String videoId = id;
    	String youtubeId = videoDataForm.getYoutubeId();
    	long startTime = videoDataForm.getStartTime();
    	long pauseTime = videoDataForm.getPauseTime();
    	long stopTime = videoDataForm.getStopTime();
    	int correctAnswer = videoDataForm.getCorrectAnswer();
    	String question = videoDataForm.getQuestion();
    	String answer1 = videoDataForm.getAnswer1();
    	String answer2 = videoDataForm.getAnswer2();
    	String answer3 = videoDataForm.getAnswer3();
    	String answer4 = videoDataForm.getAnswer4();
    	
    	VideoData videoData = new VideoData(videoId, youtubeId, startTime, pauseTime, stopTime,
    			correctAnswer, question, answer1, answer2,
    			answer3, answer4);
    	
    	
        ofy().save().entity(videoData).now();

        return videoData;
    }
    

    /**
     * Returns a Profile object associated with the given user object. The cloud
     * endpoints system automatically inject the User object.
     *
     * @param user
     *            A User object injected by the cloud endpoints.
     * @return Profile object.
     * @throws UnauthorizedException
     *             when the User object is null.
     * @throws NotFoundException 
     */
    @ApiMethod(name = "getVideoData", path = "videodata/{id}", httpMethod = HttpMethod.GET)
    public VideoData getVideoData(final User user, @Named("id") final String id)  throws NotFoundException { //throws UnauthorizedException,
//        if (user == null) {
//            throw new UnauthorizedException("Authorization required");
//        }
        
        Key key = Key.create(VideoData.class, id);
        VideoData videoData = (VideoData) ofy().load().key(key).now();
        
        if (videoData == null) {
            throw new NotFoundException("No video found with video id: " + id);
        }
        
        return videoData;
    }
}
