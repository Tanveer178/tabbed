package com.example.abiduzair.tabbed;

/**
 * Created by AbidUzair on 03-10-2017.
 */


public class stories {
    private String mtitle;
    private String mstory;
    public stories(){}
    public stories(String title,String story)
    {
        mtitle=title;
        mstory=story;
    }
    public String getTitle() {
              return mtitle;
            }
    public String getStory() {
                return mstory;
           }
    public String toString()
           {
               return mtitle+"\n"+mstory;
           }
}
