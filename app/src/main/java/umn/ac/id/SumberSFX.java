package umn.ac.id;

import java.io.Serializable;

public class SumberSFX implements Serializable {
    private String judulsfx;
    private String genresfx;
    private String audioURI;
    private String deskripsisfx;

    public SumberSFX(String judulsfx, String genresfx, String audioURI, String deskripsisfx){
        this.judulsfx = judulsfx;
        this.genresfx = genresfx;
        this.audioURI = audioURI;
        this.deskripsisfx = deskripsisfx;
    }

    public String getJudulsfx() {
        return this.judulsfx;
    }
    public String getGenresfx() {
        return this.genresfx;
    }
    public String getAudioURI() {
        return this.audioURI;
    }

    public String getDeskripsisfx() {
        return deskripsisfx;
    }
    //    public void setJudul(String judulsfx){
//        this.judulsfx = judulsfx;
//    }
//    public void setGenresfx(String genresfx) {
//        this.genresfx = genresfx;
//    }
//    public void setAudioURI(String audioURI) {
//        this.audioURI = audioURI;
//    }

    public String toString() { return this.getJudulsfx() + " => " + this.getGenresfx(); }
}
