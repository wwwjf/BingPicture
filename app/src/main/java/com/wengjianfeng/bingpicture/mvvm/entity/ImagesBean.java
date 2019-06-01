package com.wengjianfeng.bingpicture.mvvm.entity;

import com.wengjianfeng.bingpicture.AppConstants;

import java.util.List;

public class ImagesBean {

    public static final String BASE_URL= AppConstants.BASE_URL;

    /**
     * startdate : 20190528
     * fullstartdate : 201905280700
     * enddate : 20190529
     * url : /th?id=OHR.BeeWeek_EN-CN0043954357_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp
     * urlbase : /th?id=OHR.BeeWeek_EN-CN0043954357
     * copyright : Honey bee (Apis mellifera) covered in pollen in pumpkin, Germany (© Konrad Wothe/Minden Pictures)
     * copyrightlink : http://www.bing.com/search?q=scripps+national+spelling+bee&form=hpcapt&filters=HpDate:%2220190528_0700%22
     * title : The ‘Bee’ goes on
     * quiz : /search?q=Bing+homepage+quiz&filters=WQOskey:%22HPQuiz_20190528_BeeWeek%22&FORM=HPQUIZ
     * wp : true
     * hsh : b36e6f684d3ce6a1e1c89bb926782232
     * drk : 1
     * top : 1
     * bot : 1
     * hs : []
     */

    private String startdate;
    private String fullstartdate;
    private String enddate;
    private String url;
    private String urlbase;
    private String copyright;
    private String copyrightlink;
    private String title;
    private String quiz;
    private boolean wp;
    private String hsh;
    private int drk;
    private int top;
    private int bot;
    private List<?> hs;

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getFullstartdate() {
        return fullstartdate;
    }

    public void setFullstartdate(String fullstartdate) {
        this.fullstartdate = fullstartdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlbase() {
        return urlbase;
    }

    public void setUrlbase(String urlbase) {
        this.urlbase = urlbase;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCopyrightlink() {
        return copyrightlink;
    }

    public void setCopyrightlink(String copyrightlink) {
        this.copyrightlink = copyrightlink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public boolean isWp() {
        return wp;
    }

    public void setWp(boolean wp) {
        this.wp = wp;
    }

    public String getHsh() {
        return hsh;
    }

    public void setHsh(String hsh) {
        this.hsh = hsh;
    }

    public int getDrk() {
        return drk;
    }

    public void setDrk(int drk) {
        this.drk = drk;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBot() {
        return bot;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }

    public List<?> getHs() {
        return hs;
    }

    public void setHs(List<?> hs) {
        this.hs = hs;
    }
}
