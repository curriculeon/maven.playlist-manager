package com.github.curriculeon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlaylistManager {
    private Playlist list;

    public PlaylistManager(String[] songs) {
        list = new Playlist(songs);

    }

    public PlaylistManager(List<String> songs) {

        list = new Playlist(songs.toArray(new String[0]));
    }

    public PlaylistManager() {
        list = new Playlist(new String[0]);
    }

    public Playlist getPlaylist() {
        return list;
    }

    public void setPlaylist(Playlist playlist) {
        if (playlist == null) throw new IllegalArgumentException();
        list = playlist;

    }

    private void setPlaylist(String[] toArray) {
        list = new Playlist(toArray);
    }

    public void addSong(String songToAdd) {
        ArrayList<String> newList = new ArrayList<String>();
        Collections.addAll(newList, list.getSongNameArray());
        newList.add(songToAdd);
        setPlaylist(newList.toArray(new String[0]));
    }

    public void removeSong(String songToRemove) {
        if(list.getSongNameArray().length == 0){
            throw new IllegalArgumentException();
        }
        ArrayList<String> newList = new ArrayList<String>();
        Collections.addAll(newList, list.getSongNameArray());
        newList.remove(songToRemove);
        setPlaylist(newList.toArray(new String[0]));

    }


    public void printAll() {
        System.out.println(Arrays.toString(list.getSongNameArray()));
    }
}
