/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class Movie {
    
//    	[id] [int] IDENTITY(1,1) NOT NULL,
//	[title] [nvarchar](250) NULL,
//	[overview] [nvarchar](max) NULL,
//	[poster] [nvarchar](250) NULL,
//	[backdrop] [nvarchar](250) NULL,
//	[vote_average] [float] NULL,
//	[vote_count] [int] NULL,
//	[views] [int] NULL,
//	[runtime] [int] NULL,
//	[release_date] [datetime] NULL,
//	[create_at] [datetime] NULL,
//	[video_link] [nvarchar](max) NULL,
//	[quality] [nchar](10) NULL,
//	[category] [nvarchar](250) NULL,
    
    int id,index;
    String title;
    String overview;
    String poster;
    String backdrop;
    float vote_average;
    int vote_count;
    int view;
    int runtime;
    String release_date;
    String create_at;
    String video_link;
    String quality;
    String category;
    int producerid;
    int directorid;

    public Movie() {
    }

    public Movie(int id, String title, String overview, String poster, String backdrop, float vote_average, int vote_count, int view, int runtime, String release_date, String create_at, String video_link, String quality, String category) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster = poster;
        this.backdrop = backdrop;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.view = view;
        this.runtime = runtime;
        this.release_date = release_date;
        this.create_at = create_at;
        this.video_link = video_link;
        this.quality = quality;
        this.category = category;
    }

    public Movie(int id, int index, String title, String overview, String poster, String backdrop, float vote_average, int vote_count, int view, int runtime, String release_date, String create_at, String video_link, String quality, String category) {
        this.id = id;
        this.index = index;
        this.title = title;
        this.overview = overview;
        this.poster = poster;
        this.backdrop = backdrop;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.view = view;
        this.runtime = runtime;
        this.release_date = release_date;
        this.create_at = create_at;
        this.video_link = video_link;
        this.quality = quality;
        this.category = category;
    }

    public Movie(int id, int index, String title, String overview, String poster, String backdrop, float vote_average, int vote_count, int view, int runtime, String release_date, String create_at, String video_link, String quality, String category, int producerid, int directorid) {
        this.id = id;
        this.index = index;
        this.title = title;
        this.overview = overview;
        this.poster = poster;
        this.backdrop = backdrop;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.view = view;
        this.runtime = runtime;
        this.release_date = release_date;
        this.create_at = create_at;
        this.video_link = video_link;
        this.quality = quality;
        this.category = category;
        this.producerid = producerid;
        this.directorid = directorid;
    }

    public int getProducerid() {
        return producerid;
    }

    public void setProducerid(int producerid) {
        this.producerid = producerid;
    }

    public int getDirectorid() {
        return directorid;
    }

    public void setDirectorid(int directorid) {
        this.directorid = directorid;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster.substring(0);
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop.substring(0);
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getRelease_date() {
        return release_date.substring(0, 10);
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getCreate_at() {
        return create_at.substring(0, 10);
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", index=" + index + ", title=" + title + ", overview=" + overview + ", poster=" + poster + ", backdrop=" + backdrop + ", vote_average=" + (int)vote_average + ", vote_count=" + vote_count + ", view=" + view + ", runtime=" + runtime + ", release_date=" + release_date + ", create_at=" + create_at + ", video_link=" + video_link + ", quality=" + quality + ", category=" + category + '}';
    }

    public static void main(String[] args) {
        String str = "images/póster/anmangtrenchuyentautochanhphuongdong.png";
        System.out.println(str.substring(14));
    }

    
}
