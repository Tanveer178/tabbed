package com.example.abiduzair.tabbed;

/**
 * Created by AbidUzair on 03-10-2017.
 */
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class storiesadapter extends ArrayAdapter<stories> {

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



/**
 * {@link storiesadapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link stories} objects.
 */

    /**
     * Create a new {@link storiesadapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link stories}s to be displayed.
     */
    public storiesadapter(Context context, ArrayList<stories> words) {
        super(context, 0,words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_current, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        stories currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.tv1);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        titleTextView.setText(currentWord.getTitle());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView storyTextView = (TextView) listItemView.findViewById(R.id.tv2);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        storyTextView.setText(currentWord.getStory());


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}