package com.github.curriculeon;


import java.util.Arrays;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {
    private String [] list;
    private int index;

    public Playlist(String[] songNameArray) {
        index = 0;
        list = songNameArray;
        //new Playlist(0, songNameArray);
    }

    public Playlist(int currentIndex, String[] songNameArray) {
        index = currentIndex;
        list = songNameArray;
    }

    public String[] getSongNameArray() {
        return list;
    }

    public String getCurrentSelection() {
        return list[index];
    }

    public void goToPreviousSong() {
        if (index == 0)
            index = list.length-1;
        else
            index --;
    }

    public void goToNextSong() {
        if(index == list.length-1){
            index = 0;
        }else
            index ++;
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {

        return Math.min(getForwardNumberOfStepsBetween(currentIndex, desiredSong), getBackwardNumberOfStepsBetween(currentIndex, desiredSong));
        //return Math.min(getNumberOfStepsBetween(currentIndex, desiredSong, this::goToNextSong),getNumberOfStepsBetween(currentIndex, desiredSong, this::goToPreviousSong) );
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        int count = 0;
        index = currentIndex;
        while(!getCurrentSelection().equals(desiredSong)){
            directionMutator.run();
            count++;
        }
        return count;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {

        return getNumberOfStepsBetween(currentIndex, desiredSong, this::goToNextSong);
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        return getNumberOfStepsBetween(currentIndex, desiredSong, this::goToPreviousSong);
    }
}
