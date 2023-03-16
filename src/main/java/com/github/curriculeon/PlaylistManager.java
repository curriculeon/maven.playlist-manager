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
        String [] son = new String[songs.size()];
        for (int x = 0; x<songs.size(); x++){
            son[x] = songs.get(x);
        }
        list = new Playlist(son);
    }

    public PlaylistManager() {
        list = new Playlist(new String[0]);
    }

    public Playlist getPlaylist() {
        return list;
    }

    public void setPlaylist(Playlist playlist) {
        list = playlist;

    }

    private void setPlaylist(String[] toArray) {
        list = new Playlist(toArray);
    }

    public void addSong(String songToAdd) {
        ArrayList<String> newList = new ArrayList<String>();
        Collections.addAll(newList, list.getSongNameArray());
        newList.add(songToAdd);
        list = new Playlist(newList.toArray(new String[0]));
    }

    public void removeSong(String songToRemove) {
        ArrayList<String> newList = new ArrayList<String>();
        Collections.addAll(newList, list.getSongNameArray());
        newList.remove(songToRemove);
        list = new Playlist(newList.toArray(new String[0]));

    }


    public void printAll() {
        System.out.println(Arrays.toString(list.getSongNameArray()));
    }
}
